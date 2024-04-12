package org.tuc.test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestDataCollector {
	/**
	 * Holds the headings of the table
	 */
	private List<String> headings;

	private List<String> listNames;

	/**
	 * Holds the measurements as a list for each row
	 */
	private List<List<Number>> rows;

	/**
	 * Constructor
	 * 
	 * @param headings Headings
	 */
	public TestDataCollector(List<String> listNames) {
		this.headings = new ArrayList<>();
		this.listNames = listNames;
		rows = new ArrayList<>();
	}

	/**
	 * Adds a row with measurements
	 * 
	 * @param row row with measurements
	 */
	public void setRows(List<List<Number>> rows) {
		this.rows = rows;
	}

	public void setHeading(List<String> headings) {
		this.headings = headings;
	}

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
			printstream.print(listNames.get(countRows) + separator);
			for (countCols = 0; countCols < row.size(); countCols++) {
				columnHeadingLength = headings.get(countCols + 1).toString().length();
				// first column is an integer, other columns a float
				printstream.printf("%" + columnHeadingLength + ".2f", (Double) row.get(countCols));
				if (countCols + 1 < headings.size() - 1) {
					printstream.print(separator);
				}
			}
			printstream.println(""); // new line
		}

	}
}
