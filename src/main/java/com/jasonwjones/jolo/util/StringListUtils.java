
package com.jasonwjones.jolo.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Misc string collection utilities.
 * 
 * @author jasonwjones
 *
 */
public class StringListUtils {

	/**
	 * Returns the length of the largest string from a given list of strings
	 * 
	 * @param strings the list of strings to check
	 * @return the length (from String.length()) of the larget string
	 */
	public static int largestString(List<String> strings) {
		Comparator<String> length = new Comparator<String>() {
			public int compare(String left, String right) {
				return left.length() - right.length();
			}
		};
		return Collections.max(strings, length).length();
	}

}
