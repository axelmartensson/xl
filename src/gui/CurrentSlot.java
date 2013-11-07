package gui;

import java.util.Observable;
import java.util.Observer;

public class CurrentSlot extends Observable {
		private SlotLabel currentSlot;

		public CurrentSlot(SlotLabel slotLabel){
			currentSlot= slotLabel;
			addObserver(currentSlot);
			
		}

		public String getName(){
			return currentSlot.name();
		}
		
		public void set(SlotLabel slotLabel) {
		SlotLabel tempSlot = currentSlot;
		currentSlot = slotLabel;
		setChanged();
		notifyObservers();
		deleteObserver(tempSlot);
		addObserver(slotLabel);
		
	}
		

	

	

}
