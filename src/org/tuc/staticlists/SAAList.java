package org.tuc.staticlists;

import org.tuc.Element;
import org.tuc.Globals;
import org.tuc.counter.MultiCounter;

public class SAAList extends AAList {

    public SAAList(int size) {
        super(size);
    }

    public SAAList() {
        this(Globals.defaultSize);
    }

    @Override
    public boolean insert(Element element) {
        if (avail == Globals.notFound)
            return false;

        int curr = head;
        int prev = Globals.beforeHead;

        while (MultiCounter.increase(1, curr != avail)
                && MultiCounter.increase(1, listArray[curr].getKey() < element.getKey())) {
            MultiCounter.increase(2);
            prev = curr;
            curr = getNextIndex(curr);
        }

        if (MultiCounter.increase(1, curr == avail))
            return super.insert(element);

        int newNode = getAvailNode();
        listArray[newNode] = element;
        setNextNode(prev, newNode);
        setNextNode(newNode, curr);
        setNextNode(tail, avail);
        return true;
    }

}
