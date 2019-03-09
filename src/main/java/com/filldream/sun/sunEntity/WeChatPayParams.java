package com.filldream.sun.sunEntity;

public class WeChatPayParams {

	private String appId;
	private String mchId;
	private String body;
	private String outTradeNo;
	private String totalFee;
	private String spbillCreateIp;
	private String notifyUrl;
	private String tradeType;
	private String wxKey;
	private String wxSecret;

	public String getAppId() {
		return appId;
	}
	
	/**
	 * 设置微信appid
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}
	
	/**
	 * 设置微信的商户号
	 * @param mchId
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}


	public String getBody() {
		return body;
	}
	
	/**
	 * 设置微信订单描述，尽量不要用中文
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}
	
	/**
	 * 设置一个唯一的订单编号
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTotalFee() {
		return totalFee;
	}
	
	/**
	 * 设置订单总金额，单位为分
	 * @param totalFee
	 */
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	
	/**
	 * 设置实际客户端IP
	 * @param spbillCreateIp
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	/**
	 * 设置微信回调地址
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}
	
	/**
	 * 设置支付类型：APP\JSSPI等等
	 * @param tradeType
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getWxKey() {
		return wxKey;
	}
	
	/**
	 * 设置微信支付的key
	 * @param wxKey
	 */
	public void setWxKey(String wxKey) {
		this.wxKey = wxKey;
	}

	public String getWxSecret() {
		return wxSecret;
	}
	
	/**
	 * 设置微信的Secret
	 * @param wxSecret
	 */
	public void setWxSecret(String wxSecret) {
		this.wxSecret = wxSecret;
	}

	@Override
	public String toString() {
		return "WeChatPayParamBean [appId=" + appId + ", mchId=" + mchId +  ", body=" + body
				+ ", outTradeNo=" + outTradeNo + ", totalFee=" + totalFee + ", spbillCreateIp=" + spbillCreateIp
				+ ", notifyUrl=" + notifyUrl + ", tradeType=" + tradeType + ", wxKey=" + wxKey + ", wxSecret="
				+ wxSecret + "]";
	}

	public WeChatPayParams(String appId, String mchId, String nonce, String body, String outTradeNo, String totalFee,
			String spbillCreateIp, String notifyUrl, String tradeType, String wxKey, String wxSecret) {
		super();
		this.appId = appId;
		this.mchId = mchId;
		this.body = body;
		this.outTradeNo = outTradeNo;
		this.totalFee = totalFee;
		this.spbillCreateIp = spbillCreateIp;
		this.notifyUrl = notifyUrl;
		this.tradeType = tradeType;
		this.wxKey = wxKey;
		this.wxSecret = wxSecret;
	}

	public WeChatPayParams() {
		super();
	}

}
