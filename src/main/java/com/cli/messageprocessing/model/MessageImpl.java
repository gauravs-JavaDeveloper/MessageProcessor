package com.cli.messageprocessing.model;

import java.math.BigDecimal;

/**
 * Implements {@link IMessage} to have generic implementation
 * 
 * @author gauravs
 *
 */
public class MessageImpl implements IMessage {

	private MessageType messageType;
	private String productType;
	private AdjustmentOpertionType adjustMentType;
	private int quantity;
	private BigDecimal unitPrice;

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getProductName() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public AdjustmentOpertionType getAdjustMentType() {
		return adjustMentType;
	}

	public void setAdjustMentType(AdjustmentOpertionType adjustMentType) {
		this.adjustMentType = adjustMentType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQunatity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}
