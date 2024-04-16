package org.tuc.dynamiclists;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.tools.MultiCounter;

public class DList implements List {

    protected Node head;
    protected Node tail;

    /**
     * Initiating List 1a
     * 
     * @constructor
     */
    public DList() {
        head = null;
        tail = null;
    }

    /**
     * Creates Node & adds it to the end of the List
     * 
     * @param element inserted in the new Node
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        if (MultiCounter.increase(1, element == null))
            return false;
        MultiCounter.increase(1);
        Node prev = tail;
        if (MultiCounter.increase(1, head == null)) {
            MultiCounter.increase(1, 2);
            tail = head = new Node(element);
        } else {
            MultiCounter.increase(1);
            prev.setNext(tail = new Node(element));
        }
        return true;
    }

    /**
     * Finds the first Node with the specified key and returns the previous one
     * 
     * @param key of the element to find
     * @return previous Node
     */
    private Node getPreviousNode(int key) {
        MultiCounter.increase(1, 2);
        Node curr = head;
        Node prev = new Node(null, head);

        // Iterates over the List until it finds the Element or it reaches the end
        while (MultiCounter.increase(1, curr != null) && MultiCounter.increase(1, curr.getElement().getKey() != key)) {
            MultiCounter.increase(1, 2);
            prev = curr;
            curr = curr.getNext();
        }
        return prev;
    }

    private Node getNode(int key) {
        return getPreviousNode(key).getNext();
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
        MultiCounter.increase(1, 2);
        Node prev = getPreviousNode(key);
        Node curr = prev.getNext();

        if (MultiCounter.increase(1, curr == null))
            return false;
        if (MultiCounter.increase(1, curr == head)) {
            MultiCounter.increase(1);
            head = head.getNext();
        } else
            prev.setNext(curr.getNext());

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
        Node res = getNode(key);
        if (MultiCounter.increase(1, res == null))
            return null;
        return res.getElement();
    }

    @Override
    public String toString() {
        return "1a";
    }

}
