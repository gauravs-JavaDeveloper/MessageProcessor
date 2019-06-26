package com.cli.messageprocessing.salesmessageprocessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cli.messageprocessing.model.AdjustmentOpertionType;
import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.model.MessageType;
import com.cli.messageprocessing.model.SaleRecord;
import com.cli.messageprocessing.salesmessageprocessor.MessageProcessor;

public class MessageProcessorTest {

	private MessageProcessor messageProcessor;

	@Before
	public void init() {
		messageProcessor = new MessageProcessor();
	}

	@Test
	public void processMessage() {
		MessageImpl message1 = new MessageImpl();
		message1.setMessageType(MessageType.SINGLE_SALE);
		message1.setUnitPrice(BigDecimal.TEN);
		message1.setProductType("Apple");
		List<MessageImpl> messages = new ArrayList<>();
		messages.add(message1);
		messageProcessor.setMessages(messages);

		messageProcessor.processMessage();
		Map<String, List<SaleRecord>> listOfProduct = messageProcessor.getListProducts();
		assertTrue(listOfProduct.size() > 0);
		for (Map.Entry<String, List<SaleRecord>> records : listOfProduct.entrySet()) {
			assertEquals(records.getKey(), "Apple");
			for (SaleRecord record : records.getValue()) {
				assertEquals(record.getSellingPrice(), BigDecimal.TEN);
				assertEquals(record.getSaleQty(), 1);
			}
		}
	}

	@Test
	public void processMessageMutiPleVal() {
		MessageImpl message1 = new MessageImpl();
		message1.setMessageType(MessageType.MULTI_SALE);
		message1.setUnitPrice(BigDecimal.valueOf(2));
		message1.setQunatity(10);
		message1.setProductType("Mango");
		List<MessageImpl> messages = new ArrayList<>();
		messages.add(message1);
		messageProcessor.setMessages(messages);

		messageProcessor.processMessage();
		Map<String, List<SaleRecord>> listOfProduct = messageProcessor.getListProducts();
		assertTrue(listOfProduct.size() > 0);
		for (Map.Entry<String, List<SaleRecord>> records : listOfProduct.entrySet()) {
			assertEquals(records.getKey(), "Mango");
			for (SaleRecord record : records.getValue()) {
				assertEquals(record.getSellingPrice(), BigDecimal.valueOf(2));
				assertEquals(record.getSaleQty(), 10);
			}
		}
	}

	@Test
	public void processMessageAdjustMentVal() {
		MessageImpl message1 = new MessageImpl();
		message1.setMessageType(MessageType.MULTI_SALE);
		message1.setUnitPrice(BigDecimal.valueOf(2));
		message1.setQunatity(10);
		message1.setProductType("Mango");
		MessageImpl message2 = new MessageImpl();
		message2.setMessageType(MessageType.ADJUSTMENT);
		message2.setUnitPrice(BigDecimal.valueOf(5));
		message2.setQunatity(10);
		message2.setProductType("Mango");
		message2.setAdjustMentType(AdjustmentOpertionType.ADD);
		List<MessageImpl> messages = new ArrayList<>();
		messages.add(message1);
		messages.add(message2);
		messageProcessor.setMessages(messages);

		messageProcessor.processMessage();
		Map<String, List<SaleRecord>> listOfProduct = messageProcessor.getListProducts();
		assertTrue(listOfProduct.size() > 0);
		for (Map.Entry<String, List<SaleRecord>> records : listOfProduct.entrySet()) {
			assertEquals(records.getKey(), "Mango");
			for (SaleRecord record : records.getValue()) {
				assertEquals(record.getSellingPrice(), BigDecimal.valueOf(7));
				assertEquals(record.getSaleQty(), 10);
			}
		}
	}

	@Test
	public void processMessageSubtractionAdjustMentVal() {
		MessageImpl message1 = new MessageImpl();
		message1.setMessageType(MessageType.MULTI_SALE);
		message1.setUnitPrice(BigDecimal.valueOf(5));
		message1.setQunatity(10);
		message1.setProductType("Mango");
		MessageImpl message2 = new MessageImpl();
		message2.setMessageType(MessageType.ADJUSTMENT);
		message2.setUnitPrice(BigDecimal.valueOf(2));
		message2.setQunatity(10);
		message2.setProductType("Mango");
		message2.setAdjustMentType(AdjustmentOpertionType.SUBTRACT);
		List<MessageImpl> messages = new ArrayList<>();
		messages.add(message1);
		messages.add(message2);
		messageProcessor.setMessages(messages);

		messageProcessor.processMessage();
		Map<String, List<SaleRecord>> listOfProduct = messageProcessor.getListProducts();
		assertTrue(listOfProduct.size() > 0);
		for (Map.Entry<String, List<SaleRecord>> records : listOfProduct.entrySet()) {
			assertEquals(records.getKey(), "Mango");
			for (SaleRecord record : records.getValue()) {
				assertEquals(record.getSellingPrice(), BigDecimal.valueOf(3));
				assertEquals(record.getSaleQty(), 10);
			}
		}
	}

	@Test
	public void processMessageMultiplyAdjustMentVal() {
		MessageImpl message1 = new MessageImpl();
		message1.setMessageType(MessageType.MULTI_SALE);
		message1.setUnitPrice(BigDecimal.valueOf(5));
		message1.setQunatity(10);
		message1.setProductType("Mango");
		MessageImpl message2 = new MessageImpl();
		message2.setMessageType(MessageType.ADJUSTMENT);
		message2.setUnitPrice(BigDecimal.valueOf(2));
		message2.setQunatity(10);
		message2.setProductType("Mango");
		message2.setAdjustMentType(AdjustmentOpertionType.MULTIPLY);
		List<MessageImpl> messages = new ArrayList<>();
		messages.add(message1);
		messages.add(message2);
		messageProcessor.setMessages(messages);

		messageProcessor.processMessage();
		Map<String, List<SaleRecord>> listOfProduct = messageProcessor.getListProducts();
		assertTrue(listOfProduct.size() > 0);
		for (Map.Entry<String, List<SaleRecord>> records : listOfProduct.entrySet()) {
			assertEquals(records.getKey(), "Mango");
			for (SaleRecord record : records.getValue()) {
				assertEquals(record.getSellingPrice(), BigDecimal.valueOf(10));
				assertEquals(record.getSaleQty(), 10);
			}
		}
	}

}
