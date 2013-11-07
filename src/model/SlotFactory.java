package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import util.XLException;
import expr.Expr;
import expr.ExprParser;

public class SlotFactory {
	public static Slot build(String content){
		
		if(content.length() > 0 && content.charAt(0) == '#'){
			Slot slot = new StringSlot(content);
			return slot;
		}
		
		ExprParser parser = new ExprParser(); //used to create Expression from content
		try{
			Expr expr = parser.build(content);
			Slot slot = new ExprSlot(expr);
			return slot;
		} catch (IOException e){
			throw new XLException("failed to parse content: "+content);
		}
	}
}