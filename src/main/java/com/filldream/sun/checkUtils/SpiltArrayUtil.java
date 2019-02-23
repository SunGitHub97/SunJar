package com.filldream.sun.checkUtils;

import java.util.HashMap;
import java.util.Map;
import com.filldream.sun.utils.SunCommon;

public class SpiltArrayUtil {
	
	/**
	 * 此方法或可去掉   存在转义BUG，仅部分情况可用，慎用
	 * 2018.10.14
	 */
	
	/**
	 * 
	 * @param funs
	 * @param funVal
	 * @param splitChar
	 * @return
	 */
	public static Map<String, Object> spiltArrayCheck(String funs, String funVal, String splitChar) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Integer.valueOf(-1));
		map.put("compare", Integer.valueOf(-1));
		map.put("msg", "提示信息");
		map.put("location", Integer.valueOf(-1));
		if ((SunCommon.isBlank(funs)) || (SunCommon.isBlank(funVal))) {
			map.put("msg", "参数不完整,funs:" + funs + "  funVal:" + funVal);
			return map;
		}
		if (SunCommon.isBlank(splitChar)) {
			splitChar = ",";
		}
		if(splitChar.equals(".") || splitChar.equals("|")|| splitChar.equals("+")|| splitChar.equals("*")) {
			splitChar = "\\"+splitChar;
		}
		String[] allFuns = null;
		try {
			allFuns = funs.split(splitChar);
			if (allFuns == null) {
				map.put("msg", "参数不完整,funs:" + funs);
				return map;
			}
			if (allFuns.length < 1) {
				map.put("msg", "参数不完整,funs:" + funs);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "抛异常错误");
			return map;
		}
		int location = -1;
		String[] arrayOfString1;
		int j = (arrayOfString1 = allFuns).length;
		for (int i = 0; i < j; i++) {
			String fun = arrayOfString1[i];
			location++;
			if (funVal.equals(fun)) {
				map.put("code", Integer.valueOf(0));
				map.put("compare", Integer.valueOf(0));
				map.put("location", Integer.valueOf(location));
				map.put("msg", "成功找到该值");
				return map;
			}
			map.put("code", Integer.valueOf(0));
			map.put("compare", Integer.valueOf(-1));
			map.put("msg", "不存在的传值:" + funVal);
		}
		return map;
	}

	public static String replaceByLocation(String fromString, Integer location, String reStr, String splitChar) {
		if (SunCommon.isBlank(splitChar)) {
			splitChar = ",";
		}
		String splitChar2 = splitChar;
		if(splitChar.equals(".") || splitChar.equals("|")|| splitChar.equals("+")|| splitChar.equals("*")) {
			splitChar = "\\"+splitChar;
		}
		
		if ((location.intValue() < 0) || (reStr.equals(""))) {
			return fromString;
		}
		String[] splitStr = null;
		try {
			splitStr = fromString.split(splitChar);
		} catch (Exception e) {
			e.printStackTrace();
			return fromString;
		}
		if (splitStr == null) {
			return fromString;
		}
		if (splitStr.length <= 1) {
			return fromString;
		}
		try {
			splitStr[location.intValue()] = reStr;
	
			StringBuilder sbString = new StringBuilder();
			for (int i = 0; i < splitStr.length; i++) {
				sbString.append(splitStr[i] + splitChar2);
			}
			return sbString.toString().substring(0, sbString.length() - 1);
		}catch(Exception e) {
			return fromString;
		}
	}
	
	public static String spiltStringToString(String pendStr,String spiltStr) {
		if(SunCommon.isBlank(spiltStr)) {
			return null;
		}
		if(SunCommon.isBlank(pendStr)) {
			return null;
		}
		
		String spiltStr2 = spiltStr;
		if(spiltStr.equals(".")) {
			spiltStr = "\\.";
		}
		
		String[] spilts = null;
		try {
			spilts = pendStr.split(spiltStr);
		} catch (Exception e) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int len = spilts.length;
		if(pendStr.indexOf(spiltStr2) == 0 && pendStr.indexOf(spiltStr2) == pendStr.lastIndexOf(spiltStr2)) {
			return pendStr;
		}
		for(int i = 0;i<len;i++) {
			sb.append(spilts[i]);
			if(i != len-1) {
				sb.append(spiltStr2);
			}
		}
		if(sb.toString().equals("") || (pendStr.equals(sb.toString()) && len == 1)) {
			return null;
		}
		
		return sb.toString();
	}
	
}
