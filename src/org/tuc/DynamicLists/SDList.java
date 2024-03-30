package org.tuc.DynamicLists;

import org.tuc.Element;

public class SDList extends DList {

    @Override
    public boolean insert(Element element) {
        Node curr = head;
        Node prev = new Node(null, head);

        while (curr != null && curr.getElement().getKey() <= element.getKey()) {
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(new Node(element, curr));

        if (curr == head)
            head = prev.getNext();

        return true;
    }

}
