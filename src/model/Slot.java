package model;

import java.util.Observable;

import expr.Environment;

public class Slot extends Observable {

	private String content;
	private EvalStrategy strategy;
	
	public void setStrategy(EvalStrategy strategy){
		this.strategy = strategy;
	}
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

}
