package com.jasonwjones.jolo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TablePrinter {

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

	private String rowForValues(TableColumnList tableColumns, List<? extends Object> values) {
		StringBuilder sb = new StringBuilder();
		sb.append("|");

		for (int index = 0; index < tableColumns.size(); index++) {
			Object value = values.get(index);
			int length = tableColumns.get(index).getWidth();
			String padded = StringUtils.fix(value.toString(), length);
			sb.append(padded);
			sb.append("|");
		}
		return sb.toString();
	}

	private String createRowSeparator(int[] lengths) {
		String[] segments = new String[lengths.length];
		for (int index = 0; index < lengths.length; index++) {
			segments[index] = StringUtils.repeat("-", lengths[index]);
		}
		return StringUtils.join(segments, "+", "+", "+");
	}

	private String rowSeparator(TableColumnList columns) {
		StringBuilder sb = new StringBuilder("+");
		for (int index = 0; index < columns.size(); index++) {
			TableColumn column = columns.get(index);
			sb.append(StringUtils.repeat("-", column.getWidth()));
			if (index < columns.size() - 1) {
				sb.append("+");
			}
		}
		sb.append("+");
		return sb.toString();
	}

}