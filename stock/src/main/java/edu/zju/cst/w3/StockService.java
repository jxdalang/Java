package edu.zju.cst.w3;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
    * <p>Title: StockService.java</p>
    * <p>Description:Stock的Service层代码 </p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:20:01 PM 
    * @version 1.0  
*/
public class StockService implements IStockService {

	private IStockDAO stockDAO = new StockDaoMap();
	/**
	 * 根据股票ID和日期获取收盘价格
	 */
	public double getStockClosingPrice(String stockId, Date date) {
		return stockDAO.getStockClosingPrice(stockId, date);
	}
	/**
	 * 根据股票Id和日期插入收盘价格
	 */
	public void insertStockClosingPrice(String stockId, Date date, double closingPrice) {
		stockDAO.insertStockClosingPrice(stockId, date, closingPrice);
	}
	/**
	 * 根据股票ID获取股票名称
	 */
	public String getStockName(String id) {
		return stockDAO.getStockName(id);
	}
	/**
	 * 获取所有的股票ID
	 */
	public List<String> getStockIdList() {
		return stockDAO.getStockIdList();
	}
	/**
	 * 获取指定时间内涨幅最高的股票
	 */
	public String getBestStock(Date startDate, Date endDate) {
		List<String> stockIdList = stockDAO.getStockIdList();
		double startPrice,endPrice,cha;
		double max = 0;
		Map<Double,String> value = new HashMap<Double,String>();
		for (String id : stockIdList) {
			startPrice = stockDAO.getStockClosingPrice(id, startDate);
			endPrice = stockDAO.getStockClosingPrice(id, endDate);
			cha = endPrice-startPrice;
			value.put(cha, id);
			if(cha>max){
				max = cha;
			}
		}
		return value.get(max);
	}

}
