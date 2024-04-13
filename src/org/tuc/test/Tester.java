package org.tuc.test;

import java.util.ArrayList;

import org.tuc.List;
import org.tuc.elements.MyElement;
import org.tuc.tools.Globals;
import org.tuc.tools.Globals.ListMethod;
import org.tuc.tools.ListsInitiator;
import org.tuc.tools.MultiCounter;

public class Tester {

	// All Lists to be tested
	private List[][] lists;

	// Numbers of Elements, that need to be tested
	private int[] N;

	// Initialize Lists, can be moified
	private ListsInitiator initiator;

	// Measurements of mean times, for each list
	private java.util.List<java.util.List<Number>> timeDataRows;

	// Measurements of mean operations, for each list
	private java.util.List<java.util.List<Number>> operationsDataRows;

	/**
	 * Initialize Tester
	 * 
	 * @constructor
	 * @param N
	 * @param initiator
	 */
	public Tester(int[] N, ListsInitiator initiator) {
		this.N = N;
		this.initiator = initiator;
	}

	// Setup environment for each list
	public void setup() {
		this.lists = new List[N.length][];
		for (int i = 0; i < N.length; i++) {
			this.lists[i] = initiator.generateLists(N[i] + 2 * Globals.getK(N[i]));
			int[] keyValues = Globals.getKeyValues(N[i]);

			// Create array of n random keys
			int[] randomKeys = Globals.getRandomKeys(keyValues[0], keyValues[1], N[i]);

			System.out.println("For N = " + N[i] + ":");
			System.out.print("Ready Lists: ");

			// Insert them in each list
			for (List l : lists[i]) {
				for (int k : randomKeys)
					l.insert(new MyElement(k));
				System.out.print(l.toString() + ", ");
			}
			System.out.print("\b\b \n");
		}
	}

	// Initialize Measurements lists
	private void initDataRows() {
		timeDataRows = new ArrayList<>();
		operationsDataRows = new ArrayList<>();

		for (int i = 0; i < initiator.getNumOfLists(); i++) {
			timeDataRows.add(new ArrayList<Number>());
			operationsDataRows.add(new ArrayList<Number>());
		}
	}

	/**
	 * Begin the testing process
	 * 
	 * @param method for method to be tested
	 * @throws Exception
	 */
	public void doTest(ListMethod method) throws Exception {
		long totalTestStartTimeNano, totalTestEndTimeNano;
		String totalTestTime;

		System.out.println(Globals.divider);
		System.out.println("Start test: " + method);

		// For Collecting & printing the measurements
		TestDataCollector timeDataCollector = new TestDataCollector(Globals.generateListNames(), Globals.listsHeading);
		TestDataCollector operationsDataCollector = new TestDataCollector(Globals.generateListNames(),
				Globals.listsHeading);

		// List of Headings for measurements
		java.util.List<String> resultHeadings = new ArrayList<>();

		// Initialize the lists tha hold the measurements
		initDataRows();

		// Begin Testing
		totalTestStartTimeNano = System.nanoTime();
		for (int i = 0; i < N.length; i++) {
			resultHeadings.add("   N = " + N[i]);

			// Test the current method for the current n
			for (int j = 0; j < initiator.getNumOfLists(); j++) {
				long[] testMethodResults = testMethod(lists[i][j], method, N[i]);
				timeDataRows.get(j).add((double) testMethodResults[0] / Globals.getK(N[i]));
				operationsDataRows.get(j).add((double) testMethodResults[1] / Globals.getK(N[i]));
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

	/**
	 * Testing for speicified list
	 * 
	 * @param list
	 * @param method
	 * @param n
	 * @return measurements
	 */
	private long[] testMethod(List list, ListMethod method, int n) {
		long totalActionsCount = 0;
		long totalTimeTaken = 0;

		// K iterations of testing current method
		int numOfTrials = Globals.getK(n);

		for (int i = 0; i < numOfTrials; i++) {
			MultiCounter.reset(1);
			int[] keyValues = Globals.getKeyValues(n);

			totalTimeTaken += timeMethod(list, method, Globals.getRandomKey(keyValues[0], keyValues[1]));
			totalActionsCount += MultiCounter.getCount(1);
		}
		return new long[] { totalTimeTaken, totalActionsCount };
	}

	/**
	 * 
	 * @param list
	 * @param method
	 * @param key
	 * @return
	 */
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
