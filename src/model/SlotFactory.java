package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class SlotFactory {
	public static Slot build(String content){
		//TODO implement
		return null;
	}

	public static Map<String, Slot> build(Reader r) throws IOException{
		BufferedReader reader = new BufferedReader(r);
		Map<String, Slot> slots = new HashMap<String, Slot>();
		String line;
		while((line = reader.readLine()) != null){
			String[] tokens = line.split("=");
			String name = tokens[0];
			String content = tokens[1];
			slots.put(name, build(content));
		}
		return slots;
	}
}