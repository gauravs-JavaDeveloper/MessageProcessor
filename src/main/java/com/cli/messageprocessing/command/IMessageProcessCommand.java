package com.cli.messageprocessing.command;

import java.util.List;
import java.util.Map;

import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.model.SaleRecord;

/**
 * Command interface with execute method,It is core of contract
 * 
 * @author gauravs
 *
 */
public interface IMessageProcessCommand {

	/**
	 * Process Notification messages for single,multi value and adjustment sales
	 * and create and update record of sale according to Product name.
	 * 
	 * @param message
	 * @param listProducts
	 * @param messageCount
	 */
	public void execute(MessageImpl message, Map<String, List<SaleRecord>> listProducts, int messageCount);

}
