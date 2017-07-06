package com.yinting.core;

import java.util.Map;

import org.testng.annotations.Test;

import com.yinting.core.Http.HttpRequest;
import com.yinting.core.Http.HttpResponse;
import com.yinting.core.datadriver.DataType;
import com.yinting.core.datadriver.Driver;
import com.yinting.tools.ExcelTools;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年6月2日 下午9:10:33 类说明
 */
public class TestCase extends BaseTestCase {
	@Test
	// @Driver(type = DataType.DB, parameter = {
	// "com.yinting.dao.User.getUser",
	// "value=6,id=100"})
	@Driver(type = DataType.EXCEL, parameter = { "CheckHfSuggest.xls", "run" })
	public void test6(Map data) {
		HttpResponse loginResp = (HttpResponse) driver.request(data).invoke();

		Map checkData = ExcelTools.data("CheckHfSuggest.xls", "check");
		checkData.put("TokenId", loginResp.JSON().getValue("resp.data.tokenId"));
		checkData.put("userId", loginResp.JSON().getValue("resp.data.userId"));
		driver.request(checkData).invoke();
		// Map map=ExcelTools.data("CheckHfSuggest.xls","run");
		// System.out.println(map.get("Source"));
		// HttpResponse response = (HttpResponse)driver.request(data).invoke();
		// String value=response.JSON().getValue("resp.data.tokenId");
		// System.out.println(value);
	}
}