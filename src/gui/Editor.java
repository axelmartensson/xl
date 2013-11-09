package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements Observer, ActionListener{
	private CurrentSlot currentSlot;
	private Sheet sheet;
    public Editor(CurrentSlot currentSlot, Sheet sheet) {
    	this.currentSlot = currentSlot;
    	this.sheet = sheet;
        setBackground(Color.WHITE);
        addActionListener(this);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		String name = currentSlot.getName();
		String representation = sheet.editorRepresentation(name);
		setText(representation);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Assuming user pressed Enter key
		String name = currentSlot.getName();
		String input = getText();
		sheet.putSlot(name, input);
		setText("");
	}
    
    
}