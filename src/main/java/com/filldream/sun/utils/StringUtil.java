package com.filldream.sun.utils;


/**
 * 字符串相关工具类
 * @author RickSun
 * @date 2018-09-22
 */
public class StringUtil {
	
	/**
	 * 去掉最右边的指定字符串
	 * @param str        待处理字符串
	 * @param rStr  指定字符串  空格不处理
	 * @return  两个字符串相等返回空，没找到指定字符串则返回待处理字符串 
	 */
	public static String rTrim(String str, String rStr) {
		
		if(SunCommon.isBlank(str)) {
			return "";
		}
		if(SunCommon.isBlank(rStr)) {
			return str;
		}
		if(str.equals(rStr)) {
			return "";
		}
		int lastIndex = str.lastIndexOf(rStr);
//		System.out.println(lastIndex);
		if(lastIndex < 0) {
			return str;
		}
		if(lastIndex >= 0) {
			return str.substring(0, str.length() - rStr.length());
		}
		return str;
	}
	
	/**
	 * 去掉最左边的指定字符串
	 * @param str        待处理字符串
	 * @param lStr  指定字符串  空格不处理
	 * @return  两个字符串相等返回空，没找到指定字符串则返回待处理字符串 
	 */
	public static String lTrim(String str, String lStr) {
		
		if(SunCommon.isBlank(str)) {
			return "";
		}
		if(SunCommon.isBlank(lStr)) {
			return str;
		}
		int frist = str.indexOf(lStr);
		if(frist != 0) {
			return str;
		}
		if(frist == 0) {
			if(str.equals(lStr)) {
				return "";
			}
			return str.substring(lStr.length(), str.length());
		}
		return str;
	}
	
	
	
	
	
	
	
	
	
	
}
