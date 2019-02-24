package com.filldream.sun.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	 * 向指定URL发送POST请求
	 * @param url        url
	 * @param paramMap   参数map
	 * @return 响应结果为json
	 */
	public static String sendPost(String url, Map<String, String> paramMap) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// conn.setRequestProperty("Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
 
			// 设置请求属性
			String param = "";
			if (paramMap != null && paramMap.size() > 0) {
				Iterator<String> ite = paramMap.keySet().iterator();
				while (ite.hasNext()) {
					String key = ite.next();// key
					String value = paramMap.get(key);
					param += key + "=" + value + "&";
				}
				param = param.substring(0, param.length() - 1);
			}
			
 
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.err.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("pageNo", "1");
		mapParam.put("pageSize","10");
		mapParam.put("name","公文");
		String pathUrl = "http://client2.365hy.com/chengguan/admin/document/list";
		String result = sendPost(pathUrl, mapParam);
		System.out.println(result);
	}
}
