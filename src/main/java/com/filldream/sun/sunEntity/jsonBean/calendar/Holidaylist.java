package com.filldream.sun.sunEntity.jsonBean.calendar;
import java.util.Date;

/**
 * 万年历-拼假列表实体类
 * @author RickSun
 * Json解析用
 */
public class Holidaylist {

    private String name;
    private Date startday;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setStartday(Date startday) {
         this.startday = startday;
     }
     public Date getStartday() {
         return startday;
     }

}