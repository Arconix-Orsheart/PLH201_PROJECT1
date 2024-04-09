package org.tuc.dynamiclists;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List {

    protected Node head;
    protected Node tail;

    public DList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean insert(Element element) {
        if (element == null)
            return false;
        Node prev = tail;
        if (head == null)
            tail = head = new Node(element);
        else
            prev.setNext(tail = new Node(element));
        return true;
    }

    private Node getPreviousNode(int key) {
        Node curr = head;
        Node prev = new Node(null, head);

        while (curr != null && curr.getElement().getKey() != key) {
            prev = curr;
            curr = curr.getNext();
        }
        return prev;
    }

    private Node getNode(int key) {
        return getPreviousNode(key).getNext();
    }

    @Override
    public boolean delete(int key) {
        Node prev = getPreviousNode(key);
        Node curr = prev.getNext();

        if (curr == null)
            return false;
        if (curr == head)
            head = head.getNext();
        else
            prev.setNext(curr.getNext());

        return true;
    }

    @Override
    public Element search(int key) {
        Node res = getNode(key);
        if (res == null)
            return null;
        return res.getElement();
    }

}
