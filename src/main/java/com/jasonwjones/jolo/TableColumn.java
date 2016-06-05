package com.jasonwjones.jolo;

/**
 * Model for a column header in a table.
 * 
 * @author jasonwjones
 *
 */
public interface TableColumn {

	/**
	 * The text for the column label.
	 * 
	 * @return the text for the column label
	 */
	public String getText();

	/**
	 * The width, in characters, that the column should print
	 * 
	 * @return the width of the column
	 */
	public int getWidth();

}
