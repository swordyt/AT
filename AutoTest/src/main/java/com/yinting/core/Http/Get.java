package com.yinting.core.Http;

import java.util.Map;

import com.yinting.core.Request;
import com.yinting.core.Response;

public class Get extends HttpRequest{

	@Override
	public Request body(String name, String value) {
		
		return super.body(name, value);
	}

	@Override
	public Request bodyes(Map<String, String> bodyes) {
		// TODO Auto-generated method stub
		return super.bodyes(bodyes);
	}

	@Override
	public Request header(String name, String value) {
		// TODO Auto-generated method stub
		return super.header(name, value);
	}

	@Override
	public Request headeres(Map<String, String> headeres) {
		// TODO Auto-generated method stub
		return super.headeres(headeres);
	}

	@Override
	public Response invoke() {
		// TODO Auto-generated method stub
		return super.invoke();
	}

}
