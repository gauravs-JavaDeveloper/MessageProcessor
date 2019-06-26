package com.cli.messageprocessing.salesmessageprocessor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cli.messageprocessing.model.IMessage;
import com.cli.messageprocessing.model.SaleRecord;

/**
 * For sales and adjustment report,class is responsible for generating reports
 * 
 * @author gauravs
 *
 */
public class ReportProcessor {
	StringBuilder adjustmentLog = new StringBuilder();

	/**
	 * Print sales report of console
	 * 
	 * @param ListProducts
	 */
	public void printSalesReport(Map<String, List<SaleRecord>> ListProducts) {
		for (Map.Entry<String, List<SaleRecord>> record : ListProducts.entrySet()) {
			System.out.println("Product type: " + record.getKey() + ", Total product units sold: "
					+ getTotalSales(record.getValue()) + ", Total revenue generated: "
					+ getTotalRevenue(record.getValue()));
		}
	}

	/**
	 * Update adjustment logs according to date and operation type
	 * 
	 * @param date
	 * @param message
	 */
	public void updateAdjustmentLog(Date date, IMessage message) {
		adjustmentLog.append(new Date() + ": " + "Product name: " + message.getProductName() + "; " + "Selling price: "
				+ message.getUnitPrice() + "; " + "Operation adjusted: " + message.getAdjustMentType() + ".\n");
	}

	public int getTotalSales(List<SaleRecord> salesRecords) {
		int totalNumSales = 0;
		for (SaleRecord record : salesRecords) {
			totalNumSales += record.getSaleQty();
		}
		return totalNumSales;
	}

	private BigDecimal getTotalRevenue(List<SaleRecord> salesRecords) {
		BigDecimal revenueGenerated = BigDecimal.ZERO;

		for (SaleRecord record : salesRecords) {

			revenueGenerated = revenueGenerated
					.add(record.getSellingPrice().multiply(BigDecimal.valueOf(record.getSaleQty())));
		}

		return revenueGenerated;
	}

	public StringBuilder getAdjustmentLog() {
		return this.adjustmentLog;
	}

}
