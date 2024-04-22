package org.tuc.test;

import org.tuc.arraylists.SAList;
import org.tuc.elements.MyElement;

public class tests {
    public static void main(String[] args) {
        SAList list = new SAList(10);

        list.insert(new MyElement(0));
        list.insert(new MyElement(5));
        list.insert(new MyElement(10));
        list.insert(new MyElement(7));
    }
}
