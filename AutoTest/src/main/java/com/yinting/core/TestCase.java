package com.yinting.core;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.yinting.core.Http.HttpRequest;

public class TestCase {
	@Test
	public void test() {
		Request driver = new HttpRequest();
		driver.GET(
				"http://api.pinganfang.com/hf/2.0/home/preference/get?time=1496303998&apiKey=797z3it2mdh44weikz4x513irjq22pu9y292k246&apiSequence=ea61a9244c231b7c358c5d05eec08c85&signFuncID=100&signature=4f3886d456220bbd8f60c5b612174fb4&iUserID=0&sToken=&cityID=1")
				.header("app-deviceID", "868552023341648")
				.body("_from", "android").invoke();
		for (int i = 0; i < 1000; i++) {
			
		}
	}
}