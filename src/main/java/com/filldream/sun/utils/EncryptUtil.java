package com.filldream.sun.utils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.filldream.sun.constants.ResultType;
import com.filldream.sun.utils.SunCommon;

/**
 * @Description:主要功能:加解密
 * @Prject: SunJar
 * @Package: com.filldream.sun.utils
 * @author: Rick.sun
 * @date: 2019年02月23日
 * @Copyright: Rick.Sun
 * @Company: FillDream
 */
public class EncryptUtil {
	
	/**
	 * Base64加密        无Key
	 * @param text
	 * @return
	 */
	public static String Base64Encode(String content) {
		return Base64.encodeBase64String(content.getBytes());
	}
	
	/**
	 * Base64加密        带Key
	 * @param content
	 * @param key
	 * @return
	 */
	public static String Base64Encode(String content, String key) {
		if (SunCommon.isNotBlank(key)) {
			content = content + key;
		}
		return Base64Encode(content);
	}
	
	
	/**
	 *  Base64解密       无Key
	 * @param text
	 * @return
	 */
	public static String Base64Decode(String content) {
		return new String(Base64.decodeBase64(content));
	}
	
	/**
	 * base64解密             有key
	 * @param content
	 * @param key
	 * @param base64
	 * @return
	 */
	public static boolean Base64Decode(String content, String key, String base64) {
        String myBase64 = Base64Encode(content, key);
        if (myBase64.equals(base64)) {
            return true;
        } else {
            return false;
        }
	}
	
	/**
	 * 生成uuid
	 * @return
	 */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    /**
     * Md5加密        无key
     * @param content
     * @return
     */
    public static String md5Encode(String content) {
		return DigestUtils.md5Hex(content);
	}
    
	
	/**
	 * 生成token
	 * @param projectKey
	 * @param second
	 * @return
	 */
	public static String setToken(Integer second) {
		Date overTime =DateUtil.getDateByAddCalendar(new Date(), Calendar.SECOND, second);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
		
		String time = simpleDateFormat.format(overTime);
		
		String token = getUUID() + time;
		return RandomUtil.randAlphaNumString(3).toUpperCase()+Base64Encode(token);
	}
	
	/**
	 * 校验token有效性
	 * @param code
	 * @param projectKey
	 * @return  0-正确 -1错误 -1002过时
	 */
	public static int checkToken(String token) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsss");
		try {
			String jiemi1 = Base64Decode(token.substring(3, token.length()));
			String time = jiemi1.substring(jiemi1.length() - 15,jiemi1.length());
			
			if(Long.valueOf(time) >= Long.valueOf(sdf.format(new Date()))) {
				return ResultType.success;
			}
			
			return ResultType.overTime;
		}catch (Exception e) {
			return ResultType.sysError;
		}
	}
	
}

