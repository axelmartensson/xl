package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabels extends GridPanel{

	private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot) {
    	super(rows + 1, cols);
    	labelList = new ArrayList<SlotLabel>(rows * cols);
    	this.currentSlot = currentSlot;
    	addColumnIdentifiers(cols);
        addEmptySlots(rows, cols);
        SlotLabel firstLabel = labelList.get(0);
        //firstLabel.setBackground(Color.YELLOW); <- Beh�vs inte, kommer att kallas p� i currentSlot.set(firstLabel)
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
				SlotLabel label = new SlotLabel(name , currentSlot);
				add(label);
                labelList.add(label);
                
            }
        }
	}

	
}
