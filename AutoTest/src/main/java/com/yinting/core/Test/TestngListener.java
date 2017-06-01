package com.yinting.core.Test;

import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ISuiteListener, ITestListener {
	private long suiteStartTime=0;
	private long suiteFinishTime=0;
	public void onStart(ISuite suite) {
		System.out.println("套件onStart:"+suite.getName());
		System.out.println("套件开始时间："+new Date().getTime());
	}

	public void onFinish(ISuite suite) {
		System.out.println("套件onFinish:" + suite.getName());

	}

	public void onTestStart(ITestResult result) {
		System.out.println("测试onTestStart");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("测试onTestSuccess");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("测试onTestFailure");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("测试onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("测试onTestFailedButWithinSuccessPercentage");

	}

	public void onStart(ITestContext context) {
		System.out.println("onStart:" + context.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish:" + context.getOutputDirectory());
		System.out.println("套件结束时间："+new Date().getTime());
	}

}
