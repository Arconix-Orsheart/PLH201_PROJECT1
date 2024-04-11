package org.tuc;

import org.tuc.Globals.ListMethod;
import org.tuc.test.Tester;

public class App {
    public static void main(String[] args) {
        int[] N = { 30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000 };
        Tester tester = new Tester(N);
        ListMethod[] methods = { ListMethod.INSERT, ListMethod.SEARCH, ListMethod.DELETE };
        for (ListMethod m : methods)
            try {
                tester.doTest(m);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }
}
