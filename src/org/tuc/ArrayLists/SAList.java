package org.tuc.arraylists;

import org.tuc.Element;
import org.tuc.searchalgorithms.BinarySearch;
import org.tuc.tools.Globals;
import org.tuc.tools.MultiCounter;

public class SAList extends AList {

    /**
     * Initiating List 3b
     * 
     * @constructor
     */
    public SAList(int size) {
        super(size);
    }

    // Constructor without params, defaultSize = 10
    public SAList() {
        super(Globals.defaultSize);
    }

    // Modified version for sorted array
    // (Utilizing Binary Search)
    @Override
    protected int findIndex(int key) {
        return BinarySearch.search(listArray, listSize, key);
    }

    /**
     * Add Element to the correct location
     * Sorted with ascending order
     * 
     * @param element inserted in the new Node
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        // If null or not available space in the list, return
        if (MultiCounter.increase(1, element == null) || MultiCounter.increase(1, listSize >= listArray.length))
            return false;

        // Perform Binary Search, Altered version
        MultiCounter.increase(1);
        int index = BinarySearch.search(listArray, listSize, element.getKey(), false);

        // Case: Element should be places before the current head
        if (MultiCounter.increase(1, index == Globals.beforeHead)) {
            MultiCounter.increase(1);
            index = -1;
        }

        // Move every Element a cell to the right of the array,
        // beggining from the end of the array until the insertion index
        for (int i = listSize - 1; MultiCounter.increase(1, i > index); i--) {
            MultiCounter.increase(1);
            listArray[i + 1] = listArray[i];
        }
        MultiCounter.increase(1);
        listArray[index + 1] = element;
        listSize++;
        return true;
    }

    @Override
    public String toString() {
        return "3b";
    }

}
