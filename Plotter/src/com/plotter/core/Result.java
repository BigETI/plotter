package com.plotter.core;

/**
 * Pair class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public class Result<TA, TB> {

	/**
	 * Result
	 */
	public final TA RESULT;

	/**
	 * Value
	 */
	public final TB VALUE;

	/**
	 * Constructor
	 * 
	 * @param result
	 *            Result
	 * @param value
	 *            Value
	 */
	public Result(TA result, TB value) {
		RESULT = result;
		VALUE = value;
	}
}
