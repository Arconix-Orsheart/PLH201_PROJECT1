package org.tuc.Lists;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List {

    static class Node {
        Element data;
        Node next;

        Node(Element elem) {
            data = elem;
        }
    }

    @Override
    public boolean insert(Element element) {
        return true;
    }

    @Override
    public boolean delete(int key) {
        return true;
    }

    @Override
    public Element search(int key) {
        return null;
    }

}
