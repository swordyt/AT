package com.yinting.core.datadriver;

import java.lang.reflect.Method;

public class ExcelDriver extends DataDriver {
	private Integer i = 0;
	private int position = 0;
	private int total = 0;
	private String[] parameter;
	public ExcelDriver(Method method) {
//		String key=md5(method);
//		System.out.println("========="+key+"====");
//		parameter=DataDriver.parameteres.get(key);
//		total = parameter.length;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
//		return position < total;
		return true;
	}

	public Object[] next() {
//		return new Object[] {parameter[position++]};
		return new Object[] {""+i++};
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
