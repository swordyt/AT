package com.yinting.core;

import org.testng.annotations.Test;

import com.yinting.core.Http.HttpRequest;

public class test {
	@Test
	public void test() {
		Request driver=new HttpRequest();
		driver.GET("https://www.baidu.com").invoke();
	}
}
