package com.cli.messageprocessing.model;

import java.math.BigDecimal;

/**
 * JAVA bean class for sale Records
 * 
 * @author gauravs
 *
 */
public class SaleRecord {
	private String productName;
	private BigDecimal sellingPrice;
	private int saleQty;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(int saleQty) {
		this.saleQty = saleQty;
	}

	public BigDecimal totalSales() {
		return sellingPrice.multiply(BigDecimal.valueOf(saleQty));
	}
}
