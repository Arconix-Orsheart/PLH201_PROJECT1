package org.tuc.staticlists;

import org.tuc.Element;
import org.tuc.tools.Globals;
import org.tuc.tools.MultiCounter;

public class SAAList extends AAList {

    /**
     * Initiating List 2b
     * 
     * @constructor
     */
    public SAAList(int size) {
        super(size);
    }

    // Constructor without params, defaultSize = 10
    public SAAList() {
        this(Globals.defaultSize);
    }

    /**
     * Add Element to the correct location
     * Sorted with ascending order
     * 
     * @param element inserted in the the avail(able) index
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        if (MultiCounter.increase(1, avail == Globals.notFound))
            return false;

        int curr = head;
        int prev = Globals.beforeHead;

        // Iterates over the List until it finds an Element with key greater than the
        // one inserted, or until it reaches the end
        while (MultiCounter.increase(1, curr != avail)
                && MultiCounter.increase(1, listArray[curr].getKey() < element.getKey())) {
            prev = curr;
            curr = getNextIndex(curr);
        }

        // If it reaches the end utilize the insert() of the List 2a
        // (No need for specific insertion actions for such cases)
        if (MultiCounter.increase(1, curr == avail))
            return super.insert(element);

        int newNode = getAvailNode();
        listArray[newNode] = element;
        setNextNode(prev, newNode);
        setNextNode(newNode, curr);
        setNextNode(tail, avail);
        return true;
    }

    @Override
    public String toString() {
        return "2b";
    }

}
