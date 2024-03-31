package org.tuc.StaticLists;

import org.tuc.Element;
import org.tuc.List;

public class AAList implements List {

    private static final int defaultSize = 10;
    private int size;
    private int head;
    private int tail;
    private Element[] listArray;
    private int[] listarray_next;

    public AAList(int size) {
        this.size = size;
        tail = 0;
        listArray = new Element[size];
        listarray_next = new int[size];
        for (int i = 0; i < size; i++)
            listarray_next[i] = i + 1;
        listarray_next[size - 1] = -1;
    }

    public AAList() {
        this(defaultSize);
    }

    @Override
    public boolean insert(Element element) {

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
