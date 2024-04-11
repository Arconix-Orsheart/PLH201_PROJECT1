package org.tuc.test;

import java.util.ArrayList;

import org.tuc.Globals;
import org.tuc.List;
import org.tuc.counter.MultiCounter;
import org.tuc.elements.MyElement;

public class Tester {

	private ArrayList<List> lists;

	private int[] randomKeys;

	private int currentKey;

	private int numOfElements;

	private int minKeyValue;

	private int maxKeyValue;

	private enum ListMethod {
		INSERT,
		SEARCH,
		DELETE
	}

	public Tester() {
	}

	public void setup(ArrayList<List> lists, int numOfElements, int minKeyValue, int maxKeyValue) {
		this.lists = lists;
		randomKeys = Globals.getRandomKeys(minKeyValue, maxKeyValue, numOfElements);
		currentKey = 0;
		this.minKeyValue = minKeyValue;
		this.maxKeyValue = maxKeyValue;
	}

	public void doTest(String testName) throws Exception {
		long totalTestStartTimeNano, totalTestEndTimeNano;

		long totalStatementCount;
		long totalLevelCount;
		long totalTimeTaken;

		ListMethod[] methods = { ListMethod.INSERT, ListMethod.SEARCH, ListMethod.DELETE };

		System.out.println("Start tests " + testName);
		System.out.println("maxKeyValue: " + maxKeyValue);
		System.out.println("minKeyValue: " + minKeyValue);
		System.out.println(Globals.divider);
		for (List l : lists) {
			long[] testMethodResult;
			for (ListMethod m : methods) {
				testMethodResult = testMethod(l, m);
				for (Long res : testMethodResult)
					System.out.println(res / getK());
			}
		}

	}

	private long[] testMethod(List list, ListMethod method) {
		long totalStatementCount = 0;
		long totalLevelCount = 0;
		long totalTimeTaken = 0;

		int numOfTrials = getK();

		for (int i = 0; i < numOfTrials; i++) {
			MultiCounter.reset(1);
			MultiCounter.reset(2);

			totalTimeTaken += timeMethod(list, method, randomKeys[i]);
			totalStatementCount += MultiCounter.getCount(1);
			totalLevelCount += MultiCounter.getCount(2);
		}
		return new long[] { totalStatementCount, totalLevelCount, totalTimeTaken };
	}

	private long timeMethod(List list, ListMethod method, int key) {
		long startTime = 0;
		long totalTime = 0;

		switch (method) {
			case INSERT:
				startTime = System.nanoTime();
				list.insert(new MyElement(key));
				totalTime = (System.nanoTime() - startTime);
				break;
			case SEARCH:
				startTime = System.nanoTime();
				list.search(key);
				totalTime = (System.nanoTime() - startTime);
				break;
			case DELETE:
				startTime = System.nanoTime();
				list.delete(key);
				totalTime = (System.nanoTime() - startTime);
				break;
		}
		return totalTime;
	}

	private int getK() {
		if (numOfElements < 201)
			return 10;
		if (numOfElements < 1001)
			return 50;
		return 100;
	}
}
