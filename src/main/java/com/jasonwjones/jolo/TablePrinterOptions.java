package com.jasonwjones.jolo;

public interface TablePrinterOptions {

	public static enum ColumnWidthStrategy {
		FIXED_WIDTH, CONSTRAIN, NONE
	}

	public static enum ColumnStrategy {
		FIXED, AUTO, FIT_TO_WIDTH
	}

	public ColumnWidthStrategy getColumnWidthStrategy();

	public TextFormatter getHeaderTextFormatter();

	public boolean isPrintRowSeparator();

}
