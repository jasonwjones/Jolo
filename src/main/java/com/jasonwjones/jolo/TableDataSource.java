package com.jasonwjones.jolo;

import java.util.List;

import com.jasonwjones.jolo.TableDataSource.TableDataItem;

public interface TableDataSource extends Iterable<TableDataItem> {

	public interface TableColumn {
		public int getWidth();
	}

	public interface TableDataItem {
		public Object getValue(int index);
	}

	public List<String> getHeaders();

}
