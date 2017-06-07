package com.yinting.core.datadriver;

public class ExcelDriver extends DataDriver {
	private Integer i = 0;
	private int position = 0;
	private int total = 0;

	public ExcelDriver() {
		total = parameter.length;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position < total;
	}

	public Object[] next() {
		return new Object[] { parameter[position++] };
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
