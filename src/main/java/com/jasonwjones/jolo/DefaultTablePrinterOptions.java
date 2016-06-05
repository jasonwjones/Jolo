package com.jasonwjones.jolo;

/**
 * Various options for printing a table.
 * 
 * @author jasonwjones
 *
 */
public class DefaultTablePrinterOptions implements TablePrinterOptions {

	/**
	 * Whether to print separators between rows or not.
	 */
	public boolean isPrintRowSeparator() {
		return false;
	}

}
