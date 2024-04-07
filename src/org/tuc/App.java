package org.tuc;

import org.tuc.Elements.IntElement;
import org.tuc.StaticLinkedLists.SAAList;

public class App {
    public static void main(String[] args) {
        SAAList list = new SAAList(5);

        // for (int key = 0; list.insert(new IntElement(key, 0)); key++)
        // ;

        list.insert(new IntElement(0, 0));
        list.insert(new IntElement(2, 0));
        list.insert(new IntElement(3, 0));
        list.insert(new IntElement(1, 0));
        list.insert(new IntElement(-1, 0));

        list.delete(1);
        list.insert(new IntElement(5, 0));
        System.out.println(list.search(1));
        System.out.println(list.search(5));

        System.out.println("YO");
    }
}
