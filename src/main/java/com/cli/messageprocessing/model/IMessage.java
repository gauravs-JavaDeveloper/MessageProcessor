package com.cli.messageprocessing.model;

import java.math.BigDecimal;

/**
 * Generic representation of Message
 * 
 * @author gauravs
 *
 */
public interface IMessage {

	public MessageType getMessageType();

	public String getProductName();

	public AdjustmentOpertionType getAdjustMentType();

	public int getQuantity();

	public BigDecimal getUnitPrice();

}
