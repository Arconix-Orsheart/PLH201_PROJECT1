package org.tuc.arraylists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.List;
import org.tuc.counter.MultiCounter;

public class AList implements List {

    protected int listSize;
    protected Element[] listArray;

    public AList(int size) {
        listSize = 0;
        listArray = new Element[size];
    }

    public AList() {
        this(Globals.defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (element == null || listSize >= listArray.length)
            return false;
        listArray[listSize++] = element;
        return true;
    }

    protected int findIndex(int key) {
        int checkIdx = Globals.notFound;
        for (int i = 0; MultiCounter.increase(1, i < listSize); i++) {
            MultiCounter.increase(2);
            if (MultiCounter.increase(1, listArray[i].getKey() == key)) {
                checkIdx = i;
                break;
            }
        }
        return checkIdx;
    }

    @Override
    public boolean delete(int key) {
        int checkIdx = findIndex(key);
        if (MultiCounter.increase(1, checkIdx == Globals.notFound))
            return false;

        for (int i = checkIdx; MultiCounter.increase(1, i < listSize - 1); i++) {
            MultiCounter.increase(2);
            listArray[i] = listArray[i + 1];
        }
        listArray[listSize - 1] = null;
        listSize--;
        return true;
    }

    @Override
    public Element search(int key) {
        int checkIdx = findIndex(key);
        if (MultiCounter.increase(1, checkIdx == Globals.notFound))
            return null;
        return listArray[checkIdx];

    }

}
