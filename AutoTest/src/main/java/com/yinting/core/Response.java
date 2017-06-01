package com.yinting.core;

import java.util.Map;

public interface Response {
	public Response assertStatus(String expect);

	public String status();

	public Response assertHeader(String header, String expect);

	public String header(String parameter);

	public Map getHeaderes();

	public Response assertValue(String path, String expect);

	public String getValue(String path);

	public String getBody();
}