package org.tuc.staticlists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.List;
import org.tuc.counter.MultiCounter;

public class AAList implements List {

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
        this(Globals.defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (element == null || avail == Globals.notFound)
            return false;
        int newNode = getAvailNode();
        listArray[newNode] = element;
        tail = newNode;

        return true;
    }

    private int getPreviousNode(int key) {
        int curr = head;
        int prev = Globals.beforeHead;
        while (MultiCounter.increase(1, curr != avail) && MultiCounter.increase(1, listArray[curr].getKey() != key)) {
            MultiCounter.increase(2);
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
        if (MultiCounter.increase(1, index == Globals.notFound))
            return Globals.notFound;
        if (MultiCounter.increase(1, index == Globals.beforeHead))
            return head;
        return listArray_next[index];
    }

    protected void setNextNode(int index, int node) {
        if (MultiCounter.increase(1, index == Globals.beforeHead))
            head = node;
        else
            listArray_next[index] = node;
    }

    @Override
    public boolean delete(int key) {
        int prev = getPreviousNode(key);
        int curr = getNextIndex(prev);
        int next = getNextIndex(curr);

        if (MultiCounter.increase(1, curr == Globals.notFound))
            return false;

        setNextNode(prev, next);
        freeNode(curr);

        return true;
    }

    @Override
    public Element search(int key) {
        int curr = getNextIndex(getPreviousNode(key));

        if (MultiCounter.increase(1, curr == Globals.notFound))
            return null;

        return listArray[curr];
    }

}
