package com.jasonwjones.jolo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Main class for printing tables.
 * 
 * @author jasonwjones
 *
 */
public class TablePrinter extends AbstractTablePrinter {

	private TablePrinterOptions printOptions = new DefaultTablePrinterOptions();

	private final static CharacterMap DEFAULT_CHAR_MAP = new DefaultCharacterMap();

	/**
	 * Convenience method that calls the other output method but supplies
	 * <code>System.out</code> as the output target.
	 * 
	 * @param columns the column definition
	 * @param data the input data to print out
	 */
	public void outputTable(TableColumnList columns, Iterable<List<? extends Object>> data) {
		outputTable(columns, data, System.out);
	}

	/**
	 * Creates a text table and returns the whole thing as a string.
	 * 
	 * @param columns column definition for the table
	 * @param data Iterable with all data for the table
	 * @return a String with the generated table
	 */
	public String createTable(TableColumnList columns, Iterable<List<? extends Object>> data) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		outputTable(columns, data, ps);
		return baos.toString();
	}

	/**
	 * Print a table.
	 * 
	 * @param columns the column definition
	 * @param data the rows of data
	 * @param printStream the print stream
	 */
	public void outputTable(TableColumnList columns, Iterable<List<? extends Object>> data, PrintStream printStream) {
		outputTable(columns, data, printStream, DEFAULT_CHAR_MAP);
	}

	/**
	 * Prints a table. This is the full invocation if needed to provide maximum
	 * flexibility.
	 * 
	 * @param columns the column definition
	 * @param data the rows of data
	 * @param printStream the print stream
	 * @param charMap the character map
	 */
	public void outputTable(TableColumnList columns, Iterable<List<? extends Object>> data, PrintStream printStream,
			CharacterMap charMap) {
		String rowSeparator = createRowSeparator(columns.getColumnLengths(), charMap);
		String rowForHeaders = rowForValues(columns, columns.getHeaders());

		printStream.println(rowSeparator);
		printStream.println(rowForHeaders);
		printStream.println(rowSeparator);

		for (List<? extends Object> row : data) {
			String rowText = rowForValues(columns, row);
			printStream.println(rowText);
			if (printOptions.isPrintRowSeparator()) {
				printStream.println(rowSeparator);
			}
		}

		if (!printOptions.isPrintRowSeparator()) {
			printStream.println(rowSeparator);
		}
	}

}