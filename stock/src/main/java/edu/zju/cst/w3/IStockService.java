package edu.zju.cst.w3;

import java.util.Date;
import java.util.List;

/** 
    * <p>Title: IStockService.java</p>
    * <p>Description: Service层接口</p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:18:01 PM 
    * @version 1.0  
*/
public interface IStockService {
	/**
	 * 
	 * @param stockId 股票ID
	 * @param date 指定日期
	 * @return 收盘价格
	 */
	double getStockClosingPrice(String stockId, Date date);
	/**
	 * 
	 * @param stockId 股票ID
	 * @param date 指定日期
	 * @param closingPrice 收盘价格
	 */
    void insertStockClosingPrice(String stockId, Date date, double closingPrice);
    /**
     * 
     * @param id 股票ID
     * @return 股票名称
     */
    String getStockName(String  id);
    /**
     * 
     * @return 所有股票ID
     */
    List<String> getStockIdList();
    /**
     * 
     * @param startDate 开启日期
     * @param endDate 结束日期
     * @return 涨幅最高的股票ID
     */
    String getBestStock(Date startDate, Date endDate); 
    
}
