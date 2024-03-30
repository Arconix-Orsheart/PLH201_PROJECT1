package org.tuc;

public interface List {

    public boolean insert(Element element);

    public boolean delete(int key);

    public Element search(int key);
}
