package com.cli.messageprocessing.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * JAVA Enum for holding message types
 * 
 * @author gauravs
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageType {
	SINGLE_SALE("SingleSale"), MULTI_SALE("MultiSale"), ADJUSTMENT("Adjustment");
	private final String value;

	private MessageType(final String description) {
		this.value = description;
	}

	@JsonValue
	final String value() {
		return this.value;
	}
}
