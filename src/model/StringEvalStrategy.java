package model;

import expr.Environment;

public class StringEvalStrategy implements EvalStrategy{

	@Override
	public double value(String content, Environment env)  { // throws XLEvalException
		// TODO Auto-generated method stub
		
		// throw new XLEvalException("Cannot evaluate comments as expression");
		return 0;
	}

	@Override
	public String representation(String content, Environment env) {
		// TODO Auto-generated method stub
		return content;
	}

}
