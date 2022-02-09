package com.situ.model;

import com.situ.utils.DateRange;


/**
 * 用于表单查询的bean实例
 * 
 * @author 浅墨~~
 * @date 2021年12月8日
 */
public class EmployeeSearchBean extends Employee {

	private String birthdayRange;// 出生日期的时间范围
	private String begin;
	private String end;
	
	public DateRange getBirthdayRange() {
		return DateRange.of(birthdayRange," - ");
	}

	public void setBirthdayRange(String birthdayRange) {
		this.birthdayRange = birthdayRange;
	}

	public String getBegin() {
		if(birthdayRange!=null&&!birthdayRange.trim().isEmpty()) {
			String[] p = birthdayRange.split(" - ");
			if(p[0]!=null&&!p[0].trim().isEmpty()) {
				return p[0];
			}
		}
		
		return null;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		if(birthdayRange!=null&&!birthdayRange.trim().isEmpty()) {
			String[] p = birthdayRange.split(" - ");
			if(p.length>1&&p[1]!=null&&!p[1].trim().isEmpty()) {
				return p[1];
			}
		}
		return null;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
	

}
