package org.tuc.DynamicLists;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List {

    Node head;
    Node tail;

    public DList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean insert(Element element) {
        Node temp = new Node(element);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        return true;
    }

    @Override
    public boolean delete(int key) {
        Node curr = head;
        Node prev = null;

        while (curr.getElement().getKey() != key && curr != null) {
            prev = curr;
            curr = curr.getNext();
        }
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
        Node res = head;
        while (res.getElement().getKey() != key && res != null) {
            res = res.getNext();
        }
        return res.getElement();
    }

}
