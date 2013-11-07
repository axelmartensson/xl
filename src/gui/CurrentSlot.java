package gui;

import java.util.Observable;
import java.util.Observer;

public class CurrentSlot extends Observable {
		private SlotLabel currentslot;
		
		public CurrentSlot(){
			
		}

	
		public void set(SlotLabel slotLabel) {
		currentslot = slotLabel;
		setChanged();
		notifyObservers();
		
	}
		

	

	

}
