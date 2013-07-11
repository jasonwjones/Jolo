
package com.jasonwjones.jolo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StringListUtilsTest {

	private List<String> testData = Arrays.asList("Foo", "Bar", "Bazzle", "Rabazzle");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLargestString() {
		assertEquals(8, StringListUtils.largestString(testData));
	}

}
