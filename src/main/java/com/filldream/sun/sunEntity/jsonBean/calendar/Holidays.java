package com.filldream.sun.sunEntity.jsonBean.calendar;

public class Holidays {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWheres() {
		return wheres;
	}
	public void setWheres(String wheres) {
		this.wheres = wheres;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	private String wheres;
	private String type;
	private String month;
	private String day;
}