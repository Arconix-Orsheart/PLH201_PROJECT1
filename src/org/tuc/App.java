package org.tuc;

import org.tuc.test.Tester;
import org.tuc.tools.Globals;
import org.tuc.tools.Globals.ListMethod;
import org.tuc.tools.ListsInitiator;

public class App {
    public static void main(String[] args) {
        int[] N = { 30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000 };
        ListsInitiator initiator = new ListsInitiator() {

            @Override
            public int getNumOfLists() {
                return Globals.allLists;
            }

            @Override
            public List[] generateLists(int n) {
                return Globals.generateLists(n);
            }

        };
        Tester tester = new Tester(N, initiator);
        ListMethod[] methods = { ListMethod.INSERT, ListMethod.SEARCH,
                ListMethod.DELETE };
        for (ListMethod m : methods)
            try {
                tester.doTest(m);
            } catch (Exception e) {
                e.printStackTrace();
            }

        // int listSize = 5;
        // SAAList l = new SAAList(listSize);
        // int[] keys = Globals.getRandomKeys(1, 50, listSize);
        // for (int i = 0; i < listSize; i++)
        // l.insert(new MyElement(keys[i]));
        // for (int i = 0; i < listSize; i++)
        // l.delete(keys[i]);
        // System.out.println("lol");
    }
}
