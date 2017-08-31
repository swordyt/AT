package com.yinting.core;

import java.util.HashMap;
import java.util.Map;
import com.yinting.core.BaseTestCase;
import com.yinting.core.Http.HttpResponse;
import com.yinting.core.Http.Json;
import com.yinting.tools.ExcelTools;

public abstract class TestCase extends BaseTestCase{
	//存储当前的请求参数
	protected Map<String,String> data=new HashMap<String, String>();
	protected Map<String,String> tmpData=new HashMap<String, String>();
	public TestCase setParameter(String name,String value){
		this.tmpData.put(name, value);
		return this;//支持链式输入
	}
	public TestCase setParameters(Map<String,String> data){
		this.tmpData.putAll(data);
		return this;//支持链式输入
	}
	/**
	 * 当全局接口参数存储中不存在该key时，会去搜索临时参数存储区。
	 * */
	public String getParameter(String name){
		return this.data.get(name);
	}
	public String getTmpParameter(String name){
		return this.tmpData.get(name);
	}
	/**
	 * 当全局接口参数存储为null时，自己返回临时参数存储区
	 * */
	public Map<String,String> getParameters() {
		return this.data;
	}
	public Map<String,String> getTmpParameters() {
		return this.tmpData;
	}
	// 修改sheet名 ，默认为“true”
	protected String sheet="true";
	public void setSheet(String sheet){
		this.sheet=sheet;
	}
	public String getSheet(){
		return sheet;
	}
	//快速设置登录状态
	public TestCase setLogin(String tokenId,String userId){
		this.tmpData.put("TokenId", tokenId);
		this.tmpData.put("UserId", userId);
		this.tmpData.put("userId", userId);
		return this;
	}
	//获取每个接口绑定的xls
	public abstract String getXLS();
	
	//保存当前接口json
	protected Json json;
	public Json getJson() {
		return json;
	}
	public String getValue(String path){
		return json.getValue(path);
	}
	//执行接口的几种方式
	public void send(Map data){
		data.putAll(this.tmpData);
		this.data=data;
		HttpResponse response = (HttpResponse) driver.request(this.data).invoke();
		json = (Json) response.JSON().getResponse();
	}
	public void send(int row){
		Map data=ExcelTools.data(this.getXLS(), this.getSheet(),row);
		send(data);
	}
	/**
	 * sheet
	 * */
	public void send(){
		Map data=ExcelTools.data(this.getXLS(), this.getSheet());
		send(data);
	}
}
