package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
/**
 * Keeps track of the currently focused label
 * used in StatusPanel
 * @author axel
 *
 */
public class CurrentLabel extends ColoredLabel implements Observer {
	//private CurrentSlot currentSlot;
	
    public CurrentLabel(CurrentSlot currentSlot) {
        super("A1", Color.WHITE);
        //this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
       
    }
    
    
    @Override
	public void update(Observable o, Object name) {
    	setText((String) name);
	}
}