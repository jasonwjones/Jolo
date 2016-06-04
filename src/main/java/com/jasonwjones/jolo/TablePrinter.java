package com.jasonwjones.jolo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TablePrinter extends AbstractTablePrinter {

	private TablePrinterOptions printOptions = new DefaultTablePrinterOptions();

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

	public void outputTable(TableColumnList columns, Iterable<List<? extends Object>> data, PrintStream printStream) {
		String rowSeparator = createRowSeparator(columns.getColumnLengths());
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