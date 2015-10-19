package edu.zju.cst.w3;

import java.util.Date;
import java.util.List;

/** 
    * <p>Title: IStockDAO.java</p>
    * <p>Description: Dao层接口</p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:16:31 PM 
    * @version 1.0  
*/
public interface IStockDAO {

	/**
	 * 获取收盘价格
	 * @param stockId 股票ID
	 * @param date 日期
	 * @return 指定日期和股票ID的收盘价格
	 */
	double getStockClosingPrice(String stockId, Date date);
	/**
	 * 插入收盘价格
	 * @param stockId 股票ID
	 * @param date 日期
	 * @param closingPrice 收盘价格
	 */
    void insertStockClosingPrice(String stockId, Date date, double  closingPrice);
    /**
     * 
     * @param stockId 股票ID
     * @return 股票名称
     */
    String getStockName(String stockId);
    /**
     * 
     * @return 所有股票ID
     */
    List<String> getStockIdList();
}
