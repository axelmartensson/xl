package model;
import expr.Environment;
public interface EvalStrategy {
	double value(String content, Environment env);
	String representation(String content, Environment env);
}
