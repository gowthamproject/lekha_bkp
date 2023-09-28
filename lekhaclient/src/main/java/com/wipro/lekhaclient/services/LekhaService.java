package com.wipro.lekhaclient.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public abstract class LekhaService {

	private static final String API_KEY = "257a93042496925ebe74f86ac5116faa070ef64c637746cabd2a2d97e08b9668";

	protected static String pullData(final String url, String httpMethod) throws IOException {
		URL weburl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(httpMethod);
		conn.setRequestProperty("Accept", "application/json");
		// conn.setRequestProperty("Cookie", HTTPSessionManager.COOKIE);
		conn.setRequestProperty("Authorization", API_KEY);

		// System.out.println("Output is: " + conn.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		return sb.toString();
	}

	protected static String pullData(final String url, Map<String, Object> params, String httpMetod)
			throws IOException {
		URL weburl = new URL(url);
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), String.valueOf(StandardCharsets.UTF_8)));
			postData.append('=');
			postData.append(
					URLEncoder.encode(String.valueOf(param.getValue()), String.valueOf(StandardCharsets.UTF_8)));
		}
		byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);

		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(httpMetod);
		// conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		// conn.setRequestProperty("Cookie", HTTPSessionManager.COOKIE);
		conn.setRequestProperty("Authorization", API_KEY);
		conn.getOutputStream().write(postDataBytes);
		// System.out.println("Output is: " + conn.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		return sb.toString();
	}

	protected String pullData_POST(final String url, Map<String, Object> params) throws IOException {
		URL weburl = new URL(url);
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), String.valueOf(StandardCharsets.UTF_8)));
			postData.append('=');
			postData.append(
					URLEncoder.encode(String.valueOf(param.getValue()), String.valueOf(StandardCharsets.UTF_8)));
		}
		byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);

		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("x-api-key", API_KEY);
		conn.getOutputStream().write(postDataBytes);
		// System.out.println("Output is: " + conn.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		return sb.toString();
	}

	protected String pullData_GET(final String url, Map<String, Object> params) throws IOException {
		StringBuilder data = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (data.length() != 0)
				data.append('&');
			data.append(URLEncoder.encode(param.getKey(), String.valueOf(StandardCharsets.UTF_8)));
			data.append('=');
			data.append(URLEncoder.encode(String.valueOf(param.getValue()), String.valueOf(StandardCharsets.UTF_8)));
		}
		URL weburl = new URL(url + "?" + data);
		HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("x-api-key", API_KEY);
		// System.out.println("Output is: " + conn.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		return sb.toString();
	}
}
