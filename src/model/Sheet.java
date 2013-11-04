package model;

import java.util.Map;

import expr.Environment;

public class Sheet implements Environment{
	private Map<String, Slot> slots;
	@Override
	public double value(String name) {
//		try{
		double value = slots.get(name).value(this);
//		} catch(XLEvalException e) { 
//			e.setAddress(name); // slap on an address
//			throw e; // and let somebody else worry about it
//		}
		return value;
	}

	public void setSlot(String name, String content){
		if(slots.containsKey(name)){
			//TODO a man's gotta do what a man's got to do
		} else {
			Slot slot = SlotFactory.build(content);
		}
	}

}
