package org.tuc.StaticLinkedLists;

import org.tuc.Element;

public class SAAList extends AAList {

    public SAAList(int size) {
        super(size);
    }

    public SAAList() {
        this(defaultSize);
    }

    @Override
    public boolean insert(Element element) {

        return true;
    }

}
