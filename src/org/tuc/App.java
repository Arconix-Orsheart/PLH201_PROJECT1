package org.tuc;

import org.tuc.test.Tester;

public class App {
    public static void main(String[] args) {
        int[] N = { 30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000 };
        Tester tester = new Tester(Globals.allLists, N[0], 1, 2 * N[0]);
    }
}
