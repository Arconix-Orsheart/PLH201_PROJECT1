package org.tuc.tools;

import java.util.ArrayList;
import java.util.Random;

import org.tuc.List;
import org.tuc.arraylists.AList;
import org.tuc.arraylists.SAList;
import org.tuc.dynamiclists.DList;
import org.tuc.dynamiclists.SDList;
import org.tuc.staticlists.AAList;
import org.tuc.staticlists.SAAList;

/**
 * static class with Global variables & methods,
 * utilized by most classes
 */
public class Globals {
    public static final int allLists = 6;
    public static final int notFound = -1;
    public static final int beforeHead = -2;
    public static final int defaultSize = 10;

    public static final int minKeyValue = 1;

    public static final String divider = "*****************************************************************************************************************************";
    public static final String listsHeading = "Lists";

    public static enum ListMethod {
        INSERT,
        SEARCH,
        DELETE
    }

    /**
     * @param n The size of the list the key is going to inserted in
     * @return the range of values a key can take
     */
    public static int[] getKeyValues(int n) {
        return new int[] { Globals.minKeyValue, 2 * n };
    }

    // Returns an array of unique random integers between the minIntNumber &
    // maxIntNumber
    public static int[] getRandomUniqueKeys(int minIntNumber, int maxIntNumber, int numberOfNumbers) {
        Random randomGenerator = new Random();
        int[] randomInts = randomGenerator.ints(minIntNumber, maxIntNumber + 1).distinct().limit(numberOfNumbers)
                .toArray();
        return randomInts;
    }

    // Returns an array of (non-unique) random integers between the minIntNumber &
    // maxIntNumber
    public static int[] getRandomKeys(int minIntNumber, int maxIntNumber, int numberOfNumbers) {
        Random randomGenerator = new Random();
        int[] randomInts = randomGenerator.ints(minIntNumber, maxIntNumber + 1).limit(numberOfNumbers).toArray();
        return randomInts;
    }

    // Returns only one random integer
    public static int getRandomKey(int minIntNumber, int maxIntNumber) {
        return getRandomKeys(minIntNumber, maxIntNumber, 1)[0];
    }

    // Get the K based on the inserted n
    public static int getK(int n) {
        if (n < 201)
            return 10;
        if (n < 1001)
            return 50;
        return 100;
    }

    // Returns an array of all implimented lists
    public static List[] generateLists(int numOfElements) {
        return new List[] { new DList(), new SDList(), new AAList(numOfElements), new SAAList(numOfElements),
                new AList(numOfElements), new SAList(numOfElements) };
    }

    // Returns a List of names of each implimented List
    public static java.util.List<String> generateListNames() {
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
