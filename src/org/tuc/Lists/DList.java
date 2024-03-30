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
        Node temp = new Node(element);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
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

        if (curr == head)
            head = head.next;
        else
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
