package org.tuc.test;

import java.util.ArrayList;

import org.tuc.List;
import org.tuc.elements.MyElement;
import org.tuc.tools.Globals;
import org.tuc.tools.Globals.ListMethod;
import org.tuc.tools.ListsInitiator;
import org.tuc.tools.MultiCounter;

public class Tester {

	private List[] lists;

	private int[] N;

	private int[] keyValues;

	private ListsInitiator initiator;

	private java.util.List<java.util.List<Number>> timeDataRows;

	private java.util.List<java.util.List<Number>> operationsDataRows;

	public Tester(int[] N, ListsInitiator initiator) {
		this.N = N;
		this.initiator = initiator;
	}

	private void setup(int n) {
		this.lists = initiator.generateLists(n + 2 * Globals.getK(n));
		this.keyValues = Globals.getKeyValues(n);
		int[] randomKeys = Globals.getRandomKeys(keyValues[0], keyValues[1], n);
		for (List l : lists)
			for (int k : randomKeys)
				l.insert(new MyElement(k));
	}

	private void initDataRows() {
		timeDataRows = new ArrayList<>();
		operationsDataRows = new ArrayList<>();

		for (int i = 0; i < initiator.getNumOfLists(); i++) {
			timeDataRows.add(new ArrayList<Number>());
			operationsDataRows.add(new ArrayList<Number>());
		}
	}

	public void doTest(ListMethod method) throws Exception {
		long totalTestStartTimeNano, totalTestEndTimeNano;
		String totalTestTime;

		System.out.println(Globals.divider);
		System.out.println("Start test: " + method);

		java.util.List<String> resultHeadings = new ArrayList<>();
		resultHeadings.add("L ");

		TestDataCollector timeDataCollector = new TestDataCollector(Globals.generateListNames());
		TestDataCollector operationsDataCollector = new TestDataCollector(Globals.generateListNames());

		initDataRows();

		totalTestStartTimeNano = System.nanoTime();
		for (int n : N) {
			resultHeadings.add("  N = " + n);
			setup(n);
			for (int i = 0; i < initiator.getNumOfLists(); i++) {
				long[] testMethodResults = testMethod(lists[i], method, n);
				timeDataRows.get(i).add((double) testMethodResults[0] / Globals.getK(n));
				operationsDataRows.get(i).add((double) testMethodResults[1] / Globals.getK(n));
			}
		}
		totalTestEndTimeNano = System.nanoTime();

		timeDataCollector.setHeading(resultHeadings);
		timeDataCollector.setRows(timeDataRows);

		operationsDataCollector.setHeading(resultHeadings);
		operationsDataCollector.setRows(operationsDataRows);

		totalTestTime = String.format("%.02f",
				(double) (totalTestEndTimeNano - totalTestStartTimeNano) / 1000000000);
		System.out.println("Total Test Time(sec): " + totalTestTime);
		System.out.println(Globals.divider);
		System.out.println("Mean Time Per List(ns)");
		timeDataCollector.toScreen();
		timeDataCollector.toFile(method + "_TIME.csv");
		System.out.println(Globals.divider);
		System.out.println("Mean Operations Per List");
		operationsDataCollector.toScreen();
		operationsDataCollector.toFile(method + "_OPERATIONS.csv");

	}

	private long[] testMethod(List list, ListMethod method, int n) {
		long totalActionsCount = 0;
		long totalTimeTaken = 0;

		int numOfTrials = Globals.getK(n);

		for (int i = 0; i < numOfTrials; i++) {
			MultiCounter.reset(1);

			totalTimeTaken += timeMethod(list, method, Globals.getRandomKey(keyValues[0], keyValues[1]));
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
