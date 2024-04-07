package org.tuc.ArrayLists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.List;

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
        for (int i = 0; i < listSize; i++)
            if (listArray[i].getKey() == key) {
                checkIdx = i;
                break;
            }
        return checkIdx;
    }

    @Override
    public boolean delete(int key) {
        int checkIdx = findIndex(key);
        if (checkIdx == Globals.notFound)
            return false;

        for (int i = checkIdx; i < listSize - 1; i++)
            listArray[i] = listArray[i + 1];
        listArray[listSize - 1] = null;
        listSize--;
        return true;
    }

    @Override
    public Element search(int key) {
        int checkIdx = findIndex(key);
        if (checkIdx == Globals.notFound)
            return null;
        return listArray[checkIdx];

    }

}
