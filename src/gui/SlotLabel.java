package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SlotLabel extends ColoredLabel implements MouseListener{
    ;
    public SlotLabel() {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
		
		this.setBackground(Color.YELLOW);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    

}