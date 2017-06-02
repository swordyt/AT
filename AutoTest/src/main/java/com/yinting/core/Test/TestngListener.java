package com.yinting.core.Test;

import java.util.Date;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ISuiteListener, ITestListener,
		IClassListener {
	public void onStart(ISuite suite) {
		TestFactory.getSuite().setStartTime(new Date().getTime());
		System.out.println("套件onStart：" + new Date().getTime());
	}

	public void onFinish(ISuite suite) {
		TestFactory.getSuite().setEndTime(new Date().getTime());
		TestFactory.endSuite();
		System.out.println("套件onFinish:" + new Date().getTime());

	}

	public void onTestStart(ITestResult result) {
		TestFactory.getCas().setStartTime(new Date().getTime());
		System.out.println("onTestStart");

	}

	public void onTestSuccess(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.SUCCESS);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();
		System.out.println("onTestSuccess");

	}

	public void onTestFailure(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.FAILURE);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();
		System.out.println("onTestFailure");

	}

	public void onTestSkipped(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.SKIPPED);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();
		System.out.println("onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		TestFactory.getCas().setResult(CaseResultType.FBWSP);
		TestFactory.getCas().setEndTime(new Date().getTime());
		TestFactory.endCase();
		System.out.println("onTestFailedButWithinSuccessPercentage");

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	}

	public void onBeforeClass(ITestClass testClass) {
		TestFactory.getCls().setStartTime(new Date().getTime());
		System.out.println("onBeforeClass");

	}

	public void onAfterClass(ITestClass testClass) {
		TestFactory.getCls().setEndTime(new Date().getTime());
		TestFactory.endClass();
		System.out.println("onAfterClass");
	}

}