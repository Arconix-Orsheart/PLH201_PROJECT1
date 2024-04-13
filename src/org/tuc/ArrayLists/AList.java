package org.tuc.arraylists;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.tools.Globals;
import org.tuc.tools.MultiCounter;

public class AList implements List {

    protected int listSize;
    protected Element[] listArray;

    /**
     * Initiating List 3a
     * 
     * @constructor
     */
    public AList(int size) {
        listSize = 0;
        listArray = new Element[size];
    }

    // Constructor without params, defaultSize = 10
    public AList() {
        this(Globals.defaultSize);
    }

    /**
     * Adds the Element at the end of the list
     * 
     * @param element inserted in the first available cell
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        // If null or not available space in the list, return
        if (MultiCounter.increase(1, element == null) || MultiCounter.increase(1, listSize >= listArray.length))
            return false;
        listArray[listSize++] = element;
        return true;
    }

    /**
     * Find index of Element with specified key
     * 
     * @param key of Element to find
     * @return index of Element, if found
     *         notFound = -1, if not
     */
    protected int findIndex(int key) {
        int checkIdx = Globals.notFound;

        // Iterates over the List until it finds the Element or it reaches the end
        for (int i = 0; MultiCounter.increase(1, i < listSize); i++) {
            // Break from the loop if Element found
            if (MultiCounter.increase(1, listArray[i].getKey() == key)) {
                checkIdx = i;
                break;
            }
        }
        return checkIdx;
    }

    /**
     * Deletes the first Element with the specified key
     * 
     * @param key
     * @return true if it succesfully deletes the element
     *         false if it doesn't
     */
    @Override
    public boolean delete(int key) {
        int checkIdx = findIndex(key);

        // If not found, return
        if (MultiCounter.increase(1, checkIdx == Globals.notFound))
            return false;

        // If found, move every Element a cell to the left of the array,
        // beggining from the index of the found Element
        for (int i = checkIdx; MultiCounter.increase(1, i < listSize - 1); i++)
            listArray[i] = listArray[i + 1];
        listArray[listSize - 1] = null;
        listSize--;
        return true;
    }

    /**
     * Finds the first Element with the specified key
     * 
     * @param key
     * @return Element if found,
     *         null if not
     */
    @Override
    public Element search(int key) {
        int checkIdx = findIndex(key);

        // If not found, return null
        if (MultiCounter.increase(1, checkIdx == Globals.notFound))
            return null;
        return listArray[checkIdx];

    }

    @Override
    public String toString() {
        return "3a";
    }

}
