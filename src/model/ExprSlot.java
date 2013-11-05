package model;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;

import util.XLException;
import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class ExprSlot implements Slot {
	private Expr expr;
	public ExprSlot(String content){
		ExprParser parser = new ExprParser(); //used to create Expression from content
		try{
			expr = parser.build(content);
		} catch (IOException e){
			throw new XLException("failed to parse content: "+content);
		}
	}
	
	@Override
	public double value(Environment env) {
		return expr.value(env);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return expr.toString();
	}

	@Override
	public String representation(Environment env) {
		// TODO Auto-generated method stub
		return Double.toString(value(env));
	}
}
