package listener.main;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.Case_stmtContext;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.For_declContext;
import generated.MiniCParser.For_stmtContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.ProgramContext;
import generated.MiniCParser.StmtContext;
import generated.MiniCParser.Switch_stmtContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;

import static listener.main.BytecodeGenListenerHelper.*;
import static listener.main.SymbolTable.*;

public class BytecodeGenListener extends MiniCBaseListener implements ParseTreeListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	SymbolTable symbolTable = new SymbolTable();
	
	int tab = 0;
	int label = 0;
	
	// program	: decl+
	
	@Override
	public void enterFun_decl(MiniCParser.Fun_declContext ctx) { //함수에 들어갈때 함수의 이름과 파라미터들을 symboltable에 넣는다.
		symbolTable.initFunDecl();
		String fname = getFunName(ctx);
		ParamsContext params;
		
		if (fname.equals("main")) {
			symbolTable.putLocalVar("args", Type.INTARRAY);
		} else {
			symbolTable.putFunSpecStr(ctx);
			params = (MiniCParser.ParamsContext) ctx.getChild(3);
			symbolTable.putParams(params);
		}		
	}

	
	// var_decl	: type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';'|type_spec IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) { //전역 변수
		String varName = ctx.IDENT().getText();
		
		if (isArrayDecl(ctx)) {
			symbolTable.putGlobalVar(varName, Type.INTARRAY); //type_spec IDENT '[' LITERAL ']' ';'
		}
		else if (isDeclWithInit(ctx)) {
			symbolTable.putGlobalVarWithInitVal(varName, Type.INT, initVal(ctx)); //type_spec IDENT '=' LITERAL ';'
		}
		else  { // simple decl
			symbolTable.putGlobalVar(varName, Type.INT); //type_spec IDENT ';'
		}
	}

	
	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) { // 지역 변수		
		if (isArrayDecl(ctx)) {
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);//type_spec IDENT '[' LITERAL ']' ';'
		}
		else if (isDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx)); //type_spec IDENT '=' LITERAL ';'
		}
		else  { // simple decl
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INT); //type_spec IDENT ';'
		}	
	}

	
	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) { //깊이 우선 탐색이 끝나면 newText에 저장되 있던 모든 값들을 확인 할 수 있다.
		String classProlog = getFunProlog();
		
		String fun_decl = "", var_decl = "";
		
		for(int i = 0; i < ctx.getChildCount(); i++) {
			if(isFunDecl(ctx, i))
				fun_decl += newTexts.get(ctx.decl(i));
			else
				var_decl += newTexts.get(ctx.decl(i));
		}
		
		newTexts.put(ctx, classProlog + var_decl + fun_decl);
		
		System.out.println(newTexts.get(ctx));
	}	
	
	
	// decl	: var_decl | fun_decl
	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		String decl = "";
		if(ctx.getChildCount() == 1)
		{
			if(ctx.var_decl() != null)				//var_decl
				decl += newTexts.get(ctx.var_decl());
			else							//fun_decl
				decl += newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, decl);
	}
	
	// stmt	: expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt
	@Override
	public void exitStmt(MiniCParser.StmtContext ctx) {
		String stmt = "";
		if(ctx.getChildCount() > 0)
		{
			if(ctx.expr_stmt() != null)				// expr_stmt
				stmt += newTexts.get(ctx.expr_stmt());
			else if(ctx.compound_stmt() != null)	// compound_stmt
				stmt += newTexts.get(ctx.compound_stmt());
			else if(ctx.if_stmt() != null) {	//if_stmt
				stmt += newTexts.get(ctx.if_stmt());
			}
			else if(ctx.while_stmt() != null) {	//while_stmt
				stmt += newTexts.get(ctx.while_stmt());
			}
			else if(ctx.return_stmt() !=null) { //return_stmt
				stmt += newTexts.get(ctx.return_stmt());
			}
			// <(0) Fill here>	///////////////
	}
		newTexts.put(ctx, stmt);
	}
	
	// expr_stmt	: expr ';'
	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		String stmt = "";
		if(ctx.getChildCount() == 2)
		{
			stmt += newTexts.get(ctx.expr());	// expr
		}
		newTexts.put(ctx, stmt);
	}
	
	
	// while_stmt	: WHILE '(' expr ')' stmt
	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
			// <(1) Fill here!>
		String stmt = "";
		String conExpr = newTexts.get(ctx.expr()); // 조건
		String whilestmt = newTexts.get(ctx.stmt()); // 조건 만족시 수행할 구문
		String Loop = symbolTable.newLabel(); //조건 만족시 Loop 라벨로 돌아가 반복
		String End = symbolTable.newLabel(); //조건 만족하지 않을시 end 라벨로 돌아가 끝냄
		
		stmt += Loop + ":\n"
				+ conExpr + ""
				+ "ifeq " + End + "\n"
				+ whilestmt + ""
				+ "goto " + Loop + "\n"
				+ End +":\n";
		
		newTexts.put(ctx, stmt);
		
	}
	
	//type_spec IDENT '(' params ')' compound_stmt
	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		String s1, s2;
		
		s1 = funcHeader(ctx, ctx.getChild(1).getText()); //함수 시작
		s2 = newTexts.get(ctx.compound_stmt()); //compound_stmt
		
		newTexts.put(ctx, s1 + s2 + ".end method \n"); 
		
		symbolTable.initFunDecl(); //함수가 끝나면 initFun 을 사용해 symbolTable의 id값들을 초기화 시킨다.
			// <(2) Fill here!>
	}
	

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) { //함수 시작할떄 나오는 어셈블리어
		return ".method public static " + symbolTable.getFunSpecStr(fname) + "\n"	
				+ "" + ".limit stack " 	+ getStackSize(ctx) + "\n"
				+ "" + ".limit locals " 	+ getLocalVarSize(ctx) + "\n";
				 	
	}
	
	
	
	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) { //전역 변수
		String varName = ctx.IDENT().getText();
		String varDecl = "";
		
		if (isDeclWithInit(ctx)) {
			varDecl += "putfield " + varName + "\n";  
			// v. initialization => Later! skip now..: 
		}
		newTexts.put(ctx, varDecl);
	}
	
	
	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) { //지역 변수
		String varDecl = "";
		
		if (isDeclWithInit(ctx)) {
			String vId = symbolTable.getVarId(ctx); // 지역변수들의 id를 설정해 준다.
			varDecl += "ldc " + ctx.LITERAL().getText() + "\n" //초기화가 되어있는 지역변수 일경우 
					+ "istore " + vId + "\n"; 			
		}
		
		newTexts.put(ctx, varDecl);
	}

	
	// compound_stmt	: '{' local_decl* stmt* '}'
	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		String[] s = new String[ctx.getChildCount()-2];
		int j = 0;
		int k = 0;
		int l = 0;
		String s1 ="";
		
		for(int i = 0; i < ctx.getChildCount(); i++) {
			if(ctx.getChild(i) instanceof Local_declContext) { // child is local
				s[l] = newTexts.get(ctx.local_decl(j)); //local_decl
				l++;
				j++;
			}
			else if(ctx.getChild(i) instanceof StmtContext) { // child is stmt
				s[l] = newTexts.get(ctx.stmt(k)); // stmt
				l++;
				k++;
			}
		}
		
		for(int i = 0; i < s.length; i++) {
			s1 += s[i] ;
		}
		
		newTexts.put(ctx, s1);
		// <(3) Fill here>
	}

	// if_stmt	: IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		String stmt = "";
		String condExpr= newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt(0));
		
		String lend = symbolTable.newLabel();
		String lelse = symbolTable.newLabel();
		
		
		if(noElse(ctx)) {	//IF '(' expr ')' stmt
			stmt += condExpr + "" //조건이 참이면 스택에 1이 쌓여있음
				+ "ifeq " + lend + "\n" //1이면 thenstmt 실행, 0이면 lend로 간다.
				+ thenStmt + ""
				+ lend + ":"  + "\n";	
		}
		else { //IF '(' expr ')' stmt ELSE stmt;
			String elseStmt = newTexts.get(ctx.stmt(1));
			stmt += condExpr + "" //조건이 참이면 스택에 1이 쌓여있음
					+ "ifeq " + lelse + "\n" //1이면 thenstmt 실행, 0이면 else로 간다.
					+ thenStmt + ""
					+ "goto " + lend + "\n" //then이 끝나면 end로
					+ lelse + ": \n" + elseStmt + ""
					+ lend + ":"  + "\n";	
		}
		
		newTexts.put(ctx, stmt);
	}
	
	
	// return_stmt	: RETURN ';' | RETURN expr ';'
	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		String s;
		
		if(ctx.getChildCount() == 2) { //RETURN ';'
			newTexts.put(ctx, "return \n");
		}
		else if(ctx.getChildCount() == 3){ //RETURN expr ';'
			String vId = symbolTable.getVarId(ctx.getChild(1).getText());
			s = "iload " + vId + "\n";
			newTexts.put(ctx,  s+"ireturn \n");
		}
			// <(4) Fill here> 
	}

	
	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		String expr = "";

		if(ctx.getChildCount() <= 0) {
			newTexts.put(ctx, ""); 
			return;
		}		
		
		if(ctx.getChildCount() == 1) { // IDENT | LITERAL
			if(ctx.IDENT() != null) {
				String idName = ctx.IDENT().getText();
				if(symbolTable.getVarType(idName) == Type.INT) {
					expr += "iload " + symbolTable.getVarId(idName) + " \n";
				}
				//else	// Type int array => Later! skip now..
				//	expr += "           lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
				} else if (ctx.LITERAL() != null) {
					String literalStr = ctx.LITERAL().getText();
					expr += "ldc " + literalStr + " \n";
				}
			} else if(ctx.getChildCount() == 2) { // UnaryOperation
			expr = handleUnaryExpr(ctx, newTexts.get(ctx) + expr);			
		}
		else if(ctx.getChildCount() == 3) {	 
			if(ctx.getChild(0).getText().equals("(")) { 		// '(' expr ')'
				expr = newTexts.get(ctx.expr(0));
				
			} else if(ctx.getChild(1).getText().equals("=")) { 	// IDENT '=' expr
				expr = newTexts.get(ctx.expr(0))
						+ "istore " + symbolTable.getVarId(ctx.IDENT().getText()) + " \n";
				
			} else { 											// binary operation
				expr = handleBinExpr(ctx, expr);
				
			}
		}
		// IDENT '(' args ')' |  IDENT '[' expr ']'
		else if(ctx.getChildCount() == 4) {
			if(ctx.args() != null){		// function calls
				expr = handleFunCall(ctx, expr);
			} else { // expr
				// Arrays: TODO  
			}
		}
		// IDENT '[' expr ']' '=' expr
		else { // Arrays: TODO			*/
		}
		newTexts.put(ctx, expr);
	}


	private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) { //단항 연산
		String l1 = symbolTable.newLabel();
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();
		
		expr += newTexts.get(ctx.expr(0));
		switch(ctx.getChild(0).getText()) {
		case "-":
			expr += "           ineg \n"; break;
		case "--":
			expr += "ldc 1" + "\n"
					+ "isub" + "\n";
			break;
		case "++":
			expr += "ldc 1" + "\n"
					+ "iadd" + "\n";
			break;
		case "!":
			expr += "ifeq " + l2 + "\n"
					+ l1 + ": " + "ldc 0" + "\n"
					+ "goto " + lend + "\n"
					+ l2 + ": " + "ldc 1" + "\n"
					+ lend + ": " + "\n";
			break;
		}
		return expr;
	}


	private String handleBinExpr(MiniCParser.ExprContext ctx, String expr) { // 이항 연산
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();
		
		expr += newTexts.get(ctx.expr(0));
		expr += newTexts.get(ctx.expr(1));
		
		switch (ctx.getChild(1).getText()) {
			case "*":
				expr += "imul \n"; break;
			case "/":
				expr += "idiv \n"; break;
			case "%":
				expr += "irem \n"; break;
			case "+":		// expr(0) expr(1) iadd
				expr += "iadd \n"; break;
			case "-":
				expr += "isub \n"; break;
				
			case "==":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "ifeq "+ l2 + "\n" //빼서 0이면 -> 같다는뜻 -> l2로 jump 같지않으면 쭉 실행
						+ "ldc 0" + "\n" //조건에 맞지 않으니 0을 스택에 쌓음
						+ "goto " + lend + "\n" //end
						+ l2 + ": \n" + "ldc 1" + "\n" //같으니 1을 스택에 쌓음
						+ lend + ": " + "\n";
				break;
			case "!=":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "ifne "+ l2 + "\n" //빼서 0이면 -> 같다는뜻 -> 쭉 실행, 같지않으면 l2로 jump 
						+ "ldc 0" + "\n" //조건에 맞지 않으니 0을 스택에 쌓음
						+ "goto " + lend + "\n" //end
						+ l2 + ": \n" + "ldc 1" + "\n" //같지 않으니 1을 스택에 쌓음
						+ lend + ": " + "\n";
				break;
			case "<=":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "ifle "+ l2+ "\n" //뺀게 0보다 작거나 같으면 -> 참 -> l2로 가서 1을 스택에 쌓음
						+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
						+ "goto " + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				// <(5) Fill here>
				break;
			case "<":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "iflt "+ l2+ "\n" //뺀게 0보다 작으면 -> 참 -> l2로 가서 1을 스택에 쌓음
						+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
						+ "goto " + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				// <(6) Fill here>
				break;

			case ">=":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "ifge "+ l2+ "\n" //뺀게 0보다 크거나 같으면 -> 참 -> l2로 가서 1을 스택에 쌓음
						+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
						+ "goto " + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				// <(7) Fill here>

				break;

			case ">":
				expr += "isub " + "\n" //2개의 expr을 뺀다.
						+ "ifgt "+ l2+ "\n" //뺀게 0보다 크면 -> 참 -> l2로 가서 1을 스택에 쌓음
						+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
						+ "goto " + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				// <(8) Fill here>
				break;

			case "and": //하나라도 0이면 거짓
				expr +=  "ifne "+ lend + "\n"  // stack 마지막에 있는 expr이 참이면 (1) lend로
						+ "pop" + "\n" + "ldc 0" + "\n" // 거짓이면 스택에 있는거 pop하고 무조건 0을 넣음
						+ lend + ": " + "\n"; break;
			case "or": //하나라도 1이면 참
				// <(9) Fill here>
				expr +=  "ifeq "+ lend + "\n" // stack 마지막에 있는 expr이 거짓이면 (0) lend로
						+ "pop" + "\n" + "ldc 1" + "\n" // 참이면 스택에 있는거 pop하고 무조건1을 넣음
						+ lend + ": " + "\n";
				break;

		}
		return expr;
	}
	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);		

		if (fname.equals("_print")) {		// System.out.println	
			expr = "getstatic java/lang/System/out Ljava/io/PrintStream; " + "\n"
			  		+ newTexts.get(ctx.args()) 
			  		+ "invokevirtual " + symbolTable.getFunSpecStr("_print") + "\n";
		} else {	
			expr = newTexts.get(ctx.args()) 
					+ "invokestatic " + getCurrentClassName()+ "/" + symbolTable.getFunSpecStr(fname) + "\n";
		}	
		
		return expr;
			
	}

	// args	: expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {

		String argsStr = "";
		
		for (int i=0; i < ctx.expr().size() ; i++) {
			argsStr += newTexts.get(ctx.expr(i)) ; 
		}		
		newTexts.put(ctx, argsStr);
	}
	@Override
	public void exitFor_decl(MiniCParser.For_declContext ctx) {
		// TODO Auto-generated method stub
		String for_dec = "";
		if(ctx.getChildCount() == 1) {
		String Expr= newTexts.get(ctx.expr());
		for_dec += Expr;
		}
		else {
			if (isForDeclWithInit(ctx)) {
				String vId = symbolTable.getForVarId(ctx.getText()); // 지역변수들의 id를 설정해 준다.
				for_dec += "ldc " + ctx.LITERAL().getText() + "\n" //초기화가 되어있는 지역변수 일경우 
						+ "istore " + vId + "\n";
			}
		}
		
		
	}
	@Override
	public void exitFor_stmt(For_stmtContext ctx) {
		// TODO Auto-generated method stub
		String stmt = "";
		String decl = newTexts.get(ctx.for_decl()); // 선언부
		String conExpr = newTexts.get(ctx.expr(0)); // 조건부
		String changeExpr = newTexts.get(ctx.expr(1));//증감부
		String dostmt = newTexts.get(ctx.stmt()); // 조건 만족시 수행할 구문
		String Loop = symbolTable.newLabel(); //조건 만족시 Loop 라벨로 돌아가 반복
		String End = symbolTable.newLabel(); //조건 만족하지 않을시 end 라벨로 돌아가 끝냄
		

		stmt += 	 decl + ""
				+Loop + ":\n"
				+ conExpr + ""
				+ "ifeq " + End + "\n"
				+ dostmt + ""
				+ changeExpr + ""
				+ "goto " + Loop + "\n"
				+ End +":\n";
		
		newTexts.put(ctx, stmt);
	}
	@Override
	public void enterFor_decl(MiniCParser.For_declContext ctx) {
		// TODO Auto-generated method stub
		if (isForDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getForLocalVarName(ctx), Type.INT, initForVal(ctx)); //type_spec IDENT '=' LITERAL ';'
		}
	}
	@Override
	public void exitSwitch_stmt(Switch_stmtContext ctx) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void exitCase_stmt(Case_stmtContext ctx) {
		// TODO Auto-generated method stub
		super.exitCase_stmt(ctx);
	}
	
}
