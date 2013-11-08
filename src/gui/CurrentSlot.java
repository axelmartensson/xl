package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentSlot extends Observable {
		private SlotLabel currentSlot;
		
		public CurrentSlot(){
			
			
		}

		public String getName(){
			return currentSlot.name();
		}
		
		public void set(SlotLabel slotLabel) {
		slotLabel.setBackground(Color.YELLOW);
		currentSlot = slotLabel;
		addObserver(slotLabel);
		//System.out.println(currentSlot.name()); 
		setChanged();
		notifyObservers();
		
		
	}
		

	

	

}
