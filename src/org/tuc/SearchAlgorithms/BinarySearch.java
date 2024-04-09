package org.tuc.searchalgorithms;

import org.tuc.Element;
import org.tuc.Globals;

public class BinarySearch {

    public static int search(Element[] data, int dataSize, int key) {
        return search(data, dataSize, key, true);
    }

    public static int search(Element[] data, int dataSize, int key, boolean exact) {
        int a = 0, b = dataSize;
        int m = 0;

        while (a < b) {
            m = a + (b - a) / 2;
            if (data[m].getKey() == key)
                return m;
            if (data[m].getKey() < key)
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
