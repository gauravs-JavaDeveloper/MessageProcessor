package com.cli.messageprocessing.strategy;

import java.math.BigDecimal;

/**
 * This is Strategy implemented as functional interface so that we can change
 * behavior without affecting our context and encapsulates each algorithm
 * 
 * @author gauravs
 *
 */
@FunctionalInterface
public interface AdjustmentStrategy {

	/**
	 * Apply Adjustment strategy
	 * 
	 * @param oldSalePrice
	 * @param newSalePrice
	 * @return
	 */
	public BigDecimal apply(BigDecimal oldSalePrice, BigDecimal newSalePrice);

	public static AdjustmentStrategy addSalePrice() {
		return (oldSalePrice, newSalePrice) -> oldSalePrice.add(newSalePrice);
	}

	public static AdjustmentStrategy subStractSalePrice() {
		return (oldSalePrice, newSalePrice) -> oldSalePrice.subtract(newSalePrice);
	}

	public static AdjustmentStrategy multiplySalePrice() {
		return (oldSalePrice, newSalePrice) -> oldSalePrice.multiply(newSalePrice);
	}

}
