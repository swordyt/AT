package com.yinting.tools;

import java.util.Map;

import com.yinting.core.datadriver.ExcelDriver;

public class ExcelTools {
	/**
	 * 随主数据驱动取值，当无数据驱动支持时，支取第一行数据。
	 * */
	public static Map data(String path,String sheet) {   
		return data(path,sheet,ExcelDriver.publicPosition);
	}
	/**
	 * 取制定行数据
	 * */
	public static Map data(String path, String sheet, int exeNum) {
		ExcelDriver driver=new ExcelDriver(path,sheet);
			return driver.readRow(exeNum);
	}
}
