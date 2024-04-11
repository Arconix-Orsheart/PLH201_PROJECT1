package org.tuc.arraylists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.counter.MultiCounter;
import org.tuc.searchalgorithms.BinarySearch;

public class SAList extends AList {

    public SAList(int size) {
        super(size);
    }

    public SAList() {
        super(Globals.defaultSize);
    }

    @Override
    protected int findIndex(int key) {
        return BinarySearch.search(listArray, listSize, key);
    }

    @Override
    public boolean insert(Element element) {
        if (MultiCounter.increase(1, element == null) || MultiCounter.increase(1, listSize >= listArray.length))
            return false;
        int index = BinarySearch.search(listArray, listSize, element.getKey(), false);
        if (MultiCounter.increase(1, index == Globals.beforeHead))
            index = -1;
        for (int i = listSize - 1; MultiCounter.increase(1, i > index); i--)
            listArray[i + 1] = listArray[i];
        listArray[index + 1] = element;
        listSize++;
        return true;
    }

}
