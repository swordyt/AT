package com.yinting.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.yinting.business.TestEntity;
import com.yinting.core.Http.HttpRequest;
import com.yinting.core.datadriver.DataType;
import com.yinting.core.datadriver.Driver;

public class test1 extends BaseTestCase{
	@Autowired
	private TestEntity en;
	@Test
//	@Driver(type = DataType, parameter = { "x", "y" })
	public void testd() {
		en.setId("5");
		en.setName("李雄");
		System.out.println(en.getName());
//		Request driver = new HttpRequest();
//		driver.GET(
//				"http://api.pinganfang.com/hf/2.0/home/preference/get?time=1496303998&apiKey=797z3it2mdh44weikz4x513irjq22pu9y292k246&apiSequence=ea61a9244c231b7c358c5d05eec08c85&signFuncID=100&signature=4f3886d456220bbd8f60c5b612174fb4&iUserID=0&sToken=&cityID=1")
//				.header("app-deviceID", "868552023341648")
//				.body("_from", "android").invoke();
	}
//
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "x", "y", "z" })
//	public void testc() {
//		Request driver = new HttpRequest();
//		driver.GET(
//				"http://api.pinganfang.com/hf/2.0/home/preference/get?time=1496303998&apiKey=797z3it2mdh44weikz4x513irjq22pu9y292k246&apiSequence=ea61a9244c231b7c358c5d05eec08c85&signFuncID=100&signature=4f3886d456220bbd8f60c5b612174fb4&iUserID=0&sToken=&cityID=1")
//				.header("app-deviceID", "868552023341648")
//				.body("_from", "android").invoke();
//	}
//
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "x", "y", "z", "k" })
//	public void testb() {
//		Request driver = new HttpRequest();
//		driver.GET(
//				"http://api.pinganfang.com/hf/2.0/home/preference/get?time=1496303998&apiKey=797z3it2mdh44weikz4x513irjq22pu9y292k246&apiSequence=ea61a9244c231b7c358c5d05eec08c85&signFuncID=100&signature=4f3886d456220bbd8f60c5b612174fb4&iUserID=0&sToken=&cityID=1")
//				.header("app-deviceID", "868552023341648")
//				.body("_from", "android").invoke();
//	}
//
//	@Test
//	@Driver(type = DataType.EXCEL, parameter = { "x", "y", "z", "k", "q" })
//	public void testa() {
//		Request driver = new HttpRequest();
//		driver.GET(
//				"http://api.pinganfang.com/hf/2.0/home/preference/get?time=1496303998&apiKey=797z3it2mdh44weikz4x513irjq22pu9y292k246&apiSequence=ea61a9244c231b7c358c5d05eec08c85&signFuncID=100&signature=4f3886d456220bbd8f60c5b612174fb4&iUserID=0&sToken=&cityID=1")
//				.header("app-deviceID", "868552023341648")
//				.body("_from", "android").invoke();
//	}

}
