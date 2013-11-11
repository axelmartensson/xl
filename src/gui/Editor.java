package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements Observer, ActionListener {
	private CurrentSlot currentSlot;
	private Sheet sheet;
	private StatusLabel status;

	public Editor(CurrentSlot currentSlot, Sheet sheet, StatusLabel label) {
		this.currentSlot = currentSlot;
		this.sheet = sheet;
		status = label;
		setBackground(Color.WHITE);
		addActionListener(this);
		currentSlot.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String name = currentSlot.getName();
		String representation = sheet.editorRepresentation(name);
		setText(representation);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Assuming user pressed Enter key
		status.setText("");
		String name = currentSlot.getName();
		String input = getText();
		if (input.equals("")) {
			
			try {
				sheet.removeSlot(name);
			} catch (Exception e) {
				status.setText(e.getMessage());
			}
			
		} else {
			
			try {
				sheet.putSlot(name, input);
			} catch (Exception e) {
				status.setText(e.getMessage());
			}
			
		}
	}

}