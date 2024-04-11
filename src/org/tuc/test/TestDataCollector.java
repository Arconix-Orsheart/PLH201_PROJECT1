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

	/**
	 * Holds the measurements as a list for each row
	 */
	private List<List<String>> rows;

	/**
	 * Constructor
	 * 
	 * @param headings Headings
	 */
	public TestDataCollector(List<String> headings) {
		this.headings = headings;
		rows = new ArrayList<>();
	}

	/**
	 * Adds a row with measurements
	 * 
	 * @param row row with measurements
	 */
	public void addRow(List<String> row) {
		rows.add(row);
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
			List<String> row = rows.get(countRows);
			for (countCols = 0; countCols < row.size(); countCols++) {
				columnHeadingLength = headings.get(countCols).toString().length();
				// first column is an integer, other columns a float
				if (countCols == 0) {
					printstream.printf("%" + columnHeadingLength + "d", row.get(countCols));
				} else {
					printstream.printf("%" + columnHeadingLength + ".3f", row.get(countCols));
				}
				if (countCols < headings.size() - 1) {
					printstream.print(separator);
				}
			}
			printstream.println(""); // new line
		}

	}
}
