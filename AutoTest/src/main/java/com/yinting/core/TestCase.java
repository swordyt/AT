package com.yinting.core;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yinting.core.Test.TestngListener;
import com.yinting.core.datadriver.DataType;
import com.yinting.core.datadriver.Driver;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年6月2日 下午9:10:33 类说明
 */
@Listeners({ TestngListener.class })
public class TestCase {
	@Test
	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
	public void test6(String i) {
		System.out.println(Thread.currentThread().getName() + ":" + i);
	}
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
//	public void test5(String i) {
//		System.out.println(Thread.currentThread().getName() + ":" + i);
//	}
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
//	public void test4(String i) {
//		System.out.println(Thread.currentThread().getName() + ":" + i);
//	}
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
//	public void test3(String i) {
//		System.out.println(Thread.currentThread().getName() + ":" + i);
//	}
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
//	public void test2(String i) {
//		System.out.println(Thread.currentThread().getName() + ":" + i);
//	}
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "1", "2", "3", "4", "5" })
//	public void test1(String i) {
//		System.out.println(Thread.currentThread().getName() + ":" + i);
//	}

}
