package com.yinting.core.datadriver;

public class ExcelDriver extends DataDriver {
	private Integer i = 0;

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object[] next() {

		return new Object[]{i++};
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
