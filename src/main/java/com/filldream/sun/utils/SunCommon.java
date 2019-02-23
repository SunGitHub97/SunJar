package com.filldream.sun.utils;

/**
 * @Description:主要功能: SunJar的标准类
 * @Prject: SunJar
 * @Package: com.filldream.sun.utils
 * @author: Rick.sun
 * @date: 2019年02月23日
 * @Copyright: Rick.Sun
 * @Company: FillDream
 * @version: 1.0.0
 * 注：将一些需要依赖才能实现方法在这里实现,减少SunJar的依赖
 */
public class SunCommon {
	
	/**
	 * 判断字符串是否为null或者去空为空的字符串，为空返回true,否则返回false
	 * @param str
	 * @return
	 * 注：类似org.apache.commons.lang3.StringUtils.isBlank
	 */
	public static boolean isBlank (String str) {
		if(str == null) {
			return true;
		}
		if(str.trim().length()<1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为null或者去空为空的字符串，为空返回false,否则返回true
	 * @param str
	 * @return
	 * 注：类似org.apache.commons.lang3.StringUtils.isNotBlank
	 */
	public static boolean isNotBlank (String str) {
		return !isBlank(str);
	}
	
	/**
	 * 判断字符串是否为null，为空返回true,否则返回false
	 * @param str
	 * @return
	 * 注：类似org.apache.commons.lang3.StringUtils.isEmpty
	 */
	public static boolean isEmpty(String str) {
		if(str == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为null，为空返回false,否则返回true
	 * @param str
	 * @return
	 * 注：类似org.apache.commons.lang3.StringUtils.isNotEmpty
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
