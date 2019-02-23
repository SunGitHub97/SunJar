package com.filldream.sun.sunEntity;

import java.util.Map;

import com.filldream.sun.utils.SmsUtil;

/**
 * 阿里短信配置，单例模式
 * @author RickSun
 *
 */
public class AliSms {
	private String keyId;
	private String keySecret;
	private String signName;
	private static AliSms instance;

	private AliSms(String keyId, String keySecret, String signName) {
		this.keyId = keyId;
		this.keySecret = keySecret;
		this.signName = signName;
	}

	private AliSms() {}

	public static AliSms getInstance(String keyId, String keySecret, String signName) { // 对获取实例的方法进行同步
		if (instance == null) {
			synchronized (AliSms.class) {
				if (instance == null)
					instance = new AliSms(keyId, keySecret, signName);
			}
		}
		return instance;
	}
	
	
	
	//getter setter
	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getKeySecret() {
		return keySecret;
	}

	public void setKeySecret(String keySecret) {
		this.keySecret = keySecret;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}
	
}
