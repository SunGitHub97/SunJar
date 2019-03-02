package com.filldream.sun.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.filldream.sun.sunEntity.AliSms;

/**
 * 短信工具类
 * @author RickSun
 *
 */
public class SmsUtil {
	
	/**
	 * 使用单例配置发送短信
	 * @param aliSms         配置类
	 * @param templateCode   短信模板
	 * @param messageMap     短信参数
	 * @param mobile         手机号
	 * @return
	 */
	public static  Map<String, Object> sendNormalMsgByAlisms(AliSms aliSms,String templateCode,
			Map<String, String> messageMap, String mobile
			) {
		return sendNormalMsg(
				aliSms.getKeyId(),aliSms.getKeySecret(),aliSms.getSignName(),templateCode,
				messageMap,mobile);
	}
	
	/**
	 * 详细配置发送短信
	 * @param keyId           阿里keyId
	 * @param keySecret       阿里keySecret
	 * @param signName        阿里签没signName
	 * @param templateCode    短信模板
	 * @param messageMap      短信参数
	 * @param mobile          手机号
	 * @return
	 */
	public static  Map<String, Object> sendNormalMsg(
			String keyId,String keySecret,String signName,String templateCode,
			Map<String, String> messageMap, String mobile) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("supplier", "alibaba-aliyun-3.2.3");
		resultMap.put("code", -1);
		resultMap.put("mobile", mobile);
		resultMap.put("createTime", new Date());
		resultMap.put("dataMap",messageMap);
		try {
			// 可自助调整超时时间
			System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			System.setProperty("sun.net.client.defaultReadTimeout", "10000");

			// 初始化acsClient,暂不支持region化
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", keyId, keySecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
			IAcsClient acsClient = new DefaultAcsClient(profile);

			// 组装请求对象-具体描述见控制台-文档部分内容
			SendSmsRequest request = new SendSmsRequest();
			// 必填:待发送手机号
			request.setPhoneNumbers(mobile);
			// 必填:短信签名-可在短信控制台中找到
			request.setSignName(signName);
			// 必填:短信模板-可在短信控制台中找到
			request.setTemplateCode(templateCode);
			String json = new JSONObject().valueToString(messageMap);
			request.setTemplateParam(json);
			// hint 此处可能会抛出异常，注意catch
			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			resultMap.put("code", 0);
			resultMap.put("aliCode", sendSmsResponse.getCode());
			resultMap.put("message", sendSmsResponse.getMessage());
			resultMap.put("requestId", sendSmsResponse.getRequestId().toString());
			resultMap.put("bizId", sendSmsResponse.getBizId().toString());
			return resultMap;
		} catch (Exception e) {
			return resultMap;
		}
	}
	
	/**
	 * 创建Demo
	 */
	public static void help() {
		System.out.println("	static final String keyId = \"xxx\";\r\n" + 
				"	static final String keySecret = \"xxxxx\";\r\n" + 
				"	static final String signName = \"iFillDeam\";\r\n" + 
				"	static final String registTemplateCode = \"SMS_14xxx57\";\r\n" + 
				"	static final String updateTemplateCode = \"SMS_14xxx97\";\r\n" + 
				"	static AliSms aliSms = AliSms.getInstance(\"xxx\", \"xxxxx\", \"iFillDeam\");\r\n" + 
				"	public static Map<String, Object> sendMsg(Map<String, String> map, String mobile) {\r\n" + 
				"		// SmsUtil.sendNormalMsgByAlisms(aliSms,\"SMS_14xxx57\", map, \"137******13\");\r\n" + 
				"		return SmsUtil.sendNormalMsg(keyId, keySecret, signName, updateTemplateCode, map, mobile);\r\n" + 
				"	}");
	}
}