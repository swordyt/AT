package com.yinting.core;

import org.testng.annotations.Test;

import com.yinting.core.Http.HttpRequest;

public class test {
	@Test
	public void test() {
		Log.debug("test");
		Request driver=new HttpRequest();
		driver.GET("sdfa").body("","");
	}
}
