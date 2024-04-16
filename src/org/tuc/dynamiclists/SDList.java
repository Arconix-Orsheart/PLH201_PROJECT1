package org.tuc.dynamiclists;

import org.tuc.Element;
import org.tuc.tools.MultiCounter;

public class SDList extends DList {

    /**
     * Initiating List 1b
     * 
     * @constructor
     */
    public SDList() {
        super();
    }

    /**
     * Creates Node & adds it to the correct location
     * Sorted with ascending order
     * 
     * @param element inserted in the new Node
     * @return true if it succesfully inserts the element
     *         false if it doesn't
     */
    @Override
    public boolean insert(Element element) {
        if (MultiCounter.increase(1, element == null))
            return false;

        MultiCounter.increase(1, 2);
        Node curr = head;
        Node prev = new Node(null, head);

        // Iterates over the List until it finds an Element with key greater than the
        // one inserted, or until it reaches the end
        while (MultiCounter.increase(1, curr != null)
                && MultiCounter.increase(1, curr.getElement().getKey() < element.getKey())) {
            MultiCounter.increase(1, 2);
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(new Node(element, curr));

        // Set's the tail/head depending on the point of insert
        if (MultiCounter.increase(1, prev == tail) || MultiCounter.increase(1, head == null)) {
            MultiCounter.increase(1);
            tail = prev.getNext();
        }
        if (MultiCounter.increase(1, curr == head)) {
            MultiCounter.increase(1);
            head = prev.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        return "1b";
    }

}
