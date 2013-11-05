package model;

import java.util.Observable;

import expr.Environment;

public interface Slot {

	double value(Environment env);
	
	/**
	 * the string representation of the content in the slot
	 * @param env
	 * @return
	 */
	String representation(Environment env);
		
	

}
