package com.jasonwjones.jolo;

import java.util.List;

public class AbstractTablePrinter {

	protected String createRowSeparator(int[] lengths) {
		String[] segments = new String[lengths.length];
		for (int index = 0; index < lengths.length; index++) {
			segments[index] = StringUtils.repeat("-", lengths[index]);
		}
		return StringUtils.join(segments, "+", "+", "+");
	}
	
	protected String rowForValues(TableColumnList tableColumns, List<? extends Object> values) {
		StringBuilder sb = new StringBuilder();
		sb.append("|");

		for (int index = 0; index < tableColumns.size(); index++) {
			Object value = values.get(index);
			int length = tableColumns.get(index).getWidth();
			String padded = StringUtils.fix(value != null ? value.toString() : "", length);
			sb.append(padded);
			sb.append("|");
		}
		return sb.toString();
	}
	
	protected String rowSeparator(TableColumnList columns) {
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
