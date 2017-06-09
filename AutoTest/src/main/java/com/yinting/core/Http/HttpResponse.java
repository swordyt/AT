package com.yinting.core.Http;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.util.EntityUtils;

import com.yinting.core.Response;

public class HttpResponse implements Response {
	private org.apache.http.HttpResponse httpResponse;
	private HttpResponse response;
	private String body;
	protected HttpResponse(){
		
	}
	public HttpResponse(org.apache.http.HttpResponse response) {
		this.httpResponse = response;
		try {
			this.body = EntityUtils.toString(this.httpResponse.getEntity(),
					"utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		this.JSON();
	}

	public HttpResponse JSON() {
		this.response=new Json(this.httpResponse);
		return this;
	}
	public HttpResponse XML(){
		this.response=new Xml(this.httpResponse);
		return this;
	}
	public HttpResponse Html(){
		this.response=new Html(this.httpResponse);
		return this;
	}

	public HttpResponse assertStatus(String expect) {
		// TODO Auto-generated method stub
		return this;
	}

	public String status() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response assertHeader(String header, String expect) {
		// TODO Auto-generated method stub
		return null;
	}

	public String header(String name) {
		return this.httpResponse.getFirstHeader(name).getValue();
	}

	public Map<String, String> getHeaderes() {
		Map map = new HashMap<String, String>();
		for (Header header : this.httpResponse.getAllHeaders()) {
			map.put(header.getName(), header.getValue());
		}
		return map;
	}

	public Response assertValue(String path, String expect) {
		expect.equalsIgnoreCase(this.getValue(path));
		return null;
	}

	public String getValue(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBody() {
		return this.body;
	}

}
