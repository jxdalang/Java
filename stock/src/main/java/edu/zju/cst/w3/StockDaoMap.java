package edu.zju.cst.w3;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** 
    * <p>Title: StockDaoMap.java</p>
    * <p>Description:封装底层的业务数据以及对数据的操作 </p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:21:50 PM 
    * @version 1.0  
*/
public class StockDaoMap implements IStockDAO {
	/**
	 * 静态变量，用于临时存储数据
	 */
	private static Map<String,List<Stock>> map = new HashMap<String, List<Stock>>();
	static{
		Stock stock1 = new Stock("100001", "浙大网新", 3.12, new Date(2015,10,7));
		Stock stock2 = new Stock("100001", "浙大网新", 3.56, new Date(2015,10,8));
		List<Stock> list = new ArrayList<Stock>();
		list.add(stock1);
		list.add(stock2);
		map.put("100001", list);
		stock1 = new Stock("100002", "京东", 5.68, new Date(2015,10,7));
		stock2 = new Stock("100002", "京东", 8.21, new Date(2015,10,8));
		list = new ArrayList<Stock>();
		list.add(stock1);
		list.add(stock2);
		map.put("100002", list);
	}
	/**
	 * 对传入股票参数进行检测：六位数字
	 * @param stockid 股票ID
	 */
	private void checkId(String stockid){
		//
		String id = stockid.trim();
		if(id != null & id.length() == 6){
			return;
		}else{
			throw new RuntimeException("您输入的股票编号错误！");
		}
	}
	/**
	 * 对传入的价格参数进行检测，必须为正数
	 * @param closingPrice 收盘价格
	 */
	private void checkPrice(double closingPrice){
		//对传入参数进行检测：StockId的形式是六位数字，比如“300100”，“600000”，其他形式无效；价格必须是正数
		if(closingPrice >0){
			return;
		}else{
			throw new RuntimeException("您输入的价格错误！");
		}
	}
	/**
	 * 根据股票ID和日期获取股票收盘价格
	 */
	public double getStockClosingPrice(String stockId, Date date) {
		checkId(stockId);
		List<Stock> list = map.get(stockId);
		for (Stock stock : list) {
			if(stock.getDate().compareTo(date)==0){
				return stock.getClosingPrice();
			}
		}
		throw new RuntimeException("找不到改日的收盘价格！");
	}
	/**
	 * 根据股票ID和日期插入收盘价格
	 */
	public void insertStockClosingPrice(String stockId, Date date, double closingPrice) {
		checkId(stockId);
		checkPrice(closingPrice);
		List<Stock> list = map.get(stockId);
//		System.out.println("canshu:"+date.toString());
		if (list.size()>0) {
			for (Stock stock : list) {
//				System.out.println("stock:"+stock.getDate().toString());
				if(stock.getDate().compareTo(date)==0){
					list.remove(stock);
					stock.setClosingPrice(closingPrice);
					list.add(stock);
					map.put(stockId, list);
					return;
				}
			}
			throw new RuntimeException("找不到"+stockId+"下，"+date.toString()+"的收盘价格！");
		}else{
			throw new RuntimeException("找不到"+stockId+"!");
		}
		//throw new RuntimeException("找不到"+stockId+"下，"+date.toString()+"的收盘价格！");
	}
	/**
	 * 根据股票ID获取股票名称
	 */
	public String getStockName(String stockId) {
		checkId(stockId);
		List<Stock> list = map.get(stockId);
		return list.get(0).getName();
	}
	/**
	 * 获取所有股票ID
	 */
	public List<String> getStockIdList() {
		List<String> idList = new ArrayList<String>();
		for(Map.Entry<String, List<Stock>> entry: map.entrySet()){
			idList.add(entry.getKey());
		}
		return idList;
	}
	
}
