package com.jasonwjones.jolo;

public class DefaultTableColumn implements TableColumn {

	private String text;
	private int width;

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

	public TextFormatter getTextFormatter() {
		return null;
	}

}
