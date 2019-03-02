package com.filldream.sun.sunEntity.jsonBean.calendar;
import java.util.Date;

/**
 * 万年历-班休实体类
 * @author RickSun
 *
 */
public class Work {

    private Date date;
    private String code;
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	private Integer data;
    private String status;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

}