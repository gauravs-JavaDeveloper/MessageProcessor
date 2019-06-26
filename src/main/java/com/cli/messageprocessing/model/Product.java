package com.cli.messageprocessing.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * JAVA bean class for Product
 * 
 * @author gauravs
 *
 */
public class Product {

	private String productName;
	private BigDecimal unitPrice;
	private int totalUnits;
	private List<SaleRecord> sales;
	private List<String> history;

	public List<SaleRecord> getSales() {
		return sales;
	}

	public void setSales(List<SaleRecord> sales) {
		this.sales = sales;
	}

	public List<String> getHistory() {
		return history;
	}

	public void setHistory(List<String> history) {
		this.history = history;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

}
