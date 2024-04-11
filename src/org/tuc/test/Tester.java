package org.tuc.test;

import java.util.ArrayList;

import org.tuc.Globals;
import org.tuc.Globals.ListMethod;
import org.tuc.List;
import org.tuc.counter.MultiCounter;
import org.tuc.elements.MyElement;

public class Tester {

	private ArrayList<List> lists;

	private int[] N;

	private int[] randomKeys;

	public Tester(int[] N) {
		this.N = N;
	}

	private void setup(int n) {
		this.lists = Globals.generateLists(n + 2 * Globals.getK(n));
		int[] keyValues = Globals.getKeyValues(n);
		this.randomKeys = Globals.getRandomKeys(keyValues[0], keyValues[1], n);
		for (List l : lists)
			for (int k : keyValues)
				l.insert(new MyElement(k));

	}

	public void doTest(ListMethod method) throws Exception {
		long totalTestStartTimeNano, totalTestEndTimeNano;

		long totalActionsCount;
		long totalTimeTaken;

		System.out.println("Start test: " + method);
		System.out.println(Globals.divider);

		java.util.List<String> resultHeadings = new ArrayList<>();
		resultHeadings.add("Lists");

		TestDataCollector timeDataCollector = new TestDataCollector(Globals.generateListNames());
		TestDataCollector actionDataCollector = new TestDataCollector(Globals.generateListNames());

		for (int n : N) {
			java.util.List<Number> timeDataRow = new ArrayList<>();
			java.util.List<Number> actionsDataRow = new ArrayList<>();
			resultHeadings.add("N = " + n);
			setup(n);
			for (List l : lists) {
				long[] testMethodResults = testMethod(l, method, n);
				timeDataRow.add((float) testMethodResults[0] / Globals.getK(n));
				actionsDataRow.add((float) testMethodResults[1] / Globals.getK(n));
			}
			timeDataCollector.addRow(timeDataRow);
			actionDataCollector.addRow(actionsDataRow);
		}

		timeDataCollector.setHeading(resultHeadings);
		actionDataCollector.setHeading(resultHeadings);

		timeDataCollector.toScreen();
		timeDataCollector.toFile(method + "_TIME.csv");
		actionDataCollector.toScreen();
		actionDataCollector.toFile(method + "_ACTIONS.csv");

	}

	private long[] testMethod(List list, ListMethod method, int n) {
		long totalActionsCount = 0;
		long totalTimeTaken = 0;

		int numOfTrials = Globals.getK(n);

		for (int i = 0; i < numOfTrials; i++) {
			MultiCounter.reset(1);

			totalTimeTaken += timeMethod(list, method, randomKeys[i]);
			totalActionsCount += MultiCounter.getCount(1);
		}
		return new long[] { totalTimeTaken, totalActionsCount };
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
}
