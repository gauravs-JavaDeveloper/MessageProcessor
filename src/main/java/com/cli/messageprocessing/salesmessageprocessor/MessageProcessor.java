package com.cli.messageprocessing.salesmessageprocessor;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cli.messageprocessing.command.IMessageProcessCommand;
import com.cli.messageprocessing.command.ProcessAdjustMentMessageCommand;
import com.cli.messageprocessing.command.ProcessMessageCommand;
import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.model.MessageType;
import com.cli.messageprocessing.model.SaleRecord;
import com.cli.messageprocessing.parser.MessageParser;
import com.cli.messageprocessing.parser.NotificationMessageParser;
import com.cli.messageprocessing.util.ApplicationContants;

/**
 * This class extends {@link FlowManager} and responsible for parsing and
 * processing of Message Notification
 * 
 * @author gauravs
 * 
 *
 */
public class MessageProcessor extends FlowManager {
	private MessageParser parser;
	private List<MessageImpl> messages;
	private ReportProcessor reportProcessor = new ReportProcessor();
	Map<String, List<SaleRecord>> listProducts;

	/**
	 * Initiate the Notification message processing
	 */
	public void startProcessing() {
		FlowManager manger = new MessageProcessor();
		manger.startNotificationProcessing();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cli.messageprocessing.SalesMessageProcessor.FlowManger#praseMessage()
	 */
	@Override
	void praseMessage() {
		parser = new NotificationMessageParser();
		File file = new File(
				getClass().getClassLoader().getResource(ApplicationContants.NOTIFICATION_FILE_NAME).getFile());

		String filePath = file.getAbsolutePath();
		messages = parser.parseNotificationMessage(filePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cli.messageprocessing.SalesMessageProcessor.FlowManger#processMessage
	 * ()
	 */
	@Override
	public boolean processMessage() {
		listProducts = new HashMap<String, List<SaleRecord>>();
		int messageCounter = 0;

		for (MessageImpl message : messages) {
			if (message.getMessageType() != MessageType.ADJUSTMENT) {
				IMessageProcessCommand processMsgCmd = new ProcessMessageCommand();
				processMsgCmd.execute(message, listProducts, messageCounter++);
			} else {
				IMessageProcessCommand processMsgCmd = new ProcessAdjustMentMessageCommand();
				processMsgCmd.execute(message, listProducts, messageCounter++);
				reportProcessor.updateAdjustmentLog(new Date(), message);
			}
			// After every 10 sales notification message,print sale report
			if (messageCounter % ApplicationContants.MESSAGE_REPORT_LOG_AFTER == 0) {
				System.out.println("\n*** Intermediate Processed Sales' Record ***");
				reportProcessor.printSalesReport(listProducts);
			}
			// Notification message processing limit is 50 and after that
			// application will stop processing messages and print adjustment
			// report
			if (messageCounter == ApplicationContants.MESSAGE_PROCESSING_MAX) {

				System.out.println("\nApplication reached its limited number of messages to be processed - "
						+ ApplicationContants.MESSAGE_PROCESSING_MAX + "! Message processing has stopped.");
				System.out.println("\n*** Adjustments Log: ***");
				System.out.println(reportProcessor.getAdjustmentLog().toString());
				break;
			}
		}

		return true;
	}

	public List<MessageImpl> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageImpl> messages) {
		this.messages = messages;
	}

	public ReportProcessor getReportProcessor() {
		return reportProcessor;
	}

	public void setReportProcessor(ReportProcessor reportProcessor) {
		this.reportProcessor = reportProcessor;
	}

	public MessageParser getParser() {
		return parser;
	}

	public void setParser(MessageParser parser) {
		this.parser = parser;
	}

	public Map<String, List<SaleRecord>> getListProducts() {
		return listProducts;
	}

	public void setListProducts(Map<String, List<SaleRecord>> listProducts) {
		this.listProducts = listProducts;
	}

}
