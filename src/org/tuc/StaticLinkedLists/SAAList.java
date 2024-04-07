package org.tuc.StaticLinkedLists;

import org.tuc.Element;
import org.tuc.Globals;

public class SAAList extends AAList {

    public SAAList(int size) {
        super(size);
    }

    public SAAList() {
        this(Globals.defaultSize);
    }

    @Override
    public boolean insert(Element element) {

        return true;
    }

}
