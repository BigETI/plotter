package com.bigeti.plotter.core;

/**
 * Algorithm interface
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <TA>
 *            Result value
 * @param <TB>
 *            Input value
 */
public interface IAlgorithm<TA, TB> {

	/**
	 * Compute algorithm
	 * 
	 * @param value
	 *            Value
	 * @return Result
	 */
	public TA compute(TB value);
}
