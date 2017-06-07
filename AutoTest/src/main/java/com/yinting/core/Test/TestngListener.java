package com.yinting.core.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

import org.testng.IAnnotationTransformer3;
import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.yinting.core.DataExchangeArea;
import com.yinting.core.TestCase;
import com.yinting.core.datadriver.DataDriver;
import com.yinting.core.datadriver.DataProviderClass;
import com.yinting.core.datadriver.Driver;

public class TestngListener implements ISuiteListener, ITestListener,
		IClassListener, IAnnotationTransformer3 {
	public static final String DATAPROVIDER_DB = "DATAPROVIDER_DB";
	public static final String DATAPROVIDER_EXCEL = "DATAPROVIDER_EXCEL";
	public static final String DATAPROVIDER_XML = "DATAPROVIDER_XML";
	public static String[] parameter;

	public void onStart(ISuite suite) {
		TestFactory.getSuite().setStartTime(new Date().getTime());
	}

	public void onFinish(ISuite suite) {
		TestFactory.getSuite().setEndTime(new Date().getTime());
		TestFactory.endSuite();

	}

	public void onTestStart(ITestResult result) {
		TestFactory.getCas().setStartTime(new Date().getTime());

	}

	public void onTestSuccess(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.SUCCESS);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();

	}

	public void onTestFailure(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.FAILURE);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();

	}

	public void onTestSkipped(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.SKIPPED);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.FBWSP);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	}

	public void onBeforeClass(ITestClass testClass) {
		TestFactory.getCls().setStartTime(new Date().getTime());

	}

	public void onAfterClass(ITestClass testClass) {
		TestFactory.getCls().setEndTime(new Date().getTime());
		TestFactory.endClass();
	}

	public void transform(IConfigurationAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub

	}

	public void transform(IDataProviderAnnotation annotation, Method method) {

	}

	public void transform(IFactoryAnnotation annotation, Method method) {

	}

	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		Annotation ann = testMethod.getAnnotation(Driver.class);
		if (ann != null) {
			dataDriver(annotation, (Driver) ann);
		}
	}

	public void transform(IListenersAnnotation annotation, Class testClass) {
		// TODO Auto-generated method stub

	}

	private void dataDriver(ITestAnnotation annotation, Driver driver) {
		annotation.setDataProviderClass(DataProviderClass.class);
		DataDriver.parameter=driver.parameter();
		switch (driver.type().getType()) {
		case 0: // excel
			annotation.setDataProvider(DATAPROVIDER_EXCEL);
			break;
		case 1: // xml
			annotation.setDataProvider(DATAPROVIDER_XML);
			break;
		case 2:// db
			annotation.setDataProvider(DATAPROVIDER_DB);
			break;
		default:
			annotation.setDataProvider(DATAPROVIDER_EXCEL);
		}
	}
}
