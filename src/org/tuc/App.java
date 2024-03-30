package org.tuc;

import org.tuc.DynamicLists.DList;
import org.tuc.DynamicLists.SDList;
import org.tuc.Elements.IntElement;

public class App {
    public static void main(String[] args) {
        DList list = new SDList();
        list.insert(new IntElement(5, 0));
        list.insert(new IntElement(2, 0));
        list.insert(new IntElement(1, 0));
        list.insert(new IntElement(3, 0));
        list.insert(new IntElement(3, 0));

        System.out.println(list.search(2));
        System.out.println(list.search(4));
        System.out.println(list.delete(0));
        System.out.println(list.delete(4));

    }
}
