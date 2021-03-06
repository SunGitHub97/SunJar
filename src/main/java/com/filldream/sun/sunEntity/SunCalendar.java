package com.filldream.sun.sunEntity;

import java.util.List;

/**
 * 万年历实体类
 * @author RickSun
 *
 */
public class SunCalendar {
	/**
	 * 禁忌
	 */
	private String avoid;
	
	/**
	 * 事宜
	 */
	private String suit;
	
	/**
	 * 是否工作日，0-工作日 1-节假日调休补班 2-休息日 数据异常为-1
	 */
	private Integer isWork;
	
	/**
	 * 节假日名称
	 */
	private String holiday;
	
	/**
	 * 农历日期
	 */
	private String lunar;
	
	/**
	 * 星期
	 */
	private String week;
	
	private String gan;

	public String getGan() {
		return gan;
	}

	public void setGan(String gan) {
		this.gan = gan;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	public String getAvoid() {
		return avoid;
	}

	public void setAvoid(String avoid) {
		this.avoid = avoid;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public Integer getIsWork() {
		return isWork;
	}

	public void setIsWork(Integer isWork) {
		this.isWork = isWork;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "SunCalendar [avoid=" + avoid + ", suit=" + suit + ", isWork=" + isWork + ", holiday=" + holiday
				+ ", lunar=" + lunar + ", week=" + week + ", gan=" + gan + "]";
	}
	
}
