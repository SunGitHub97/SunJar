package com.filldream.sun.sunEntity.jsonBean.calendar;

import java.util.Date;

/**
 * 万年历-历书实体类
 * @author RickSun
 * Json解析用
 */
public class Almanac {

    private String avoid;
    private Date date;
    private String suit;
    public void setAvoid(String avoid) {
         this.avoid = avoid;
     }
     public String getAvoid() {
         return avoid;
     }

    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setSuit(String suit) {
         this.suit = suit;
     }
     public String getSuit() {
         return suit;
     }

}