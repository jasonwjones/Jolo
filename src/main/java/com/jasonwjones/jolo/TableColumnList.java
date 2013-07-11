package com.jasonwjones.jolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableColumnList {

	private static final int DEFAULT_WIDTH = 30;

	private List<TableColumn> columns;

	public static class Builder {

		private List<TableColumn> columns = new ArrayList<TableColumn>();

		public Builder add(String text, int width) {
			TableColumn column = new DefaultTableColumn(text, width);
			columns.add(column);
			return this;
		}

		public TableColumnList build() {
			return new TableColumnList(columns);
		}
	}

	public TableColumnList(String... columnHeaders) {
		this(DEFAULT_WIDTH, columnHeaders);
	}

	public TableColumnList(int width, String... columnHeaders) {
		columns = new ArrayList<TableColumn>();
		for (String header : columnHeaders) {
			columns.add(new DefaultTableColumn(header, width));
		}
	}

	/**
	 * Creates a TableColumnList based on a List of columns. Note that an
	 * immutable copy of the given list will be made
	 * 
	 * @param columns list of columns to use in this column list
	 */
	public TableColumnList(List<TableColumn> columns) {
		this.columns = Collections.unmodifiableList(columns);
	}

	public List<String> getHeaders() {
		List<String> headers = new ArrayList<String>();
		for (TableColumn column : columns) {
			headers.add(column.getText());
		}
		return headers;
	}

	public int[] getColumnLengths() {
		int[] lengths = new int[columns.size()];
		for (int index = 0; index < columns.size(); index++) {
			lengths[index] = columns.get(index).getWidth();
		}
		return lengths;
	}

	public TableColumn get(int index) {
		return columns.get(index);
	}

	public int size() {
		return columns.size();
	}

}
