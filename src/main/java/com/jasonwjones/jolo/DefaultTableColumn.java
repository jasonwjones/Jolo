package com.jasonwjones.jolo;

/**
 * Represents a column in a table in terms of its header text and the maximum
 * length of items in the table
 * 
 * @author jasonwjones
 *
 */
public class DefaultTableColumn implements TableColumn {

	private String text;
	private int width;

	/**
	 * Creats a new table column with the given header text and max width
	 * 
	 * @param text the text for the header
	 * @param width the width, in characters, for items in the column
	 */
	public DefaultTableColumn(String text, int width) {
		this.text = text;
		this.width = width;
	}
	
	public String getText() {
		return text;
	}

	public int getWidth() {
		return width;
	}

}
