package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentSlot extends Observable {
	private SlotLabel currentSlot;

	public String getName() {
		return currentSlot.name();
	}

	public void set(SlotLabel slotLabel) {
		currentSlot = slotLabel;
		setChanged();
		notifyObservers();
		addObserver(slotLabel);
	}

	public void setWhite(){
		currentSlot.setBackground(Color.WHITE);
	}

}
