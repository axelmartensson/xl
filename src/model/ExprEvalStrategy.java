package model;

import java.io.IOException;
import java.util.HashSet;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class ExprEvalStrategy implements EvalStrategy {

	@Override
	public double value(String content, Environment env) {
		// TODO Auto-generated method stub
		ExprParser parser = new ExprParser(); //used to create Expression from content
		try{
			Expr expr= parser.build(content);
			expr.value(env);
		} catch (IOException e){
			System.err.println("failed to parse content");
		}
		//which is then evaluated and returned...
		return 0;
	}

	@Override
	public String representation(String content, Environment env) {
		// TODO Auto-generated method stub
		return Double.toString(value(content, env));
	}

}
