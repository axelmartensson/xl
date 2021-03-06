package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

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
		Slot slot = slots.get(name);
		if (slot == null){
			throw new XLException("Cannot refer to empty slot: "+name);
		}
		return slot.value(this);
	}

	public void putSlot(String name, String content){
			Slot slot = SlotFactory.build(content);
			checkForCircularDependency(name, slot);
			slots.put(name, slot);
			setChanged();
			notifyObservers();
	}
	
	private void checkForCircularDependency(String name, Slot slot) {
		Slot oldSlot = slots.get(name);
		Bomb bomb = new Bomb();
		slots.put(name, bomb);
		try {
			slot.value(this);
		} finally {
			slots.put(name, oldSlot);
		}
	}

	public void removeSlot(String name){
		Slot slot = slots.get(name);
		Bomb bomb = new Bomb();
		slots.put(name, bomb);
		try {
			for (Slot s : slots.values()) {
				if(s != bomb){
					s.value(this);
				}
			}
		} catch (XLException e) {
			slots.put(name, slot);
			throw new XLException("Cannot remove cell "+name);
		}
		slots.remove(name);
		setChanged();
		notifyObservers();
	}
	
	public String slotRepresentation(String name){
		Slot slot = slots.get(name);
		if(slot == null){
			return "";
		}
		return slot.representation(this);
	}
	
	public String editorRepresentation (String name){
		Slot slot = slots.get(name);
		if(slot == null){
			return "";
		}
		return slot.toString();
	}

	public Set<Entry<String, Slot>> getEntries() {
		return slots.entrySet();
	}
	
	public void load(Map<String, Slot> map) {
		Map<String, Slot> oldSlots = slots;
		slots = map;
		try {
			for (Entry<String, Slot> e : slots.entrySet()) {
				checkForCircularDependency(e.getKey(), e.getValue());
			}
		} catch (XLException e) {
			slots = oldSlots;
			throw e;
		}
		setChanged();
		notifyObservers();
	}

	public void clearAll() {
		slots = new HashMap<String, Slot>();
		setChanged();
		notifyObservers();
	}
}
