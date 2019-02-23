package com.filldream.sun.utils;

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
	
}
