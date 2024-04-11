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

    public static final String divider = "**************************************";

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

}
