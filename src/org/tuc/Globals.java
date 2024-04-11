package org.tuc;

import java.util.ArrayList;
import java.util.Random;

import org.tuc.arraylists.AList;
import org.tuc.arraylists.SAList;
import org.tuc.dynamiclists.DList;
import org.tuc.dynamiclists.SDList;
import org.tuc.staticlists.AAList;
import org.tuc.staticlists.SAAList;

public class Globals {
    public static final int allLists = 6;
    public static final int notFound = -1;
    public static final int beforeHead = -2;
    public static final int defaultSize = 10;

    public static final int minKeyValue = 1;

    public static final String divider = "**************************************";

    public static enum ListMethod {
        INSERT,
        SEARCH,
        DELETE
    }

    public static int[] getKeyValues(int n) {
        return new int[] { Globals.minKeyValue, 2 * n };
    }

    public static int[] getRandomUniqueKeys(int minIntNumber, int maxIntNumber, int numberOfNumbers) {
        Random randomGenerator = new Random();
        int[] randomInts = randomGenerator.ints(minIntNumber, maxIntNumber + 1).distinct().limit(numberOfNumbers)
                .toArray();
        return randomInts;
    }

    public static int[] getRandomKeys(int minIntNumber, int maxIntNumber, int numberOfNumbers) {
        Random randomGenerator = new Random();
        int[] randomInts = randomGenerator.ints(minIntNumber, maxIntNumber + 1).limit(numberOfNumbers).toArray();
        return randomInts;
    }

    public static int getK(int n) {
        if (n < 201)
            return 10;
        if (n < 1001)
            return 50;
        return 100;
    }

    public static ArrayList<List> generateLists(int numOfElements) {
        ArrayList<List> lists = new ArrayList<List>();
        lists.add(new DList());
        lists.add(new SDList());
        lists.add(new AAList(numOfElements));
        lists.add(new SAAList(numOfElements));
        lists.add(new AList(numOfElements));
        lists.add(new SAList(numOfElements));
        return lists;
    }

    public static ArrayList<String> generateListNames() {
        ArrayList<String> listNames = new ArrayList<String>();
        listNames.add("1a");
        listNames.add("1b");
        listNames.add("2a");
        listNames.add("2b");
        listNames.add("3a");
        listNames.add("3b");
        return listNames;
    }

}
