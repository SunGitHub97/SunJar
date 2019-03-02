package com.filldream.sun.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * Json工具类
 * @author fishlord
 * 2016年6月5日下午12:46:36
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串
     * 
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json字符串转化为对象
     * 
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T jsonToPojo(String content, Class<T> valueType) {
        try {
            T t = MAPPER.readValue(content, valueType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 将json字符串转化为map
     * 
     * @param content
     * @param valueType
     * @return
     */
    public static Map<String, Object> jsonToMap(String content) {
        try {
        	Map<String, Object> map = MAPPER.readValue(content, Map.class);
            return map;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json字符串转换成对象list
     * 
     * @param content
     * @param valueType
     * @return
     */
    public static <T>List<T> jsonToList(String content, Class<T> valueType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, valueType);
    	try {
    		List<T> list = MAPPER.readValue(content, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
