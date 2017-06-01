package com.yinting.core.Http;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.yinting.core.Request;
import com.yinting.core.Response;

public class Get extends HttpRequest {
	private HttpClient client = new DefaultHttpClient();
	private HttpResponse response;
	private HttpGet get;
	private String url;

	public Get(String url) {
		this.url = url;
	}

	@Override
	public Request body(String name, String value) {
		if (this.url != null && this.url.contains("?")) {
			this.url += "&" + name + "=" + value;
		} else {
			this.url += "?" + name + "=" + value;
		}
		return null;
	}

	@Override
	public Request bodyes(Map<String, String> bodyes) {
		for (Map.Entry<String, String> entry : bodyes.entrySet()) {
			this.body(entry.getKey(), entry.getValue());
		}
		return null;
	}

	@Override
	public Request header(String name, String value) {
		this.get.addHeader(name, value);
		return null;
	}

	@Override
	public Request headeres(Map<String, String> headeres) {
		for(Map.Entry<String, String> entry:headeres.entrySet()){
			this.header(entry.getKey(), entry.getValue());
		}
		return null;
	}

	@Override
	public Response invoke() {
		try {
			this.get = new HttpGet(this.url);
			this.response = client.execute(this.get);
			System.out.println(EntityUtils.toString(this.response.getEntity(),
					"utf-8"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
