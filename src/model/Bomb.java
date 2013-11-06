package model;

import util.XLException;
import expr.Environment;

public class Bomb implements Slot{

	@Override
	public double value(Environment env) {
		throw new XLException("Circular dependencies detected");
	}

	@Override
	public String representation(Environment env) {
		throw new XLException("The bomb does not have a representation");
	}
}
