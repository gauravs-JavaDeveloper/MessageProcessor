package com.cli.messageprocessing.command;

import java.util.List;
import java.util.Map;

import com.cli.messageprocessing.model.AdjustmentOpertionType;
import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.model.SaleRecord;
import com.cli.messageprocessing.strategy.AdjustmentStrategy;

/**
 * Implements {@link IMessageProcessCommand} ,its implementation of command
 * design pattern to process messages according to their type adjustment sales
 * 
 * @author gauravs
 *
 */
public class ProcessAdjustMentMessageCommand implements IMessageProcessCommand {

	public void execute(MessageImpl message, Map<String, List<SaleRecord>> listProducts, int messageCount) {
		AdjustmentOpertionType operationType = message.getAdjustMentType();
		String productName = message.getProductName();
		List<SaleRecord> productRecords = listProducts.get(productName);
		// Apply adjustment strategy according to operation type
		switch (operationType) {
		case ADD:
			for (SaleRecord record : productRecords) {
				AdjustmentStrategy strategy = AdjustmentStrategy.addSalePrice();
				record.setSellingPrice(strategy.apply(record.getSellingPrice(), message.getUnitPrice()));
			}
			break;
		case MULTIPLY:
			for (SaleRecord record : productRecords) {
				AdjustmentStrategy strategy = AdjustmentStrategy.multiplySalePrice();
				record.setSellingPrice(strategy.apply(record.getSellingPrice(), message.getUnitPrice()));
			}
			break;
		case SUBTRACT:
			for (SaleRecord record : productRecords) {
				AdjustmentStrategy strategy = AdjustmentStrategy.subStractSalePrice();
				record.setSellingPrice(strategy.apply(record.getSellingPrice(), message.getUnitPrice()));
			}
			break;
		default:
			System.out.println("Operation is not defined!");
			break;
		}
	}

}
