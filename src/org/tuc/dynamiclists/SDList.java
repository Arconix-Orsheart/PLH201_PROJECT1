package org.tuc.dynamiclists;

import org.tuc.Element;
import org.tuc.tools.MultiCounter;

public class SDList extends DList {

    public SDList() {
        super();
    }

    @Override
    public boolean insert(Element element) {
        if (MultiCounter.increase(1, element == null))
            return false;

        Node curr = head;
        Node prev = new Node(null, head);

        while (MultiCounter.increase(1, curr != null)
                && MultiCounter.increase(1, curr.getElement().getKey() < element.getKey())) {
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(new Node(element, curr));

        if (MultiCounter.increase(1, prev == tail) || MultiCounter.increase(1, head == null))
            tail = prev.getNext();
        if (MultiCounter.increase(1, curr == head))
            head = prev.getNext();
        return true;
    }

}
