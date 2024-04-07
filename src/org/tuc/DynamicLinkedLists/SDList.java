package org.tuc.DynamicLinkedLists;

import org.tuc.Element;

public class SDList extends DList {

    public SDList() {
        super();
    }

    @Override
    public boolean insert(Element element) {
        if (element == null)
            return false;

        Node curr = head;
        Node prev = new Node(null, head);

        while (curr != null && curr.getElement().getKey() < element.getKey()) {
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(new Node(element, curr));

        if (curr == head)
            head = prev.getNext();

        return true;
    }

}
