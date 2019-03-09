package com.filldream.sun.utils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.filldream.sun.sunEntity.WeChatPayParams;

/**
 * 微信支付工具类
 * @author RickSun
 *
 */
public class WeChatPayUtil {
	
	private static final Logger log = LoggerFactory.getLogger(WeChatPayUtil.class);
	
	/**
	 * 获取微信支付参数，统一下单
	 * @param weChatPram	微信参数实体类
	 * @return	返回支付参数结果
	 */
	public static Map<String, String> getPayParam(WeChatPayParams weChatPram) {
		log.debug(weChatPram.toString());
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("appid", weChatPram.getAppId());// 微信开放平台审核通过的应用APPID
			params.put("mch_id", weChatPram.getMchId());// 微信支付分配的商户号
			params.put("nonce_str", RandomUtil.randAlphaNumString(24));// 随机字符串，不长于32位
			params.put("body", weChatPram.getBody());// 商品或支付单简要描述
			params.put("out_trade_no", weChatPram.getOutTradeNo());// 商户系统内部的订单号,32个字符内、可包含字母

			params.put("total_fee", weChatPram.getTotalFee());// 订单总金额，单位为分
			params.put("spbill_create_ip", weChatPram.getSpbillCreateIp());// 用户端实际ip
			params.put("notify_url", weChatPram.getNotifyUrl());// 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
			params.put("trade_type", weChatPram.getTradeType());// 支付类型
			String signStr = createLinkString(params);// 拼接URL
			signStr += "&key=" + weChatPram.getWxKey();

			String sign = EncryptUtil.md5Encode(signStr).toUpperCase();// 签名
			params.put("sign", sign);

			// 生成发送的XML
			String reqXml = mapToXml(params);

			// 生成预支付交易单请求
			String resp = UrlUtil.doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", reqXml);
			String prepayId = getPrepayId(resp,weChatPram.getWxKey());
			return buildReqDto(prepayId,weChatPram);

		} catch (Exception e) {
			log.error("获取微信参数失败", e);
			return Collections.emptyMap();
		}
	}
	
	
	/**
     * 获取微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     * @param resp
     * @return
     */
    private static String getPrepayId(String resp,String wxKey) {

        Map<String, String> respMap = xmlToMap(resp);
        if (respMap == null) {
            throw new RuntimeException("返回参数为空");
        }
        String return_code = respMap.get("return_code");
        String return_msg = respMap.get("return_msg");
        if ("SUCCESS".equals(return_code)) {
            String result_code = respMap.get("result_code");
            if ("SUCCESS".equals(result_code)) {
                if (verifySign(respMap,wxKey)) {
                    String prepay_id = respMap.get("prepay_id");
                    return prepay_id;
                } else {
                    throw new RuntimeException("WeixinpayService.getPrepayId sign verify error!");
                }
            } else {
                String err_code = respMap.get("err_code");
                String err_code_des = respMap.get("err_code_des");
                throw new RuntimeException(String.format("错误编码:%s , 错误描述:%s", err_code, err_code_des));
            }

        } else {
            throw new RuntimeException(return_msg);
        }
    }
    
    /**
     * 签名校验
     * 
     * @param params
     * @return
     */
    private static boolean verifySign(Map<String, String> params,String wxKey) {
        String sign = params.get("sign");
        Map<String, String> signMap = paraFilter(params);
        String signStr = createLinkString(signMap);
        signStr += "&key=" + wxKey;
        return EncryptUtil.md5Verify(signStr, sign);
    }
    
    /**
     * 生成支付请求参数
     * 
     * @param prepayId
     * @return
     */
    private static Map<String, String> buildReqDto(String prepayId,WeChatPayParams weChatPayParams) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", weChatPayParams.getAppId());// 微信开放平台审核通过的应用APPID
        params.put("partnerid", weChatPayParams.getMchId());// 微信支付分配的商户号
        params.put("prepayid", prepayId);//微信返回的支付交易会话ID
        params.put("package", "Sign=WXPay");//暂填写固定值Sign=WXPay
        params.put("noncestr", RandomUtil.randAlphaNumString(24));// 随机字符串，不长于32位
        params.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));//时间戳
        String signStr = createLinkString(params);
        log.info("signStr="+signStr);
        signStr += "&key=" + weChatPayParams.getWxKey();
        String sign = EncryptUtil.md5Encode(signStr).toUpperCase();//签名
        params.put("sign", sign);
        return params;
    }
    
    
    /**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
    private static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
    private static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 将map转换成XML
	 * @param params	map类型的参数
	 * @return	返回xml
	 */
	public static String mapToXml(Map<String, String> params) {
		Element root = DocumentHelper.createElement("root");
		Document document = DocumentHelper.createDocument(root);
		for (String key : params.keySet()) {
			Element element = root.addElement(key);
			element.addText(params.get(key));
		}
		return document.asXML();
	}

	/**
	 * 将返回的XML转换成map
	 * @param xml	xml文本
	 * @return	map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, String> xmlToMap(String xml) {
		Map<String, String> data = new HashMap<String, String>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		String FEATURE = null;
		try {

			FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
			documentBuilderFactory.setFeature(FEATURE, true);

			FEATURE = "http://xml.org/sax/features/external-general-entities";
			documentBuilderFactory.setFeature(FEATURE, false);

			FEATURE = "http://xml.org/sax/features/external-parameter-entities";
			documentBuilderFactory.setFeature(FEATURE, false);

			FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
			documentBuilderFactory.setFeature(FEATURE, false);

			documentBuilderFactory.setXIncludeAware(false);
			documentBuilderFactory.setExpandEntityReferences(false);

		} catch (ParserConfigurationException e) {
			log.error("ParserConfigurationException was thrown. The feature '" + FEATURE
					+ "' is probably not supported by your XML processor.");

		}
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			org.w3c.dom.Document doc = documentBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();
			for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				Node node = nodeList.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;
					data.put(element.getNodeName(), element.getTextContent());
				}
			}
			try {
				stream.close();
			} catch (Exception ex) {

			}
		} catch (Exception ex) {

		}
		return data;
	}
}
