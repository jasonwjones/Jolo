package com.jasonwjones.jolo.util;

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

	/**
	 * Repeats a given string the given number of times.
	 * 
	 * @param character the string to repeat
	 * @param times the number of times to repeat it
	 * @return the resulting string
	 */
	public static String repeat(String character, int times) {
		StringBuilder sb = new StringBuilder(times);
		for (int i = 0; i < times; i++) {
			sb.append(character);
		}
		return sb.toString();
	}

	/**
	 * Pads a string up to a certain length. If the string is bigger than the
	 * length, an exception is thrown (this is purposely conservative in nature
	 * to avoid losing data).
	 * 
	 * @param input the source string to pad up
	 * @param length the size the resulting string hsould be
	 * @return the padded string
	 */
	public static String pad(String input, int length) {
		if (input.length() > length)
			throw new IllegalArgumentException("Input string is longer than length.");
		return input + repeat(" ", length - input.length());
	}

	/**
	 * More flexible variant of the pad function that either trims a string down
	 * to length or pads it up to the necessary length
	 * 
	 * @param input the input string
	 * @param length the target length of the result
	 * @return the resulting string
	 */
	public static String fix(String input, int length) {
		if (input.length() < length) {
			return pad(input, length);
		} else if (input.length() > length) {
			return input.substring(0, length);
		}
		return input;
	}

	/**
	 * Pads a string as with the pad function and also puts the given sides on
	 * 
	 * @param input the source string
	 * @param length the target length (not counting sides)
	 * @param sides the prefix/suffix for the resulting string
	 * @return the resulting string
	 */
	public static String padAndAdd(String input, int length, String sides) {
		return sides + pad(input, length) + sides;
	}

	/**
	 * Joins a string array together using the given strings for prefix and
	 * join.
	 * 
	 * @param strings the string array
	 * @param inside the inside delimiter
	 * @param start the prefix
	 * @param end the suffix
	 * @return the resulting string
	 */
	public static String join(String[] strings, String inside, String start, String end) {
		return start + join(strings, inside) + end;
	}

	/**
	 * Join string array using given delimiter
	 * 
	 * @param strings the strings to join
	 * @param delimiter the delimiter
	 * @return the resulting string
	 */
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
	 * @param text the text
	 * @param width the target width
	 * @param connector the delimiter
	 * @param times the number of times
	 * @return the resulting string
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
