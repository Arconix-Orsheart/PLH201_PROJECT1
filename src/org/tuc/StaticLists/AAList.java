package org.tuc.StaticLists;

import org.tuc.Element;
import org.tuc.List;

public class AAList implements List {

    private static final int defaultSize = 10;
    private int msize;
    private int numInList;
    private int curr;
    private int avail;
    private Element[] listArray;
    private int[] listarray_next;

    public AAList(int msize) {
        this.msize = msize;
        numInList = curr = 0;
        listArray = new Element[msize];
        listarray_next = new int[msize];
        avail = 0;
        for (int i = 0; i < msize; i++)
            listarray_next[i] = i + 1;
        listarray_next[msize - 1] = -1;
    }

    public AAList() {
        this(defaultSize);
    }

    private int getNode() {
        if (avail == -1)
            return -1;
        int pos = avail;
        avail = listarray_next[avail];
        return pos;
    }

    @Override
    public boolean insert(Element element) {
        if (curr == -1)
            return false;
        listArray[curr] = element;
        listarray_next[curr] = avail = listarray_next[avail];

        return true;
    }

    @Override
    public boolean delete(int key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Element search(int key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
