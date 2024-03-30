package org.tuc;

import org.tuc.DynamicLists.DList;
import org.tuc.Elements.IntElement;

public class App {
    public static void main(String[] args) {
        DList list = new DList();
        list.insert(new IntElement(0, 0));
        list.insert(new IntElement(1, 0));
        list.insert(new IntElement(2, 0));
        list.insert(new IntElement(3, 0));
    }
}
