package model;

import java.util.Observable;
import java.util.Observer;

import expr.Environment;

public class Slot extends Observable implements Observer {

	private String content;
	private EvalStrategy strategy;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

}
