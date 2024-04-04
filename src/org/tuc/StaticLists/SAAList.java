package org.tuc.StaticLists;

import org.tuc.Element;
import org.tuc.Globals;

public class SAAList extends AAList {

    public SAAList(int size) {
        super(size);
    }

    public SAAList() {
        this(defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (avail == Globals.notFound)
            return false;

        int curr = head;
        int prev = Globals.beforeHead;

        while (curr != avail && listArray[curr].getKey() < element.getKey()) {
            prev = curr;
            curr = getNextIndex(curr);
        }

        if (curr == avail)
            return super.insert(element);

        int newNode = getAvailNode();
        listArray[newNode] = element;
        setNextNode(prev, newNode);
        setNextNode(newNode, curr);
        setNextNode(tail, avail);

        return true;
    }

}
