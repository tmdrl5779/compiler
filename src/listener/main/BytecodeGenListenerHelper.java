package listener.main;

import java.util.Hashtable;

import generated.MiniCParser;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.If_stmtContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import listener.main.SymbolTable;
import listener.main.SymbolTable.VarInfo;

public class BytecodeGenListenerHelper {
	
	// <boolean functions>
	
	static boolean isFunDecl(MiniCParser.ProgramContext ctx, int i) {
		return ctx.getChild(i).getChild(0) instanceof MiniCParser.Fun_declContext;
	}
	
	// type_spec IDENT '[' ']'
	static boolean isArrayParamDecl(ParamContext param) {
		return param.getChildCount() == 4;
	}
	
	// global vars
	static int initVal(Var_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	// var_decl	: type_spec IDENT '=' LITERAL ';
	static boolean isDeclWithInit(Var_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	// var_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static boolean isArrayDecl(Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	// <local vars>
	// local_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static int initVal(Local_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}
	
	// type_spec IDENT '[' LITERAL ']' ';'
	static boolean isArrayDecl(Local_declContext ctx) {
		return ctx.getChildCount() == 6;
	}
	
	// type_spec IDENT '=' LITERAL ';'
	static boolean isDeclWithInit(Local_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	
	static boolean isVoidF(Fun_declContext ctx) { //함수의 return형이 void인지 확인
		return "void".equals(ctx.type_spec().getText());
			// <Fill in>
	}
	
	static boolean isIntReturn(MiniCParser.Return_stmtContext ctx) { // return value ;
		return ctx.getChildCount() == 3;
	}


	static boolean isVoidReturn(MiniCParser.Return_stmtContext ctx) { // return ;
		return ctx.getChildCount() == 2;
	}
	
	// <information extraction>
	static String getStackSize(Fun_declContext ctx) { //max stacksize
		return "32";
	}
	static String getLocalVarSize(Fun_declContext ctx) { //max stacksize
		return "32";
	}
	static String getTypeText(Type_specContext typespec) { // type 출력
			// <Fill in>		
		return typespec.getText();
	}

	// params
	static String getParamName(ParamContext param) { //parameter IDENT출력
		return param.IDENT().getText();
		// <Fill in>
		
	}
	
	static String getParamTypesText(ParamsContext params) { //parameter type  int -> I 
		String typeText = "";
		
		for(int i = 0; i < params.param().size(); i++) {
			MiniCParser.Type_specContext typespec = (MiniCParser.Type_specContext)  params.param(i).getChild(0);
			if(getTypeText(typespec).equals("int")) {
				typeText += "I"; // + ";";
			}
			
		}
		return typeText;
	}
	
	static String getLocalVarName(Local_declContext local_decl) { //local 변수 이름 출럭
		return local_decl.getChild(1).getText();
		// <Fill in>
	}
	
	static String getFunName(Fun_declContext ctx) { // 정의 함수 이름 출력
		return ctx.getChild(1).getText();
		// <Fill in>
	}
	
	static String getFunName(ExprContext ctx) { // 호출 함수 이름 출력
		return ctx.getChild(0).getText();
		// <Fill in>
	}
	
	static boolean noElse(If_stmtContext ctx) { //else문이 아닐때
		return ctx.getChildCount() == 5;
	}
	
	static String getFunProlog() { //class start
		String s = "";
		 return "\n.class public "+ getCurrentClassName() +"\n"
				+ ".super java/lang/Object \n"
				+ ".method public <init>()V \n"
				+ "aload_0 \n"
		 		+ "invokenonvirtual java/lang/Object/<init>()V  \n"
		 		+ "return \n"
		 		+ ".end method \n";
	}
	
	static String getCurrentClassName() {
		return "Test";
	}
}
