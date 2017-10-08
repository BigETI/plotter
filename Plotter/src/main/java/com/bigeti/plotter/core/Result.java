package com.bigeti.plotter.core;

/**
 * Result pair class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <A>
 *            Result type
 * @param <B>
 *            Value type
 */
public class Result<A, B>
{

	/**
	 * Result
	 */
	public final A RESULT;

	/**
	 * Value
	 */
	public final B VALUE;

	/**
	 * Constructor
	 * 
	 * @param result
	 *            Result
	 * @param value
	 *            Value
	 */
	public Result(A result, B value)
	{
		RESULT = result;
		VALUE = value;
	}
}
