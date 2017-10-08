package com.bigeti.plotter.core;

/**
 * Algorithm computer interface
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <A>
 *            Result type
 * @param <B>
 *            Input type
 */
public interface IComputer<A, B>
{

	/**
	 * Compute algorithm
	 * 
	 * @param values
	 *            Values
	 * @param algorithm
	 *            Algorithm
	 * @return Result
	 */
	public Results<A, B> compute(Iterable<B> values, IAlgorithm<A, B> algorithm);
}
