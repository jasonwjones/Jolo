package com.jasonwjones.jolo;

/**
 * Very simple model of a data source based on a grid. There are a defined
 * number of rows, columns, and a String value for each intersection.
 * 
 * @author jasonwjones
 *
 */
public interface GridDataSource {

	public int getRows();

	public int getColumns();

	public String getText(int row, int column);

}
