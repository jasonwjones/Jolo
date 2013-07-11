package com.jasonwjones.jolo;

public class DefaultTablePrinterOptions implements TablePrinterOptions {

	public ColumnWidthStrategy getColumnWidthStrategy() {
		return null;
	}

	public TextFormatter getHeaderTextFormatter() {
		return TextFormatters.UPPERCASE;
	}

	public boolean isPrintRowSeparator() {
		return false;
	}

}
