package org.tuc;

import org.tuc.test.Tester;

public class App {
    public static void main(String[] args) {
        int[] N = { 30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000 };
        Tester tester = new Tester();

        for (int n : N) {
            tester.setup(Globals.generateLists(n), n, 1, 2 * n);

            try {
                tester.doTest("For N = " + n);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
