package com.filldream.sun.utils;

import java.util.Calendar;
import java.util.Random;


/**
 * 随机工具类
 * @author RickSun
 *
 */
public class RandomUtil {
	//字母
	private static final String ALPHABET= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//数字
	private static final String ARABNUMBER = "0123456789";
    //字母数字混合
    private static final String ALPHANUM = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //所有字符
    private static final String ALPHANUMSYMBOL =
    		"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ！@￥%……&*()-——+=#$%^&*;',.";
	
	/**
	 * 随机字母
	 * @param len  随机长度
	 * @return 字符串
	 */
    public static String randomAlphbetString(int len) {
    	if(len < 1) {
    		return "";
    	}
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
    
    /**
     * 随机数字
     * @param len 随机长度
     * @return 字符串
     */
    public static String randomNumberString(int len) {
    	if(len < 1) {
    		return "";
    	}
    	StringBuffer sb = new StringBuffer();
    	Random random = new Random();
    	for (int i = 0; i < len; i++) {
    		sb.append(ARABNUMBER.charAt(random.nextInt(ARABNUMBER.length())));
    	}
    	return sb.toString();
    }
    
    
    
    /**
     * 随机规定范围的数字，默认包含两数
     * @param start	起始数字
     * @param end	结束数字
     * @return 整型数字
     */
    public static Integer randomNumByInterval(int start,int end) {
    	if(start > end) {
    		Integer t = start;
    		start = end;
    		end = t;
    	}
    	Random random = new Random();
    	return random.nextInt(end)%(end-start+1) + start;
    }
    
    
    /**
     * 随机规定范围的数字
     * @param start              开始范围
     * @param end                结束范围
     * @param containLeftm       是否包含开始数字
     * @param containRigth       是否包含结束数字
     * @return 整型数字
     */
    public static Integer randomNumByInterval(int start,int end,Boolean containLeftm,Boolean containRigth) {
    	if(start > end) {
    		Integer t = start;
    		start = end;
    		end = t;
    	}
    	Random random = new Random();
    	Integer result = random.nextInt(end)%(end-start+1) + start;
    	if(containLeftm == true && containRigth == false) {
    		while( result == end) {
    			result = random.nextInt(end)%(end-start+1) + start;
    		}
    	}else if(containLeftm == false && containRigth == true) {
    		while( result == start) {
    			result = random.nextInt(end)%(end-start+1) + start;
    		}
    	}else if(containLeftm == false && containRigth == false){
    		while( result == start || result == end) {
    			result = random.nextInt(end)%(end-start+1) + start;
    		}
    	}
    	return result;
    }
    
    
    
    
    /**
     * 随机字母数字混合字符
     * @param len  随机长度
     * @return 字符串
     */
    public static String randAlphaNumString(int len) {
    	if(len < 1) {
    		return "";
    	}
    	StringBuffer sb = new StringBuffer();
    	Random random = new Random();
    	for (int i = 0; i < len; i++) {
    		sb.append(ALPHANUM.charAt(random.nextInt(ALPHANUM.length())));
    	}
    	return sb.toString();
    }
    
    /**
     * 从指定字符串中随机指定个数的字符串
     * @param fromString	指定字符串
     * @param len	长度
     * @return 字符串
     */
    public static String randDesignatedString(String fromString , int len) {
    	if(SunCommon.isBlank(fromString)) {
    		return "";
    	}
    	if(fromString.length() < 2) {
    		return fromString;
    	}
    	if(len < 1) {
    		return "";
    	}
    	StringBuffer sb = new StringBuffer();
    	Random random = new Random();
    	for (int i = 0; i < len; i++) {
    		sb.append(fromString.charAt(random.nextInt(fromString.length())));
    	}
    	return sb.toString();
    }
}
