package org.tuc.DynamicLists;

import org.tuc.Element;

public class Node {

    private Element element;
    private Node next;

    protected Node(Element element, Node next) {
        this.element = element;
        this.next = next;
    }

    protected Node(org.tuc.Element element2) {
        this.element = element2;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
