package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import model.Sheet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabels extends GridPanel{

	private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;
    private Sheet sheet;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, Sheet sheet) {
    	super(rows + 1, cols);
    	labelList = new ArrayList<SlotLabel>(rows * cols);
    	this.currentSlot = currentSlot;
    	this.sheet = sheet;
    	addColumnIdentifiers(cols);
        addEmptySlots(rows, cols);
        SlotLabel firstLabel = labelList.get(0);
        currentSlot.set(firstLabel);
    }

    private void addColumnIdentifiers(int cols) {
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
	}

	private void addEmptySlots(int rows, int cols) {
		
		for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	StringBuilder stringBuilder = new StringBuilder();
            	stringBuilder.append(ch);
            	stringBuilder.append(row);
            	String name = stringBuilder.toString();
				SlotLabel label = new SlotLabel(name , currentSlot, sheet);
				add(label);
                labelList.add(label);
                
            }
        }
	}

	
}
