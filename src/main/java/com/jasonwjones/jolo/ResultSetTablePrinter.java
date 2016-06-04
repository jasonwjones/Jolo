package com.jasonwjones.jolo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetTablePrinter extends AbstractTablePrinter {

	public void printResultSet(ResultSet rs) throws SQLException {
		
		TableColumnList columns = createTableColumnList(rs.getMetaData());
		
		String rowSeparator = createRowSeparator(columns.getColumnLengths());
		String rowForHeaders = rowForValues(columns, columns.getHeaders());

		System.out.println(rowSeparator);
		System.out.println(rowForHeaders);
		System.out.println(rowSeparator);

		while (rs.next()) {
			String row = formatRow(columns, rs);
			System.out.println(row);
		}
		System.out.println(rowSeparator);
	}
	
	public String formatRow(TableColumnList tableColumns, ResultSet rs) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("|");

		for (int index = 1; index <= tableColumns.size(); index++) {
			Object value = rs.getString(index);
			int length = tableColumns.get(index - 1).getWidth();
			String padded = StringUtils.fix(value != null ? value.toString() : "", length);
			sb.append(padded);
			sb.append("|");
		}
		return sb.toString();
	}
			
	public TableColumnList createTableColumnList(ResultSetMetaData md) throws SQLException {
		TableColumnList.Builder builder = new TableColumnList.Builder(); 
		for (int column = 1; column <= md.getColumnCount(); column++) {
			String text = md.getColumnLabel(column);
			System.out.println("Label for " + column + " is " + text);
			//int width = md.getColumnDisplaySize(column);
			int width = 20;
			builder.add(text, width);
		}
		return builder.build();
	}
	
}
