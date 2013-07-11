package com.jasonwjones.jolo;

public class TextFormatters {

	public static final TextFormatter UPPERCASE = createUpperCaseTextFormatter();

	private static TextFormatter createUpperCaseTextFormatter() {
		return new TextFormatter() {
			public String format(String input) {
				return input.toUpperCase();
			}
		};
	}
}
