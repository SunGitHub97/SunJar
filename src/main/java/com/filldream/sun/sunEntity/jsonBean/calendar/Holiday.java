package com.filldream.sun.sunEntity.jsonBean.calendar;
import java.util.Date;
import java.util.List;

/**
 * 万年历-当月假期集合实体类
 * @author RickSun
 * Json解析用
 */
public class Holiday {

    private String desc;
    private Date festival;
    private List<Work> list;
    private int listNum;
    private String name;
    private String rest;
    public void setDesc(String desc) {
         this.desc = desc;
     }
     public String getDesc() {
         return desc;
     }

    public void setFestival(Date festival) {
         this.festival = festival;
     }
     public Date getFestival() {
         return festival;
     }

    public void setList(List<Work> list) {
         this.list = list;
     }
     public List<Work> getList() {
         return list;
     }

    public void setListNum(int listNum) {
         this.listNum = listNum;
     }
     public int getListNum() {
         return listNum;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setRest(String rest) {
         this.rest = rest;
     }
     public String getRest() {
         return rest;
     }

}