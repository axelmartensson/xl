package model;

import java.util.Map;

import expr.Environment;

public class Sheet implements Environment{
	private Map<String, Slot> slots;
	@Override
	public double value(String name) {
//		try{
		double value = slots.get(name).value();
//		} catch(XLEvalException e) { 
//			e.setAddress(name); // slap on an address
//			throw e; // and let somebody else worry about it
//		}
		return value;
	}

}
