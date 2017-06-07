package com.yinting.core.datadriver;

import org.testng.annotations.DataProvider;

import com.yinting.core.Test.TestngListener;

public class DataProviderClass {
	@DataProvider(name = TestngListener.DATAPROVIDER_DB)
	public DataDriver db() {
		return new DbDriver();
	}

	@DataProvider(name = TestngListener.DATAPROVIDER_EXCEL)
	public DataDriver excel() {
		return new ExcelDriver();
	}

	@DataProvider(name = TestngListener.DATAPROVIDER_XML)
	public DataDriver xml() {
		return new XmlDriver();
	}
}
