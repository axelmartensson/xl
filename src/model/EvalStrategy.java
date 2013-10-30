package model;

public interface EvalStrategy {
	double value(String content);
	String representation(String content);
}
