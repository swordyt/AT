package com.yinting.core;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

public interface Request {
	public Request GET(String url);

	public Request POST(String url);

	public Request PUT(String url);

	public Request DELETE(String url);

	public Request HEAD(String url);

	public Request header(String name, String value);

	public Request headeres(Map<String,String> headeres);

	public Request body(String name, String value);

	public Request bodyes(Map<String,String> bodyes);

	public Response invoke();
}
