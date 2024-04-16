package org.tuc.dynamiclists;

import org.tuc.Element;
import org.tuc.tools.MultiCounter;

public class Node {

    private Element element;
    private Node next;

    /**
     * Initiating the Node utilised by Lists 1a & 1b
     * 
     * @constructor
     * @param element
     * @param next
     */
    protected Node(Element element, Node next) {
        this.element = element;
        this.next = next;
    }

    protected Node(Element element) {
        this.element = element;
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
        MultiCounter.increase(1);
        this.next = next;
    }

}
