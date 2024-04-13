package org.tuc.elements;

import org.tuc.Element;

public class MyElement implements Element {

    private int key;

    /**
     * Initiating the implimentation of the Element Interface
     * 
     * @constructor
     * @param key
     */
    public MyElement(int key) {
        this.key = key;
    }

    @Override
    public int getKey() {
        return key;
    }

}
