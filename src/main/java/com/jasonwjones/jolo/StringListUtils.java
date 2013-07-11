
package com.jasonwjones.jolo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringListUtils {

	public static int largestString(List<String> strings) {
		Comparator<String> length = new Comparator<String>() {
			public int compare(String left, String right) {
				return left.length() - right.length();
			}
		};
		return Collections.max(strings, length).length();
	}

}
