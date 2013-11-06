package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabels extends GridPanel implements MouseListener{

	private List<SlotLabel> labelList;
    private CurrentLabel currentLabel;

    public SlotLabels(int rows, int cols) {
    	super(rows + 1, cols);
    	labelList = new ArrayList<SlotLabel>(rows * cols);
    	addColumnIdentifiers(cols);
        addEmptySlots(rows, cols);
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentLabel = new CurrentLabel(firstLabel);
        
       
        
        
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
                SlotLabel label = new SlotLabel(currentLabel);
               
                add(label);
                labelList.add(label);
            }
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent MOUSE_PRESSED) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
}
