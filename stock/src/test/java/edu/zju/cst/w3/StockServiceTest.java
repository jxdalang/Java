package edu.zju.cst.w3;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** 
    * <p>Title: StockServiceTest.java</p>
    * <p>Description: </p>
    * @author Giant E-mail:wtctc@126.com 
    * @date Oct 9, 2015 3:39:17 PM 
    * @version 1.0  
*/
public class StockServiceTest {
	
	private static StockService stockService;
	@Before
	public void setUp()throws Exception{
		stockService = new StockService();
	}

	@Test
	public void testGetStockClosingPrice() {
		double actual = stockService.getStockClosingPrice("100001", new Date(2015,10,8));
		assertThat(actual, greaterThan(0.0));
	}

	@Test(expected=RuntimeException.class)
	public void testInsertStockClosingPrice() {
		stockService.insertStockClosingPrice("100001", new Date(2015,10,8), 1.2);
		double actual = stockService.getStockClosingPrice("100001", new Date(2015,10,8));
		assertThat(actual, closeTo(1.2, 0.2));
		stockService.insertStockClosingPrice("100001", new Date(2015,10,8), -1.2);
	}

	@Test
	public void testGetStockName() {
		String actual = stockService.getStockName("100001");
		assertThat(actual, equalTo("浙大网新"));
	}

	@Test
	public void testGetStockIdList() {
		List<String> actual = stockService.getStockIdList();
		assertThat(actual.size(), is(2));
//		System.out.println(actual);
	}

	@Test
	public void testGetBestStock() {
		String actual = stockService.getBestStock(new Date(2015,10,7),new Date(2015,10,8));
		assertThat(actual, equalTo("100002"));
	}

}
