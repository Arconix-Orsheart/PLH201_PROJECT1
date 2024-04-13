package org.tuc.searchalgorithms;

import org.tuc.Element;
import org.tuc.tools.Globals;
import org.tuc.tools.MultiCounter;

public class BinarySearch {

    /**
     * Binary Search Algorithm with additional parameters
     * 
     * @param data     array of sorted Elements
     * @param dataSize how many Elements there are in the array
     * @param key      key of Element to find
     * @param exact    True, return notFound = -1 if the Element is not found
     *                 False, return the index of the Element before the location
     *                 the Element should be
     * @return
     */
    public static int search(Element[] data, int dataSize, int key, boolean exact) {
        // Indexes of Upper & Lower boundaries of the array
        int a = 0, b = dataSize;

        // Index of Middle Element between the boundaries
        int m = 0;

        // Iterate over the array until the upper & lower boundaries have the same value
        while (MultiCounter.increase(1, a < b)) {

            // Recalculate the middle Element
            MultiCounter.increase(1);
            m = a + (b - a) / 2;

            // If m, is the Element to find return it
            if (MultiCounter.increase(1, data[m].getKey() == key))
                return m;
            // Search upwards
            if (MultiCounter.increase(1, data[m].getKey() < key))
                a = m + 1;
            // Search downwards
            else
                b = m;
        }

        // For original algorithm
        if (MultiCounter.increase(1, exact))
            return Globals.notFound;
        // For the altered version, If the Element should be before the First Element of
        // the data array
        if (MultiCounter.increase(1, dataSize == 0) || MultiCounter.increase(1, data[0].getKey() > key))
            return Globals.beforeHead;
        // For the altered version, other cases
        return m;
    }

    // Binary Search Algorithm, original version
    public static int search(Element[] data, int dataSize, int key) {
        return search(data, dataSize, key, true);
    }

}
