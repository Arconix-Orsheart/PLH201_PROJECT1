package org.tuc.searchalgorithms;

import org.tuc.Element;
import org.tuc.counter.MultiCounter;
import org.tuc.tools.Globals;

public class BinarySearch {

    public static int search(Element[] data, int dataSize, int key) {
        return search(data, dataSize, key, true);
    }

    public static int search(Element[] data, int dataSize, int key, boolean exact) {
        int a = 0, b = dataSize;
        int m = 0;

        while (MultiCounter.increase(1, a < b)) {
            MultiCounter.increase(2);

            MultiCounter.increase(1);
            m = a + (b - a) / 2;

            if (MultiCounter.increase(1, data[m].getKey() == key))
                return m;
            if (MultiCounter.increase(1, data[m].getKey() < key))
                a = m + 1;
            else
                b = m;
        }

        if (exact)
            return Globals.notFound;
        if (dataSize == 0 || data[0].getKey() > key)
            return Globals.beforeHead;
        return m;
    }

}
