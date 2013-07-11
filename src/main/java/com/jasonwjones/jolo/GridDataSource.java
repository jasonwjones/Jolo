package com.jasonwjones.jolo;

public interface GridDataSource {

	public int getRows();

	public int getColumns();

	public String getText(int row, int column);

}
