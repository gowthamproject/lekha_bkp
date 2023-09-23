package com.wipro.lekhaclient.services;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
 
class HttpClient {
 
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
 
 
    public static ResponseBody doGetRequest(String url, String apiKey) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        Request request = setHeadersConfig(requestBuilder, apiKey).build();
        Response response = null;
		try {
			response = getClient().newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return response.body();
    }
 
    public static ResponseBody doPostRequest(String json, String url, String apiKey) {
        RequestBody body = RequestBody.create(json, JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);
        Request request = setHeadersConfig(requestBuilder, apiKey).build();
        Response response = null;
		try {
			response = getClient().newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return response.body();
    }
 
    public static ResponseBody doDeleteRequest(String json, String url, String apiKey) {
        RequestBody body = RequestBody.create(json, JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .delete(body);
        Request request = setHeadersConfig(requestBuilder, apiKey).build();
        Response response = null;
		try {
			response = getClient().newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return response.body();
    }
 
    private static Request.Builder setHeadersConfig(Request.Builder requestBuilder, String apiKey) {
        requestBuilder.header("Content-Type", "application/json")
                .header("X-MBX-APIKEY", apiKey);
        return requestBuilder;
    }
 
    private static OkHttpClient getClient() {
        return new OkHttpClient();
    }
}