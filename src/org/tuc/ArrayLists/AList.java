package org.tuc.ArrayLists;

import org.tuc.Element;
import org.tuc.List;

public class AList implements List {

    protected static final int defaultSize = 10;
    protected int head;
    protected int tail;
    protected Element[] listArray;

    public AList(int size) {
        head = tail = 0;
        listArray = new Element[size];
    }

    public AList() {
        this(defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (tail >= listArray.length - 1)
            return false;
        listArray[tail + 1] = element;
        tail++;
        return true;
    }

    @Override
    public boolean delete(int key) {
        int checkidx = -1;
        for (int i = 0; i <= tail; i++)
            if (listArray[i].getKey() == key) {
                checkidx = i;
                break;
            }
        if (checkidx == -1)
            return false;

        return true;
    }

    @Override
    public Element search(int key) {
        return null;

    }

}
