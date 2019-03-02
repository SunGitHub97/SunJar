package com.filldream.sun.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * URL工具类
 * @author RickSun
 *
 */
public class UrlUtil {

	/**
	 * 拼接URL/接口参数
	 * @param linkUrl      url/接口
	 * @param paramMap     参数Map
	 * @return
	 */
	public static String splicingParam(String linkUrl, Map<String, Object> paramMap) {

		StringBuffer url = new StringBuffer();
		if(paramMap.size() > 0) {
			url.append(linkUrl+"?");
		}else {
			url.append(linkUrl);
		}

		Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
		int num = 0;
		for (Map.Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			String param = key + "=" + value;
			if(num == 0 || num >= paramMap.size()) {
				url.append(param);
			}else {
				url.append("&" + param );
			}
			num++;
		}
		return url.toString();
	}
	
	
	/**
	 * 向指定URL发送Get请求
	 * @param url
	 * @return 返回json
	 * @throws IOException
	 */
	public static String doGet(String url) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		get.setConfig(config);
		CloseableHttpResponse response = httpClient.execute(get);
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new IOException();
		}else {
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity,StandardCharsets.UTF_8);
			EntityUtils.consume(entity);
			return res;
		}
	}
	
	/**
	 * 向指定URL发送Get请求
	 * @param url	url地址
	 * @param param	参数
	 * @return	返回Json
	 * @throws IOException
	 */
	public static String doGet(String url,Map<String, String> param) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String queryStr = "";
		if (param!=null) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keySet = param.keySet();
			for (String key : keySet) {
				params.add(new BasicNameValuePair(key, param.get(key)));
			}
			queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		}
		url+=(SunCommon.isBlank(queryStr)?"":("?"+ queryStr));
		HttpGet get = new HttpGet(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		get.setConfig(config);
		CloseableHttpResponse response = httpClient.execute(get);
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new IOException();
		}else {
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity,StandardCharsets.UTF_8);
			EntityUtils.consume(entity);
			return res;
		}
	}
	
	
	/**
	 * 向指定URL发送Post请求
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String url,Map<String, String> param) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		post.setConfig(config);
		if (param!=null) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keySet = param.keySet();
			for (String key : keySet) {
				params.add(new BasicNameValuePair(key, param.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		}
		CloseableHttpResponse response = httpClient.execute(post);
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new IOException();
		}else {
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity,StandardCharsets.UTF_8);
			EntityUtils.consume(entity);
			return res;
		}
	}
}
