package com.jasonwjones.jolo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jasonwjones.jolo.util.StringUtils;

public class StringUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPad() {
		String month = "Jan";
		String month10 = "Jan       ";
		assertEquals(month10, StringUtils.pad(month, 10));
	}

}
