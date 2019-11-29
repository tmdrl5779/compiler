package listener.main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import generated.MiniCParser;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import listener.main.SymbolTable.Type;
import static listener.main.BytecodeGenListenerHelper.*;


public class SymbolTable {
	enum Type {
		INT, INTARRAY, VOID, ERROR
	}
	
	static public class VarInfo {
		Type type; 
		int id;
		int initVal;
		
		public VarInfo(Type type,  int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}
		public VarInfo(Type type,  int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}
	
	static public class FInfo {
		public String sigStr;
	}
	
	private Map<String, VarInfo> _lsymtable = new HashMap<>();	// local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>();	// global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>();	// function 
	
		
	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;
	
	SymbolTable(){
		initFunDecl();
		initFunTable();
	}
	
	void initFunDecl(){		// at each func decl
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;		
	}
	
	void putLocalVar(String varname, Type type){
		VarInfo varinfo = new VarInfo(type,  _localVarID++); //변수 이름을 key값으로 하고 varinfo 객체를 table에 넣는다.
	
		_lsymtable.put(varname, varinfo);
		//<Fill here>
	}
	
	void putGlobalVar(String varname, Type type){
		VarInfo varinfo = new VarInfo(type, _globalVarID++); //변수 이름을 key값으로 하고 varinfo 객체를 table에 넣는다.
		
		_gsymtable.put(varname, varinfo);
		//<Fill here>
	}
	
	void putLocalVarWithInitVal(String varname, Type type, int initVar){//변수 이름을 key값으로 하고 varinfo 객체를 table에 넣는다.
		VarInfo varinfo = new VarInfo(type, _localVarID++ , initVar);
		
		_lsymtable.put(varname, varinfo);
		//<Fill here>
	}
	void putGlobalVarWithInitVal(String varname, Type type, int initVar){ //변수 이름을 key값으로 하고 varinfo 객체를 table에 넣는다.
		VarInfo varinfo = new VarInfo(type, _globalVarID++, initVar);
		
		_gsymtable.put(varname, varinfo);
		//<Fill here>
	
	}
	
	void putParams(MiniCParser.ParamsContext params) { // parameter도 local에서 사용되기 때문에 local symboltable에 저장한다.
		for(int i = 0; i < params.param().size(); i++) {
		//<Fill here>
			String paramtype = params.param().get(i).getChild(0).getText(); //parameter type
			String paramname = params.param().get(i).getChild(1).getText(); //parameter name
			//isDeclWithInit(params.param().get(i));
			if(paramtype.equals(Type.INT.name().toLowerCase())) {
				putLocalVar(paramname, Type.INT);
			}
			else {
				putLocalVar(paramname, Type.ERROR);
			}
			
		}
	}
	
	private void initFunTable() {
		FInfo printlninfo = new FInfo();
		printlninfo.sigStr = "java/io/PrintStream/println(I)V"; // systme.out.println(); 어셈블리어
		
		FInfo maininfo = new FInfo(); 
		maininfo.sigStr = "main([Ljava/lang/String;)V"; // main함수 어셈블리어
		_fsymtable.put("_print", printlninfo);
		_fsymtable.put("main", maininfo);
	}
	
	public String getFunSpecStr(String fname) {	 // 함수의 이름(매개변수타입)리턴타입 을 얻는다.
		FInfo fun = _fsymtable.get(fname);
		return fun.sigStr;
		// <Fill here>
	}

	public String getFunSpecStr(Fun_declContext ctx) { // 함수의 이름(매개변수타입)리턴타입 을 얻는다.
		FInfo fun = _fsymtable.get(getFunName(ctx));
		return fun.sigStr;
		// <Fill here>	
	}
	
	public String putFunSpecStr(Fun_declContext ctx) { // 함수의 이름(매개변수타입)리턴타입 을 저장한다. -> 나중에 함수 호출, 정의때 사용
		String fname = getFunName(ctx);
		String argtype = "";	
		String rtype = "";
		String res = "";
		
		argtype = getParamTypesText(ctx.params());
		
		if(getTypeText(ctx.type_spec()).equals("int")) {
			rtype = "I";
		}
		else {
			rtype = "V";
		}
		
		// <Fill here>	
		
		res =  fname + "(" + argtype + ")" + rtype;
		
		FInfo finfo = new FInfo();
		finfo.sigStr = res;
		_fsymtable.put(fname, finfo);
		
		return res;
	}
	
	String getVarId(String name){ //변수 id를 얻는다.
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return String.valueOf(lvar.id);
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return String.valueOf(gvar.id);
		}
		
		return null;	
		
		
		// <Fill here>	
	}
	
	Type getVarType(String name){ //변수 id를 얻는다.
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}
		
		return Type.ERROR;	
	}
	String newLabel() { // label 에 id를 붙여준다.
		return "label" + _labelID++;
	}
	
	String newTempVar() { //max stack이 32 이므로 하나의 변수를 사용할때마나 --
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) { //변수 id를 얻는다.
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
		// <Fill here>	
	}

	// local
	public String getVarId(Local_declContext ctx) { //변수 id를 얻는다.
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}
	
}
