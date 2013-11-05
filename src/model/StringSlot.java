package model;

import expr.Environment;

public class StringSlot implements Slot{
	private String content;
	
	public StringSlot(String content){
		this.content=content;
	}

	@Override
	public double value(Environment env)  { // throws XLEvalException
		
		// throw new XLEvalException("Cannot evaluate comments as expression");
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return content;
	}

	@Override
	public String representation(Environment env) {
		// TODO Auto-generated method stub
		return toString();
	}

}
