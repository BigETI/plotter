package com.bigeti.plotter.core;

/**
 * Algorithm computer interface
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Input type
 */
public interface IComputer<TA, TB> {

	/**
	 * Compute algorithm
	 * 
	 * @param values
	 *            Values
	 * @param algorithm
	 *            Algorithm
	 * @return Result
	 */
	public Results<TA, TB> compute(Iterable<TB> values, IAlgorithm<TA, TB> algorithm);
}
