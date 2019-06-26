package com.cli.messageprocessing.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.model.SaleRecord;

/**
 * Implements {@link IMessageProcessCommand} ,its implementation of command
 * design pattern to process messages according to their type single or multi
 * value sale
 * 
 * @author gauravs
 *
 */
public class ProcessMessageCommand implements IMessageProcessCommand {

	@Override
	public void execute(MessageImpl message, Map<String, List<SaleRecord>> listProducts, int messageCount) {
		String productName = message.getProductName();
		int qty = 1;// single sale quantity is one
		if (message.getQuantity() > 1) {
			qty = message.getQuantity();
		}
		SaleRecord saleRecord = new SaleRecord();
		saleRecord.setProductName(productName);
		saleRecord.setSellingPrice(message.getUnitPrice());
		saleRecord.setSaleQty(qty);

		List<SaleRecord> saleRecords = listProducts.get(productName);
		if (saleRecords == null) {
			saleRecords = new ArrayList<SaleRecord>();
		}
		saleRecords.add(saleRecord);
		listProducts.put(productName, saleRecords);
	}

}
