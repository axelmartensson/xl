package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
/** This is an Observable list that keeps track of XL instances.
 * 
 * By using the decorator pattern,
 * a normal arrayList is made
 * observable by delegating to the 
 * corresponding methods in ArrayList and then
 * calling setChanged() and notifyObservers()
 * 
 * @author axel
 *
 */
public class XLList extends Observable implements Iterable<XL> {
    private List<XL> list = new ArrayList<XL>();

    public void add(XL xl) {
        list.add(xl);
        setChanged();
        notifyObservers();
    }

    
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator<XL> iterator() {
        return list.iterator();
    }

    public XL last() {
        return list.get(list.size() - 1);
    }

    public void remove(XL xl) {
        list.remove(xl);
        setChanged();
        notifyObservers();
    }

    public void setChanged() {
        super.setChanged();
//        notifyObservers(); is called twice in methods if uncomment
    }
}