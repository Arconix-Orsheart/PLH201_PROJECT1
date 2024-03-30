package org.tuc.Lists;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List {

    Node head;
    Node tail;

    static class Node {
        Element data;
        Node next;

        private Node(Element data, Node next) {
            this.data = data;
            this.next = next;
        }

        private Node(Element data) {
            this(data, null);
        }

    }

    public DList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean insert(Element element) {
        tail = new Node(element, tail);
        if (tail == null)
            return false;
        if (head == null)
            head = tail;
        return true;
    }

    @Override
    public boolean delete(int key) {
        Node curr = head;
        Node prev = null;

        while (curr.data.getKey() != key && curr != null) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        return true;
    }

    @Override
    public Element search(int key) {
        Node res = head;
        while (res.data.getKey() != key && res != null) {
            res = res.next;
        }
        return res.data;
    }

}
