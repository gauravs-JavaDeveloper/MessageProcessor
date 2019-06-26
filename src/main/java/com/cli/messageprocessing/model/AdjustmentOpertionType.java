package com.cli.messageprocessing.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * JAVA enum for holding adjustment values
 * 
 * @author gauravs
 *
 */
public enum AdjustmentOpertionType {
	ADD("Add"), SUBTRACT("Subtract"), MULTIPLY("Multiply");
	private String value;

	private AdjustmentOpertionType(final String description) {
		this.value = description;
	}

	@JsonValue
	final String value() {
		return this.value;
	}
}
