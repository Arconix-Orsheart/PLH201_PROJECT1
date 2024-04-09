package org.tuc.test;

import org.tuc.Globals;
import org.tuc.List;
import org.tuc.counter.MultiCounter;
import org.tuc.elements.MyElement;

public class Tester {
	/**
	 * array of number of input elements for each test
	 */
	private List[] lists;

	private int[] allElements;

	private int numOfElements;

	private int numOfLists;

	/**
	 * the lower bound of the generated keys to use
	 */
	private int minIntNumber;

	/**
	 * the upper bound of the generated keys to use
	 */
	private int maxIntNumber;

	public Tester(int listsSize, int numOfElements, int minIntNumber, int maxIntNumber) {
		lists = Globals.generateLists(numOfElements);
		allElements = Globals.getRandomUniqueKeys(minIntNumber, maxIntNumber, numOfElements);
		this.numOfElements = numOfElements;
		this.minIntNumber = minIntNumber;
		this.maxIntNumber = maxIntNumber;
		this.numOfLists = 0;
	}

	public void doTest(String testName) throws Exception {
		long totalTestStartTimeNano, totalTestEndTimeNano;

		long totalStatementCount;
		long totalLevelCount;

		System.out.println("Start tests " + testName);
		System.out.println("maxIntNumber: " + maxIntNumber);
		System.out.println("minIntNumber: " + minIntNumber);
		System.out.println("**************************************");
		System.out.println(
				"Beware!: The total test time includes also the time needed to find existing and non existing keys to search,");
		System.out.println("which skews the time data. The only meaningful time data is the failure time data");
		System.out.println("**************************************");

	}

	private long[] testInsert(List list) {
		long totalStatementCountInsert = 0;
		long totalLevelCountInsert = 0;
		long totalTimeTakenInsert = 0;

		long startTime = 0;

		for (int i = 0; i < numOfElements; i++) {
			MultiCounter.resetCounter(1);
			MultiCounter.resetCounter(2);

			startTime = System.nanoTime();
			list.insert(new MyElement(allElements[i]));
			totalTimeTakenInsert += (System.nanoTime() - startTime);
			totalStatementCountInsert += MultiCounter.getCount(1);
			totalLevelCountInsert += MultiCounter.getCount(2);
		}
		return new long[] { totalStatementCountInsert, totalLevelCountInsert, totalTimeTakenInsert };
	}

	private long[] testDelete(List list) {
		long totalStatementCountDelete = 0;
		long totalLevelCountDelete = 0;
		long totalTimeTakenDelete = 0;

		long startTime = 0;

		for (int i = 0; i < numOfElements; i++) {
			MultiCounter.resetCounter(1);
			MultiCounter.resetCounter(2);

			startTime = System.nanoTime();
			list.delete(10);
			totalTimeTakenDelete += (System.nanoTime() - startTime);
			totalStatementCountDelete += MultiCounter.getCount(1);
			totalLevelCountDelete += MultiCounter.getCount(2);
		}
		return new long[] { totalStatementCountDelete, totalLevelCountDelete, totalTimeTakenDelete };
	}

	private long[] testSearch(List list) {
		long totalStatementCountSearch = 0;
		long totalLevelCountSearch = 0;
		long totalTimeTakenSearch = 0;

		long startTime = 0;

		for (int i = 0; i < numOfElements; i++) {
			MultiCounter.resetCounter(1);
			MultiCounter.resetCounter(2);

			startTime = System.nanoTime();
			list.search(10);
			totalTimeTakenSearch += (System.nanoTime() - startTime);
			totalStatementCountSearch += MultiCounter.getCount(1);
			totalLevelCountSearch += MultiCounter.getCount(2);
		}
		return new long[] { totalStatementCountSearch, totalLevelCountSearch, totalTimeTakenSearch };
	}
}
