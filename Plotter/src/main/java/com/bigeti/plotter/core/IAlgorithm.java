package com.bigeti.plotter.core;

/**
 * Algorithm interface
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <A>
 *            Result value
 * @param <B>
 *            Input value
 */
public interface IAlgorithm<A, B>
{

	/**
	 * Compute algorithm
	 * 
	 * @param value
	 *            Value
	 * @return Result
	 */
	public A compute(B value);
}
