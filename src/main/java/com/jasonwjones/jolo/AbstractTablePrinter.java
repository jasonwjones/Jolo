package com.jasonwjones.jolo;

import java.util.List;

import com.jasonwjones.jolo.util.StringUtils;

/**
 * Base class for table printer implementations. Provides some
 * common/convenience functions.
 * 
 * @author jasonwjones
 *
 */
public abstract class AbstractTablePrinter {

	/**
	 * Creates a "row separator" given columns with the given maximum lengths.
	 * 
	 * <p>
	 * For example, if the column lengths were 1, 2, and 3, the following
	 * separator would be returned:
	 * 
	 * <pre>
	 * +-+--+---+
	 * </pre>
	 * 
	 * @param lengths an array of column lengths representing the columsn in the
	 *            table
	 * @return a string that can be used to separate rows.
	 */
	protected String createRowSeparator(int[] lengths, CharacterMap charMap) {
		String[] segments = new String[lengths.length];
		for (int index = 0; index < lengths.length; index++) {
			segments[index] = StringUtils.repeat("-", lengths[index]);
		}
		return StringUtils.join(segments, "+", "+", "+");
	}

	/**
	 * Creates the text for a row that surrounds given values.
	 * 
	 * @param tableColumns the table column definition (contains lengths, etc.)
	 * @param values the values
	 * @return a text string representing the row output
	 */
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

	/**
	 * Creates a row separator using a column definition (as opposed to the
	 * other method that takes integers)
	 * 
	 * @param columns the column definition
	 * @return a text string to separate the rows
	 */
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
