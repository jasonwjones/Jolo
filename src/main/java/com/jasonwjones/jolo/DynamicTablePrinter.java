package com.jasonwjones.jolo;

import java.util.ArrayList;
import java.util.List;

import com.jasonwjones.jolo.util.StringUtils;

public class DynamicTablePrinter {

	protected List<String> getAllTableValues(GridDataSource dataSource) {
		int rows = dataSource.getRows();
		int columns = dataSource.getColumns();
		List<String> allValues = new ArrayList<String>(rows * columns);

		for (int row = 0; row < dataSource.getRows(); row++) {
			for (int column = 0; column < dataSource.getColumns(); column++) {
				String value = dataSource.getText(row, column);
				if (value != null) allValues.add(value);
			}
		}
		return allValues;
	}

	protected String rowSeparator(int numElements, int elementWidth) {
		String middle = StringUtils.repeatAndJoin("-", elementWidth, "+", numElements);
		return "|" + middle + "|";
	}

}
