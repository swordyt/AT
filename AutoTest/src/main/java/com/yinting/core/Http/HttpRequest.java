package com.yinting.core.Http;

import java.util.Date;
import java.util.Map;

import com.yinting.core.Request;
import com.yinting.core.Response;
import com.yinting.core.Test.TestFactory;

public class HttpRequest implements Request {
	private HttpRequest request;
	private String message;
	public Request body(String name, String value) {
		this.request.body(name, value);
		return this;
	}

	public Request bodyes(Map<String, String> bodyes) {
		this.request.bodyes(bodyes);
		return this;
	}

	public Request GET(String url) {
		TestFactory.getStep().setStartTime(new Date().getTime());
		this.request = new Get(url);
		this.message="driver.GET("+url+")";
		return this;
	}

	public Request POST(String url) {
		TestFactory.getStep().setStartTime(new Date().getTime());
		this.request = new Post(url);
		return this;
	}

	public Request PUT(String url) {
		TestFactory.getStep().setStartTime(new Date().getTime());
		// TODO Auto-generated method stub
		return null;
	}

	public Request DELETE(String url) {
		TestFactory.getStep().setStartTime(new Date().getTime());
		// TODO Auto-generated method stub
		return null;
	}

	public Request HEAD(String url) {
		TestFactory.getStep().setStartTime(new Date().getTime());
		return null;
	}

	public Request header(String name, String value) {
		this.message +=".header("+name+","+value+")";
		this.request.header(name, value);
		return this;
	}

	public Request headeres(Map<String, String> headeres) {
		this.headeres(headeres);
		return this;
	}

	public Response invoke() {
		this.message+=".invoke()";
		System.out.println(this.message);
		TestFactory.getStep().setEndTime(new Date().getTime());
		TestFactory.getStep().setStep(this.message);
		TestFactory.endStep();
		return this.request.invoke();
	}

}
