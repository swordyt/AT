package com.yinting.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
public class Request {
	public static Request GET(String url) { 
		HttpPost httppost=new HttpPost();
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("", ""));
		httppost.setEntity();
		return null;
	}

	public static Request POST(String url) {
		return null;
	}

	public static Request PUT(String url) {
		return null;
	}

	public static Request DELETE(String url) {
		return null;
	}

	public static Request HEAD(String url) {
		return null;
	}

	public static Request header(String parameter, String value) {
		return null;
	}

	public static Request headeres(Map headeres) {
		return null;
	}

	public static Request body(String parameter, String value) {
		return null;
	}

	public static Request bodyes(Map bodyes) {
		return null;
	}

	public static Response invoke() {
		return null;
	}
}
