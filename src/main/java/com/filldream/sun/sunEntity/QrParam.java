package com.filldream.sun.sunEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

/**
 * 二维码属性 实体类
 * @author RickSun
 *
 */
public class QrParam {
	private String urlParamName; //该字段的名称
	private String content;    //二维码内容
	private Long createTime;    //二维码创建时间
	private Long endTime;       //二维码失效时间
	private String checkFlag;    //二维码合法性
	private String diyFlag;      //自定义标签
	
	
	
	
	@Override
	public String toString() {
		JSONObject jsonObject = new JSONObject(this);
		return jsonObject.toString();
	}
	
	public static QrParam jsonToEean(String jsonStr) {
		JSONObject jsonObject = new JSONObject(jsonStr);
		QrParam qrParam = new QrParam();
		if(jsonObject.has("checkFlag")) {
			qrParam.setCheckFlag(jsonObject.getString("checkFlag"));
		}
		if(jsonObject.has("content")) {
			qrParam.setContent(jsonObject.getString("content"));
		}
		if(jsonObject.has("diyFlag")) {
			qrParam.setDiyFlag(jsonObject.getString("diyFlag"));
		}
		if(jsonObject.has("endTime")) {
			qrParam.setEndTime(jsonObject.getLong("endTime"));
		}
		if(jsonObject.has("createTime")) {
			qrParam.setCreateTime(jsonObject.getLong("createTime"));
		}
		if(jsonObject.has("urlParamName")) {
			qrParam.setUrlParamName(jsonObject.getString("urlParamName"));
		}
		return qrParam;
	}


	public QrParam() {
		super();
	}
	
	public QrParam(String urlParamName, String content, Long createTime, Long endTime, String checkFlag,
			String diyFlag) {
		super();
		this.urlParamName = urlParamName;
		this.content = content;
		this.createTime = createTime;
		this.endTime = endTime;
		this.checkFlag = checkFlag;
		this.diyFlag = diyFlag;
	}
	
	
	public String getUrlParamName() {
		return urlParamName;
	}
	public void setUrlParamName(String urlParamName) {
		this.urlParamName = urlParamName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public String getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	public String getDiyFlag() {
		return diyFlag;
	}
	public void setDiyFlag(String diyFlag) {
		this.diyFlag = diyFlag;
	}
	
	
	
}
