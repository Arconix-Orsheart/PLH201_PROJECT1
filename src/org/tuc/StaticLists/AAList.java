package org.tuc.StaticLists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.List;

public class AAList implements List {

    protected static final int defaultSize = 10;
    protected int head;
    protected int avail;
    protected int tail;
    protected Element[] listArray;
    protected int[] listArray_next;

    public AAList(int size) {
        head = avail = tail = 0;
        listArray = new Element[size];
        listArray_next = new int[size];
        for (int i = 0; i < size; i++)
            listArray_next[i] = i + 1;
        listArray_next[size - 1] = Globals.notFound;
    }

    public AAList() {
        this(defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (avail == Globals.notFound)
            return false;
        int newNode = getAvailNode();
        listArray[newNode] = element;
        tail = newNode;

        return true;
    }

    private int getPreviousNode(int key) {
        int curr = head;
        int prev = Globals.beforeHead;
        while (curr != avail && listArray[curr].getKey() != key) {
            prev = curr;
            curr = getNextIndex(curr);
        }
        return prev;
    }

    protected int getAvailNode() {
        int res = avail;
        avail = getNextIndex(avail);
        return res;
    }

    protected void freeNode(int index) {
        listArray[index] = null;
        setNextNode(index, avail);
        setNextNode(tail, index);
        avail = index;
    }

    protected int getNextIndex(int index) {
        if (index == Globals.notFound)
            return Globals.notFound;
        if (index == Globals.beforeHead)
            return head;
        return listArray_next[index];
    }

    protected void setNextNode(int index, int node) {
        if (index == Globals.beforeHead)
            head = node;
        else
            listArray_next[index] = node;
    }

    @Override
    public boolean delete(int key) {
        int prev = getPreviousNode(key);
        int curr = getNextIndex(prev);
        int next = getNextIndex(curr);

        if (curr == Globals.notFound)
            return false;

        setNextNode(prev, next);
        freeNode(curr);

        return true;
    }

    @Override
    public Element search(int key) {
        int curr = getNextIndex(getPreviousNode(key));

        if (curr == Globals.notFound)
            return null;

        return listArray[curr];
    }

}
