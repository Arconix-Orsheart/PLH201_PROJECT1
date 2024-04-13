package org.tuc.test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestDataCollector {

	// Holds the headings of the table
	private List<String> headings;

	// Holds the names of each List
	private List<String> listNames;

	// Holds the Heading for the Lists names
	private String listsHeading;

	// Holds the measurements as a list for each row
	private List<List<Number>> rows;

	/**
	 * @constructor
	 * 
	 * @param listNames
	 */
	public TestDataCollector(List<String> listNames, String listsHeading) {
		this.headings = new ArrayList<>();
		this.rows = new ArrayList<>();
		this.listNames = listNames;
		this.listsHeading = listsHeading;
	}

	/**
	 * Set rows with measurements
	 * 
	 * @param rows rows with measurements
	 */
	public void setRows(List<List<Number>> rows) {
		this.rows = rows;
	}

	/**
	 * Set headings of the table
	 * 
	 * @param heading headings of the table
	 */
	public void setHeading(List<String> headings) {
		this.headings = headings;
	}

	// Print the table to console
	public void toScreen() {
		// print headings
		this.print(System.out, " | ");
		System.out.println("Data collected printed to screen");
	}

	/**
	 * Writes the table to a file
	 * 
	 * @param fileName
	 */
	public void toFile(String fileName) {
		try {
			PrintStream printStream = new PrintStream(fileName);
			this.print(printStream, ",");
			printStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Data collected saved to " + fileName);
	}

	private void print(PrintStream printstream, String separator) {
		int countCols;
		int countRows;
		printstream.print(listsHeading + separator);
		for (countCols = 0; countCols < headings.size(); countCols++) {
			printstream.print(headings.get(countCols));
			if (countCols < headings.size() - 1) {
				printstream.print(separator);
			}
		}
		printstream.println(""); // new line

		int columnHeadingLength;
		for (countRows = 0; countRows < rows.size(); countRows++) {
			List<Number> row = rows.get(countRows);
			// Before each row of measurements, add the name of the list tested
			printstream.printf("%" + listsHeading.toString().length() + "s", listNames.get(countRows));
			printstream.print(separator);
			for (countCols = 0; countCols < row.size(); countCols++) {
				// Add enough space to align it with the spacing of the heading
				columnHeadingLength = headings.get(countCols).toString().length();
				printstream.printf("%" + columnHeadingLength + ".2f", (Double) row.get(countCols));
				if (countCols < headings.size() - 1) {
					printstream.print(separator);
				}
			}
			printstream.println(""); // new line
		}

	}
}
