package com.yinting.core.Http;

import java.util.Map;

import com.yinting.core.Response;

public class HttpResponse implements Response {
	public HttpResponse(org.apache.http.HttpResponse resposne){
		
	}

	public Response assertStatus(String expect) {
		// TODO Auto-generated method stub
		return null;
	}

	public String status() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response assertHeader(String header, String expect) {
		// TODO Auto-generated method stub
		return null;
	}

	public String header(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getHeaderes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response assertValue(String path, String expect) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getValue(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBody() {
		// TODO Auto-generated method stub
		return null;
	}

}
