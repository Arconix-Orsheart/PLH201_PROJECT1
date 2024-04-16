package org.tuc.staticlists;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.tools.Globals;
import org.tuc.tools.MultiCounter;

public class AAList implements List {

    protected int head;
    protected int avail;
    protected int tail;
    protected Element[] listArray;
    protected int[] listArray_next;

    /**
     * Initiating List 2a
     * 
     * @constructor
     */
    public AAList(int size) {
        head = avail = tail = 0;
        listArray = new Element[size];
        listArray_next = new int[size];
        for (int i = 0; i < size; i++)
            listArray_next[i] = i + 1;
        listArray_next[size - 1] = Globals.notFound;
    }

    // Constructor without params, defaultSize = 10
    public AAList() {
        this(Globals.defaultSize);
    }

    /**
     * Adds the Element at the end of the list
     * 
     * @param element inserted in the avail(able) index
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        // If null or not available space in the list, return
        if (MultiCounter.increase(1, element == null) || MultiCounter.increase(1, avail == Globals.notFound))
            return false;

        MultiCounter.increase(1, 3);
        int newNode = getAvailNode();
        listArray[newNode] = element;
        tail = newNode;

        return true;
    }

    /**
     * Finds the first node with the specified key and returns the previous one
     * node = (Element, next) pair
     * 
     * @param key of the element to find
     * @return previous index of node
     */
    private int getPreviousNode(int key) {
        MultiCounter.increase(1, 2);
        int curr = head;
        int prev = Globals.beforeHead;

        // Iterates over the List until it finds the Element or it reaches the end
        while (MultiCounter.increase(1, curr != avail)
                && MultiCounter.increase(1, listArray[curr].getKey() != key)) {
            MultiCounter.increase(1, 2);
            prev = curr;
            curr = getNextIndex(curr);
        }
        return prev;
    }

    /**
     * Give index of available node & recalculate the available node
     * 
     * @return available index of the node
     */
    protected int getAvailNode() {
        MultiCounter.increase(1, 2);
        int res = avail;
        avail = getNextIndex(avail);
        return res;
    }

    /**
     * Remove node from the current utilized list & make it the available node
     * 
     * @param index of node to be removed
     */
    protected void freeNode(int index) {
        setNextNode(index, avail);
        setNextNode(tail, index);

        MultiCounter.increase(1);
        avail = index;
    }

    protected int getNextIndex(int index) {
        // Case: Reached max capacity
        if (MultiCounter.increase(1, index == Globals.notFound))
            return Globals.notFound;
        // Case: Need the head of the list
        if (MultiCounter.increase(1, index == Globals.beforeHead))
            return head;
        return listArray_next[index];
    }

    protected void setNextNode(int index, int node) {
        // Cases: Delete last available Element or Insert first Element
        if (MultiCounter.increase(1, index == node) || MultiCounter.increase(1, index == Globals.beforeHead)) {
            MultiCounter.increase(1);
            head = node;
        }
        // For inbetween cases
        else {
            MultiCounter.increase(1);
            listArray_next[index] = node;
        }
    }

    /**
     * Deletes the first Element with the specified key
     * 
     * @param key
     * @return true if it succesfully deletes the element
     *         false if it doesn't
     */
    @Override
    public boolean delete(int key) {
        MultiCounter.increase(1, 3);
        int prev = getPreviousNode(key);
        int curr = getNextIndex(prev);
        int next = getNextIndex(curr);

        if (MultiCounter.increase(1, curr == Globals.notFound))
            return false;

        setNextNode(prev, next);
        freeNode(curr);

        return true;
    }

    /**
     * Finds the first Element with the specified key
     * 
     * @param key
     * @return Element if found,
     *         null if not
     */
    @Override
    public Element search(int key) {
        MultiCounter.increase(1);
        int curr = getNextIndex(getPreviousNode(key));

        if (MultiCounter.increase(1, curr == Globals.notFound))
            return null;

        return listArray[curr];
    }

    @Override
    public String toString() {
        return "2a";
    }

}
