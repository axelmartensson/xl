package gui.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import model.Slot;
import model.SlotFactory;
import util.XLException;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> slots) {
        try {
            while (ready()) {
                String line = readLine();
                String[] tokens = line.split("=");
                String name = tokens[0];
                String content = tokens[1];
                slots.put(name, SlotFactory.build(content));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
