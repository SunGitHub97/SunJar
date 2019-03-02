package com.filldream.sun.sunEntity.jsonBean.calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 万年历-Json实体类
 * @author RickSun
 * Json解析用
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarBean {

    private String status;
    private List<Data> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
    
}