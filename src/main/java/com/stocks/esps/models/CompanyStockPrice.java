package com.stocks.esps.models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CompanyStockPrice {

	private int day;
	private int month;
	private int year;
	private Date date;
	private Double price;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		Calendar myCal = new GregorianCalendar();
		myCal.setTime(date);
		this.date = date;
		this.day = myCal.get(Calendar.DAY_OF_MONTH);
		this.month = myCal.get(Calendar.MONTH);
		this.year = myCal.get(Calendar.YEAR);
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
