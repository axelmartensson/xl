package model;

import expr.ExprParser;

public class ExprEvalStrategy implements EvalStrategy {

	@Override
	public double value(String content) {
		// TODO Auto-generated method stub
		ExprParser parser = new ExprParser(); //used to create Expression from content
		//which is then evaluated and returned...
		return 0;
	}

	@Override
	public String representation(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
