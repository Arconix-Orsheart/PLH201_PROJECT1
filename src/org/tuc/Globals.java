package org.tuc;

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

    public static List[] generateLists(int numOfElements) {
        List[] lists = new List[allLists];
        int index = 0;
        lists[index++] = new DList();
        lists[index++] = new SDList();
        lists[index++] = new AAList(numOfElements);
        lists[index++] = new SAAList(numOfElements);
        lists[index++] = new AList(numOfElements);
        lists[index++] = new SAList(numOfElements);
        return lists;
    }

}
