package com.jasonwjones.jolo;

/**
 * Collection of some primitive utilties ot help process strings.
 * 
 * @author jasonwjones
 *
 */
public class StringUtils {

	/**
	 * Repeats a given character a certain number of times.
	 * 
	 * @param character the character to repeat
	 * @param times the number of times to repeat the character
	 * @return a String with the given character repeated the given number of
	 *         times
	 */
	public static String repeat(char character, int times) {
		return repeat(String.valueOf(character), times);
	}

	public static String repeat(String character, int times) {
		StringBuilder sb = new StringBuilder(times);
		for (int i = 0; i < times; i++) {
			sb.append(character);
		}
		return sb.toString();
	}

	public static String pad(String input, int length) {
		if (input.length() > length)
			throw new IllegalArgumentException("Input string is longer than length.");
		return input + repeat(" ", length - input.length());
	}

	public static String fix(String input, int length) {
		if (input.length() < length) {
			return pad(input, length);
		} else if (input.length() > length) {
			return input.substring(0, length);
		}
		return input;
	}

	public static String padAndAdd(String input, int length, String sides) {
		return sides + pad(input, length) + sides;
	}

	public static String join(String[] strings, String inside, String start, String end) {
		return start + join(strings, inside) + end;
	}

	public static String join(String[] strings, String delimiter) {
		if (strings.length == 1)
			return strings[0];
		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < strings.length - 1; index++) {
			sb.append(strings[index]);
			sb.append(delimiter);
		}
		sb.append(strings[strings.length - 1]);
		return sb.toString();
	}

	/**
	 * Convenience method with a dirty, dirty, dirty implementation. Sorry
	 * programming gods.
	 * 
	 * @param text
	 * @param width
	 * @param connector
	 * @param times
	 * @return
	 */
	public static String repeatAndJoin(String text, int width, String connector, int times) {
		String connectee = repeat(text, width);
		String[] strings = new String[times];
		for (int index = 0; index < times; index++) {
			strings[index] = connectee;
		}
		return join(strings, connector);
	}

}
