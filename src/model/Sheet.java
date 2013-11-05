package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import util.XLException;
import expr.Environment;

public class Sheet extends Observable implements Environment{
	private Map<String, Slot> slots;
	
	public Sheet() {
		this.slots = new HashMap<String, Slot>();
	}

	public Sheet(Map<String, Slot> slots) {
		this.slots = slots;
	}

	@Override
	public double value(String name) {
//		try{
		Slot slot = slots.get(name);
		if (slot == null){
			throw new XLException("Cannot refer to empty slot: "+name);
		}
		double value = slot.value(this);
//		} catch(XLEvalException e) { 
//			e.setAddress(name); // slap on an address
//			throw e; // and let somebody else worry about it
//		}
		return value;
	}

	public void putSlot(String name, String content){
			Slot slot = SlotFactory.build(content);
			slots.put(name, slot);
			setChanged();
			notifyObservers();
	}
	
	public void removeSlot(String name){
		slots.remove(name);
	}
	
	public String slotRepresentation(String name){
		Slot slot = slots.get(name);
		return slot.representation(this);
	}
	
	public String editorRepresentation (String name){
		Slot slot = slots.get(name);
		return slot.toString();
	}

}
