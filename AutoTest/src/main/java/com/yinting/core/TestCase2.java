package com.yinting.core;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.yinting.core.Http.HttpRequest;

public class TestCase2 {
	@Test
	public void test() {
		Map<String, String> bodyes = new HashMap<String, String>();
		Request driver = new HttpRequest();
		bodyes.put("apiKey", "797z3it2mdh44weikz4x513irjq22pu9y292k246");
		bodyes.put("apiSequence", "2abffbfd7ef0b37bd254dcb3d9ee5429");
		bodyes.put("iLoupanID", "864");
		bodyes.put("name", "任清");
		bodyes.put("signFuncID", "100");
		bodyes.put("signature", "fb8ed8c47888ecca659591eb4047400f");
		bodyes.put("tel", "18179012032");
		bodyes.put("time", "1482735358");
		bodyes.put("youhui", "5834");

		driver.POST("http://api.st3.anhouse.com.cn/xf/lp/youhui.html").body("_from", "ios").bodyes(bodyes).invoke();
		System.out.println("-------------------TestCase2.java");
	}
}
