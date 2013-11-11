package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import util.XLException;
import model.Slot;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
	}

	/*
	 * Template method. Opens a file and loads the data contained within. which
	 * means that we'll probably need the xl object as a parameter. we have to
	 * call a factory of some sort, and then load all the slots obtained from
	 * that factory into our xl object somehow.
	 */
	protected void action(String path) throws FileNotFoundException {
		try {
			statusLabel.setText("");
			XLBufferedReader reader = new XLBufferedReader(path);
			HashMap<String, Slot> map = new HashMap<String, Slot>();
			reader.load(map);
			xl.setData(map);
		} catch (XLException e) {
			statusLabel.setText("Cannot load file: "+e.getMessage());
		}

	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}