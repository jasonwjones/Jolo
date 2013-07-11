package com.jasonwjones.jolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TablePrinterTest {

	private TablePrinter tp;

	private static String randomData = "a,.mzx;lk;:KLFlkjhFDSmn;klq[poiasd;lkmnz.,xmn;lkwFGS";
	private static List<String> test30;

	private static Random random = new Random();

	public TablePrinterTest() {
		tp = new TablePrinter();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test30 = new ArrayList<String>(30);
		for (int i = 0; i < 30; i++) {
			test30.add("Element " + i);
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrintTableWithColumns() {
		TableColumnList tcl = new TableColumnList.Builder().add("Name", 40).add("City", 15).add("State", 2).build();
		Iterable<List<? extends Object>> data = createRandomRows(10, 3);
		tp.outputTable(tcl, data);
	}

	private static Iterable<List<? extends Object>> createRandomRows(int rows, int elementsPerRow) {
		List<List<? extends Object>> rowData = new ArrayList<List<? extends Object>>();
		for (int index = 0; index < rows; index++) {
			rowData.add(createRandomRow(elementsPerRow));
		}
		return rowData;
	}

	private static List<String> createRandomRow(int size) {
		List<String> columnData = new ArrayList<String>();
		for (int index = 0; index < size; index++) {
			columnData.add(randomString());
		}
		return columnData;
	}

	private static String randomString() {
		return randomString(randomData.length());
	}

	private static String randomString(int maxLength) {
		int length = random.nextInt(maxLength);
		int start = random.nextInt(randomData.length() - length);
		return randomData.substring(start, start + length);
	}

}
