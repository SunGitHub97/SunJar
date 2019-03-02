package com.filldream.sun.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;


/**
 * 获取id工具类
 * @author fishlord
 * 2016年6月5日上午1:39:20
 */
public class IpUtils {

	/**
	 * 获取客户端ip地址
	 * @param request
	 * @return
	 */
	public static String getRemoteIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    if(SunCommon.isNotEmpty(ip) && ip.indexOf(",") != -1){
	    	String[] temp = ip.split(",");
	    	ip = temp[0];
	    }
	    return ip;  
	}  
	
	/**
	 * 获取本机ip地址
	 * @return
	 */
	public static String getHostAddr(){
		 try {
			return InetAddress.getLocalHost().getHostAddress();//获得本机IP
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 return "";
	}
}
