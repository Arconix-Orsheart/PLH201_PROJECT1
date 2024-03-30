package org.tuc.Elements;

import org.tuc.Element;

public class IntElement implements Element {

    private int key;
    private int data;

    public IntElement(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int getKey() {
        return key;
    }

}
