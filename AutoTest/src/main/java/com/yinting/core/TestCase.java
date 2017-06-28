package com.yinting.core;

import java.util.Map;

import org.testng.annotations.Test;
import com.yinting.core.datadriver.DataType;
import com.yinting.core.datadriver.Driver;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年6月2日 下午9:10:33 类说明
 */
public class TestCase extends BaseTestCase{
	@Test
	@Driver(type = DataType.DB, parameter = {
			"com.yinting.dao.User.getUser",
			"value=6,iAutoID=5000"})
	public void test6(Map data) {
		System.out.println(data.get("iAutoID")+"==="+data.get("sNickname")+"======"+data.get("sMobile"));
	}
}
