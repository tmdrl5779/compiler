﻿package listener.main;

import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.ArgsContext;
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
	int stackSize = 0; // Symbol Stack Offset
	private String thisFunName = "";
	Stack<Integer> StoreBlockDeclSize = new Stack<Integer>(); // StoreBlockDeclSize stack선언
	String[] caseJump;//case Label : case, case, case .......default, switchfinish
	Hashtable<Integer, String> hash = new Hashtable<Integer, String>(); //key: case문의 value,  vale: case에 해당하는 label
	int caseCount; // case 갯수
	int caseNumber; // case 횟수
	// program : decl+

	@Override
	public void enterFun_decl(MiniCParser.Fun_declContext ctx) { // 함수에 들어갈때 함수의 이름과 파라미터들을 symboltable에 넣는다.
		symbolTable.initFunDecl();
		String fname = getFunName(ctx);
		this.thisFunName = fname;

		ParamsContext params;

		if (fname.equals("main")) {
			symbolTable.putLocalVar("args", Type.INTARRAY);
		} else {
			symbolTable.putFunSpecStr(ctx);
			params = (MiniCParser.ParamsContext) ctx.getChild(3);
			symbolTable.putParams(params);
		}
	}

	// var_decl : type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';'|type_spec
	// IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) { // 전역 변수
		String varName = ctx.IDENT().getText();

		if (isArrayDecl(ctx)) {
			symbolTable.putGlobalVar(varName, Type.INTARRAY); // type_spec IDENT '[' LITERAL ']' ';'
		} else if (isDeclWithInit(ctx)) {
			symbolTable.putGlobalVarWithInitVal(varName, Type.INT, initVal(ctx)); // type_spec IDENT '=' LITERAL ';'
		} else { // simple decl
			symbolTable.putGlobalVar(varName, Type.INT); // type_spec IDENT ';'
		}
	}

	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) { // 지역 변수
		if (isArrayDecl(ctx)) {
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);// type_spec IDENT '[' LITERAL ']' ';'

		} else if (isDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx)); // type_spec IDENT '='
																								// LITERAL ';'

			symbolTable.putSymbolIntoHashTable(getLocalVarName(ctx), stackSize++); //scope를 확인하기 위해 hash table에 key를 변수, value를 stack size로 넣는다.
			symbolTable.putLocalVarIntoSymbolStack(getLocalVarName(ctx), Type.INT, initVal(ctx)); //stack에 변수를 쌓는다.
		} else { // simple decl
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INT); // type_spec IDENT ';'
			symbolTable.putSymbolIntoHashTable(getLocalVarName(ctx), stackSize++);  //scope를 확인하기 위해 hash table에 key를 변수, value를 stack size로 넣는다.
			symbolTable.putLocalVarIntoSymbolStack(getLocalVarName(ctx), Type.INT); //stack에 변수를 쌓는다.
		}
	}

	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) { // 깊이 우선 탐색이 끝나면 newText에 저장되 있던 모든 값들을 확인 할 수 있다.
		String classProlog = getFunProlog();

		String fun_decl = "", var_decl = "";
		int decl_size = 0;
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (isFunDecl(ctx, i))
				fun_decl += newTexts.get(ctx.decl(i));
			else {
				var_decl += newTexts.get(ctx.decl(i));
				decl_size++;
			}
				
		}
		String global_init ="";
		for(int i =0;i<decl_size;i++) {
			global_init+="aload_0\n"+"bipush "+ctx.decl(i).var_decl().LITERAL().getText()+"\n"
				+"putfield Test/"+ctx.decl(i).var_decl().IDENT().getText()+" I";	
			
			}
		newTexts.put(ctx, classProlog +var_decl+".method public <init>()V \n" //class 생성자에 있던 정보들을 global_init을 추가하여 생성
				+".limit stack 32\n"
				+".limit locals 32\n"
				+global_init+"\n"
				+ "aload_0 \n"
		 		+ "invokenonvirtual java/lang/Object/<init>()V  \n"
		 		+ "return \n"
		 		+ ".end method \n"+ fun_decl);

		System.out.println(newTexts.get(ctx));
	}

	// decl : var_decl | fun_decl
	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		String decl = "";
		if (ctx.getChildCount() == 1) {
			if (ctx.var_decl() != null) // var_decl
				decl += newTexts.get(ctx.var_decl());
			else // fun_decl
				decl += newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, decl);
	}

	// stmt : expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt
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
			else if(ctx.switch_stmt() != null) { //switch_stmt
				stmt += newTexts.get(ctx.switch_stmt());
			}
			else if(ctx.case_stmt() != null) {	//case_stmt
				stmt += newTexts.get(ctx.case_stmt());
			}
			else if(ctx.for_stmt() != null) { //for_stmt
				stmt += newTexts.get(ctx.for_stmt());
			}
			// <(0) Fill here>	///////////////
	}
		newTexts.put(ctx, stmt);
	}

	// expr_stmt : expr ';'
	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() == 2) {
			stmt += newTexts.get(ctx.expr()); // expr
		}
		newTexts.put(ctx, stmt);
	}

	// while_stmt : WHILE '(' expr ')' stmt
	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
		// <(1) Fill here!>
		String stmt = "";
		String conExpr = newTexts.get(ctx.expr()); // 조건
		String whilestmt = newTexts.get(ctx.stmt()); // 조건 만족시 수행할 구문
		String Loop = symbolTable.newLabel(); // 조건 만족시 Loop 라벨로 돌아가 반복
		String End = symbolTable.newLabel(); // 조건 만족하지 않을시 end 라벨로 돌아가 끝냄

		stmt += Loop + ":\n" + conExpr + "" + "ifeq " + End + "\n" + whilestmt + "" + "goto " + Loop + "\n" + End
				+ ":\n";

		newTexts.put(ctx, stmt);

	}

	// type_spec IDENT '(' params ')' compound_stmt
	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		String s1, s2;

		s1 = funcHeader(ctx, ctx.getChild(1).getText()); // 함수 시작
		s2 = newTexts.get(ctx.compound_stmt()); // compound_stmt
		
		newTexts.put(ctx, s1 + s2 + ".end method \n");

		symbolTable.initFunDecl(); // 함수가 끝나면 initFun 을 사용해 symbolTable의 id값들을 초기화 시킨다.
		// <(2) Fill here!>
	}

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) { // 함수 시작할떄 나오는 어셈블리어
		return ".method public static " + symbolTable.getFunSpecStr(fname) + "\n" + "" + ".limit stack "
				+ getStackSize(ctx) + "\n" + "" + ".limit locals " + getLocalVarSize(ctx) + "\n";

	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) { // 전역 변수
		String varName = ctx.IDENT().getText();
		String varDecl = "";
		String type = "";
		if (symbolTable.getVarType(varName) == Type.INT) {
			type = "I";
		}

		if (isDeclWithInit(ctx)) {
			String value = ctx.LITERAL().getText();
			varDecl = ".field " + varName + " " + type + " = " + value + "\n"; // field 사용해서 전역변수 선언

		} else {
			varDecl = ".field " + varName + " " + type + " = 0" + "\n"; // 초기화 안돼있을때 field 사용해서 전역변수 =0 선언
		}

		newTexts.put(ctx, varDecl);
	}

	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) { // 지역 변수
		String varDecl = "";

		if (isDeclWithInit(ctx)) {
			String vId = symbolTable.getVarId(ctx); // 지역변수들의 id를 설정해 준다.

			varDecl += "ldc " + ctx.LITERAL().getText() + "\n" // 초기화가 되어있는 지역변수 일경우
					+ "istore " + vId + "\n";
		}

		newTexts.put(ctx, varDecl);
	}

	// compound_stmt : '{' local_decl* stmt* '}' | ':' local_decl* stmt* 
	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {   
		String[] s;
		if("{".equals(ctx.getChild(0).getText())) { //'{' local_decl* stmt* '}'
			s = new String[ctx.getChildCount()-2];
		}
		else {										//':' local_decl* stmt* 
			s = new String[ctx.getChildCount()-1];
		}
		
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

	// if_stmt : IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		String stmt = "";
		String condExpr = newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt(0));

		String lend = symbolTable.newLabel();
		String lelse = symbolTable.newLabel();

		if (noElse(ctx)) { // IF '(' expr ')' stmt
			stmt += condExpr + "" // 조건이 참이면 스택에 1이 쌓여있음
					+ "ifeq " + lend + "\n" // 1이면 thenstmt 실행, 0이면 lend로 간다.
					+ thenStmt + "" + lend + ":" + "\n";
		} else { // IF '(' expr ')' stmt ELSE stmt;
			String elseStmt = newTexts.get(ctx.stmt(1));
			stmt += condExpr + "" // 조건이 참이면 스택에 1이 쌓여있음
					+ "ifeq " + lelse + "\n" // 1이면 thenstmt 실행, 0이면 else로 간다.
					+ thenStmt + "" + "goto " + lend + "\n" // then이 끝나면 end로
					+ lelse + ": \n" + elseStmt + "" + lend + ":" + "\n";
		}

		newTexts.put(ctx, stmt);
	}

	// return_stmt : RETURN ';' | RETURN expr ';'
	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		String s;

		if (ctx.getChildCount() == 2) { // RETURN ';'
			newTexts.put(ctx, "return \n");
		} else if (ctx.getChildCount() == 3) { // RETURN expr ';'
			String vId = symbolTable.getVarId(ctx.getChild(1).getText());
			s = "iload " + vId + "\n";
			newTexts.put(ctx, s + "ireturn \n");
		}
		// <(4) Fill here>
	}

	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		String expr = "";

		if (ctx.getChildCount() <= 0) {
			newTexts.put(ctx, "");
			return;
		}

		if (ctx.getChildCount() == 1) { // IDENT | LITERAL
			if (ctx.IDENT() != null) {
				String idName = symbolTable.getVarId(ctx.IDENT().getText());
				String name = ctx.IDENT().getText();
				if (symbolTable.isGlobalVar(name)) {
					String classref = "";
					String tempVar = symbolTable.newTempVar();
					if (this.thisFunName.equals("main")) {
						
						classref = "new Test\n" + "dup\n" + "invokespecial Test/<init>()V"+"\nastore "+tempVar+"\n"; //객체 선언 및 호출
					}
					else {
						classref = "astore "+tempVar+"\n"; //객체 호출
					}

					expr += classref+"aload "+tempVar+"\n"+"getfield " + "Test/" + name + " I\n"; // global var

				}

				else if (symbolTable.isDeclinedVar(name)) {// local var
					expr += "iload " + idName + " \n";
				}

				// else // Type int array => Later! skip now..

				// expr += "lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
			}

			else if (ctx.LITERAL() != null) {// constant
				String literalStr = ctx.LITERAL().getText();
				expr += "ldc " + literalStr + " \n";
			}
		} else if (ctx.getChildCount() == 2) { // UnaryOperation
			expr = handleUnaryExpr(ctx, newTexts.get(ctx) + expr);
		} else if (ctx.getChildCount() == 3) {
			if (ctx.getChild(0).getText().equals("(")) { // '(' expr ')'
				expr = newTexts.get(ctx.expr(0));
			}

			else if (ctx.getChild(1).getText().equals("=")) { // IDENT '=' expr
				String idName = ctx.IDENT().getText();
				if (symbolTable.isDeclinedVar(idName)) { //선언된 변수가 있는지 확인
					expr = newTexts.get(ctx.expr(0)) + "istore " + symbolTable.getVarId(ctx.IDENT().getText()) + " \n"; 

				} else if (symbolTable.isGlobalVar(idName)) { //전역변수
					
					
					String tempVar="0";
					if (this.thisFunName.equals("main")) {
						tempVar = symbolTable.newTempVar();
						expr = "new Test\n" + "dup\n" + "invokespecial Test/<init>()V\n" + "astore "+tempVar+"\n"; // 객체 선언, 저장
					}

					// global var
					expr += "aload "+tempVar+"\n"+ newTexts.get(ctx.expr(0)) + "putfield Test/" + idName + " " + "I\n"; //전역변수 저장

				} else {
					expr += "aload 0\n" + newTexts.get(ctx.expr(0)) + "putfield Test/" + idName + " " + "I\n"; //전역변수 저장
				}
				
				
			}
			else {
				expr = handleBinExpr(ctx, expr);
			}
		}

		// IDENT '(' args ')' | IDENT '[' expr ']'

		else if (ctx.getChildCount() == 4)

		{
			if (ctx.args() != null) { // function calls
				expr = handleFunCall(ctx, expr);
			} else { // expr
				// Arrays: TODO
			}
		}

		// IDENT '[' expr ']' '=' expr

	
		newTexts.put(ctx, expr);

	}

	private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) { // 단항 연산
		String l1 = symbolTable.newLabel();
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();

		expr += newTexts.get(ctx.expr(0));
		switch (ctx.getChild(0).getText()) {
		case "-":
			expr += "           ineg \n";
			break;
		case "--":
			expr += "ldc 1" + "\n" + "isub" + "\n";
			break;
		case "++":
			expr += "ldc 1" + "\n" + "iadd" + "\n";
			break;
		case "!":
			expr += "ifeq " + l2 + "\n" + l1 + ": " + "ldc 0" + "\n" + "goto " + lend + "\n" + l2 + ": " + "ldc 1"
					+ "\n" + lend + ": " + "\n";
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
			expr += "imul \n";
			break;
		case "/":
			expr += "idiv \n";
			break;
		case "%":
			expr += "irem \n";
			break;
		case "+": // expr(0) expr(1) iadd
			expr += "iadd \n";
			break;
		case "-":
			expr += "isub \n";
			break;

		case "==":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "ifeq " + l2 + "\n" // 빼서 0이면 -> 같다는뜻 -> l2로 jump 같지않으면 쭉 실행
					+ "ldc 0" + "\n" // 조건에 맞지 않으니 0을 스택에 쌓음
					+ "goto " + lend + "\n" // end
					+ l2 + ": \n" + "ldc 1" + "\n" // 같으니 1을 스택에 쌓음
					+ lend + ": " + "\n";
			break;
		case "!=":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "ifne " + l2 + "\n" // 빼서 0이면 -> 같다는뜻 -> 쭉 실행, 같지않으면 l2로 jump
					+ "ldc 0" + "\n" // 조건에 맞지 않으니 0을 스택에 쌓음
					+ "goto " + lend + "\n" // end
					+ l2 + ": \n" + "ldc 1" + "\n" // 같지 않으니 1을 스택에 쌓음
					+ lend + ": " + "\n";
			break;
		case "<=":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "ifle " + l2 + "\n" // 뺀게 0보다 작거나 같으면 -> 참 -> l2로 가서 1을 스택에 쌓음
					+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
					+ "goto " + lend + "\n" + l2 + ": \n" + "ldc 1" + "\n" + lend + ": " + "\n";
			// <(5) Fill here>
			break;
		case "<":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "iflt " + l2 + "\n" // 뺀게 0보다 작으면 -> 참 -> l2로 가서 1을 스택에 쌓음
					+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
					+ "goto " + lend + "\n" + l2 + ": \n" + "ldc 1" + "\n" + lend + ": " + "\n";
			// <(6) Fill here>
			break;

		case ">=":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "ifge " + l2 + "\n" // 뺀게 0보다 크거나 같으면 -> 참 -> l2로 가서 1을 스택에 쌓음
					+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
					+ "goto " + lend + "\n" + l2 + ": \n" + "ldc 1" + "\n" + lend + ": " + "\n";
			// <(7) Fill here>

			break;

		case ">":
			expr += "isub " + "\n" // 2개의 expr을 뺀다.
					+ "ifgt " + l2 + "\n" // 뺀게 0보다 크면 -> 참 -> l2로 가서 1을 스택에 쌓음
					+ "ldc 0" + "\n" // 거짓 -> 0을 스택에 쌓음
					+ "goto " + lend + "\n" + l2 + ": \n" + "ldc 1" + "\n" + lend + ": " + "\n";
			// <(8) Fill here>
			break;

		case "and": // 하나라도 0이면 거짓
			expr += "ifne " + lend + "\n" // stack 마지막에 있는 expr이 참이면 (1) lend로
					+ "pop" + "\n" + "ldc 0" + "\n" // 거짓이면 스택에 있는거 pop하고 무조건 0을 넣음
					+ lend + ": " + "\n";
			break;
		case "or": // 하나라도 1이면 참
			// <(9) Fill here>
			expr += "ifeq " + lend + "\n" // stack 마지막에 있는 expr이 거짓이면 (0) lend로
					+ "pop" + "\n" + "ldc 1" + "\n" // 참이면 스택에 있는거 pop하고 무조건1을 넣음
					+ lend + ": " + "\n";
			break;

		}
		return expr;
	}

	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);

		if (fname.equals("_print")) { // System.out.println
			expr = "getstatic java/lang/System/out Ljava/io/PrintStream; " + "\n" + newTexts.get(ctx.args())
					+ "invokevirtual " + symbolTable.getFunSpecStr("_print") + "\n";
		} else {
			expr = newTexts.get(ctx.args()) + "invokestatic " + getCurrentClassName() + "/"
					+ symbolTable.getFunSpecStr(fname) + "\n";
		}

		return expr;

	}

	// args : expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {

		String argsStr = "";

		for (int i = 0; i < ctx.expr().size(); i++) {
			argsStr += newTexts.get(ctx.expr(i));
		}
		newTexts.put(ctx, argsStr);
	}

	@Override
	public void exitFor_decl(MiniCParser.For_declContext ctx) {
		// TODO Auto-generated method stub
		String for_dec = "";
		if (ctx.getChildCount() == 1) { //expr일 경우 i = 0
			String Expr = newTexts.get(ctx.expr());
			for_dec += Expr;
		} else { //for_decl일 경우 int i = 0

			String vId = symbolTable.getVarId(ctx.IDENT().getText()); // 지역변수들의 id를 설정해 준다.
			for_dec += "ldc " + ctx.LITERAL().getText() + "\n" // 초기화가 되어있는 지역변수 일경우
					+ "istore " + vId + "\n";
		}

		newTexts.put(ctx, for_dec);
	}

	@Override
	public void exitFor_stmt(For_stmtContext ctx) {
		// TODO Auto-generated method stub
		String stmt = "";
		String decl = newTexts.get(ctx.for_decl()); // 선언부
		String conExpr = newTexts.get(ctx.expr(0)); // 조건부
		String changeExpr = newTexts.get(ctx.expr(1));// 증감부
		String dostmt = newTexts.get(ctx.stmt()); // 조건 만족시 수행할 구문
		String Loop = symbolTable.newLabel(); // 조건 만족시 Loop 라벨로 돌아가 반복
		String End = symbolTable.newLabel(); // 조건 만족하지 않을시 end 라벨로 돌아가 끝냄

		stmt += decl + "" + Loop + ":\n" + conExpr + "" + "ifeq " + End + "\n" + dostmt + "" + changeExpr + "" + "goto "
				+ Loop + "\n" + End + ":\n";

		newTexts.put(ctx, stmt);
		int blockDeclSize = this.StoreBlockDeclSize.pop(); // 블럭의 decl size를 스택에서 pop시킨다.
		this.stackSize -= blockDeclSize; // stack 사이즈를 블럭의 decl크기 만큼 줄인다.
		symbolTable.popLocalBlockFromSymbolStackByOffset(blockDeclSize); // 해당block에서 사용가능한  모든 decl pop 

		for (int i = 0; i < blockDeclSize - 1; i++) {
			symbolTable.removeSymbolInHashTable(ctx.stmt().compound_stmt().local_decl(i).IDENT().getText()); //hashtable에서 해당 변수 삭제
		}
		symbolTable.removeSymbolInHashTable(ctx.for_decl().IDENT().getText()); //hashtable에서 해당 변수를 삭제한다.
		symbolTable.initBlockDecl(blockDeclSize); //block된 변수의 사이즈만큼 스택에서 빼준다

	}

	@Override
	public void enterFor_decl(MiniCParser.For_declContext ctx) {
		// TODO Auto-generated method stub
		if (isForDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getForLocalVarName(ctx), Type.INT, initForVal(ctx)); // type_spec IDENT
																									// '=' LITERAL ';'
		}

	}

	@Override
	public void enterFor_stmt(For_stmtContext ctx) {
		List<Local_declContext> localDeclList = ctx.stmt().compound_stmt().local_decl();	//for문에서 선언한 선언문 list
		For_declContext forDecl = ctx.for_decl();	//for 선언문
		String varName = forDecl.IDENT().getText();	//for 선언문 identity
		Type type = Type.INT;
		String initVar = forDecl.LITERAL().getText();//for 선언문 초기화값
		symbolTable.putSymbolIntoHashTable(varName, stackSize++);	//선언문 변수 심볼 해쉬테이블에 put
		if (initVar != null) //초기화값이 없는 선언문일때
			symbolTable.putLocalVarIntoSymbolStack(varName, type, Integer.parseInt(initVar));
		else	//초기화값이 있는 선언문일때
			symbolTable.putLocalVarIntoSymbolStack(varName, type);

		for (int i = 0; i < localDeclList.size(); i++) { //모든 변수선언문에 대해 심볼 해쉬테이블에 put
			varName = localDeclList.get(i).IDENT().getText();
			type = Type.INT;
			initVar = localDeclList.get(i).LITERAL().getText();
			symbolTable.putSymbolIntoHashTable(localDeclList.get(i).IDENT().getText(), stackSize++);
			if (initVar != null)
				symbolTable.putLocalVarIntoSymbolStack(varName, type, Integer.parseInt(initVar)); //심볼테이블 스택에 put
			else
				symbolTable.putLocalVarIntoSymbolStack(varName, type);	//
		}
		this.StoreBlockDeclSize.add(localDeclList.size() + 1); //블럭의 decl가 몇개인지를 stack에 add한다.
	}

	@Override
	public void enterSwitch_stmt(Switch_stmtContext ctx) {
		// TODO Auto-generated method stub
		caseCount = ctx.stmt().compound_stmt().stmt().size(); //case문 + default 갯수
		caseJump = new String[caseCount+1]; // case, case, case ..... dafault switchFinish
		for(int i = 0; i < caseCount; i++) { // 각 case의 label
			caseJump[i] = symbolTable.newLabel();
		}
		caseJump[caseJump.length-1] = symbolTable.newLabel(); //switchFinish
	}
	
	@Override
	public void exitSwitch_stmt(Switch_stmtContext ctx) {
		// TODO Auto-generated method stub
		String s = newTexts.get(ctx.expr());
		String lookuptswitch = "lookupswitch \n";
		String value = "";
		String default_ = "";
		int key;
		PriorityQueue<Integer> lookUpTableSort = new PriorityQueue<>(); 
		for(int i = 0; i < caseCount; i++) {
			if(ctx.stmt().compound_stmt().stmt(i).case_stmt().getChildCount() == 4) { // case문일때
				value = ctx.stmt().compound_stmt().stmt(i).case_stmt().LITERAL().getText();
				lookUpTableSort.add(Integer.parseInt(value)); //lookuptable sort
				hash.put(Integer.parseInt(value), caseJump[i]); //switch문 key랑 label
			}
			else {
				default_ = ctx.stmt().compound_stmt().stmt(i).case_stmt().DAFAULT().getText(); //default일때 바로 아래로 내려감 스위치 빠져나가는 label 안써줌
			}
			
		}
		
		for(int i = 0; i < caseCount; i++) {
			if(i == caseCount-1) {
				lookuptswitch += default_ + ": " + caseJump[i] + "\n";
			}
			else {
				key = lookUpTableSort.remove();
				lookuptswitch += key +": " + hash.get(key) + "\n"; //key : label
			}
			
		}
		
		String switchFinish = caseJump[caseJump.length-1];
		
		String stmts = newTexts.get(ctx.stmt());
		caseNumber = 0;
		newTexts.put(ctx, s+ lookuptswitch + stmts + caseJump[caseJump.length-1] + ":\n");
	}

	@Override
	public void exitCase_stmt(Case_stmtContext ctx) { // case문
		// TODO Auto-generated method stub
		
		
		String case_ = caseJump[caseNumber] + ":\n" + newTexts.get(ctx.stmt());
		if(!"default".equals(ctx.getChild(0).getText())) { // default가 아니고 case일때
			if("break;".equals(ctx.BREAK().getText())) { //break가 있을 경우 switch를 나간다.
				case_ += "goto " + caseJump[caseJump.length-1] + "\n"; //break있으면 switch return
			}
		}
		
		caseNumber++; //case 횟수 증가.
		newTexts.put(ctx, case_);
		
	}

}
