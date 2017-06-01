package com.yinting.core.Http;

import java.util.Map;
import com.yinting.core.Request;
import com.yinting.core.Response;

public class HttpRequest implements Request {
	private HttpRequest request;
	public Request body(String name, String value) {
		this.request.body(name, value);
		return this;
	}

	public Request bodyes(Map<String, String> bodyes) {
		this.bodyes(bodyes);
		return this;
	}

	public Request GET(String url) {
		this.request = new Get(url);
		return this;
	}

	public Request POST(String url) {
		this.request=new Post();
		return null;
	}

	public Request PUT(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public Request DELETE(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public Request HEAD(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public Request header(String name, String value) {
		this.request.header(name, value);
		return this;
	}

	public Request headeres(Map<String, String> headeres) {
		this.request.headeres(headeres);
		return this;
	}

	public Response invoke() {
		return this.request.invoke();
	}

}
