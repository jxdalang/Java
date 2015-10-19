package edu.zju.cst.w3;

import java.util.Date;

/** 
    * <p>Title: Stock.java</p>
    * <p>Description:股票信息类 </p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:14:15 PM 
    * @version 1.0  
*/
public class Stock {
	//股票代码
	String id;
	//:股票名称
	String name;
	//股票收盘价
	double closingPrice;
	//日期
	Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public Date getDate() {
		return date;
	}
	public Stock(String id, String name, double closingPrice, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.closingPrice = closingPrice;
		this.date = date;
	}
}
