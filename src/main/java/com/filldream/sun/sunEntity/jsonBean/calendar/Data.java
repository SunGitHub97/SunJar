package com.filldream.sun.sunEntity.jsonBean.calendar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * 万年历-数据实体类
 * @author RickSun
 * Json解析用
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private List<Almanac> almanac;
    private List<Holiday> holiday;
    private List<Holidaylist> holidaylist;
	public List<Almanac> getAlmanac() {
		return almanac;
	}
	public void setAlmanac(List<Almanac> almanac) {
		this.almanac = almanac;
	}
	public List<Holiday> getHoliday() {
		return holiday;
	}
	public void setHoliday(List<Holiday> holiday) {
		this.holiday = holiday;
	}
	public List<Holidaylist> getHolidaylist() {
		return holidaylist;
	}
	public void setHolidaylist(List<Holidaylist> holidaylist) {
		this.holidaylist = holidaylist;
	}
    

}