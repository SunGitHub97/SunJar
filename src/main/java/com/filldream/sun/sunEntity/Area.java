package com.filldream.sun.sunEntity;

import java.util.List;

/**
 * 省市区 实体类
 * @author RickSun
 *
 */
public class Area {
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public List<Area> getDistricts() {
		return districts;
	}
	public void setDistricts(List<Area> districts) {
		this.districts = districts;
	}
	private String adcode;
	private String level;
	private String name;
	private String fullname;
	private List<Area> districts;
}
