package com.plotter.core;

/**
 * Algorithm interface
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public interface IAlgorithm<TA, TB> {

	/**
	 * Plot algorithm
	 * 
	 * @param variables
	 *            Variables
	 * @param computer
	 *            Computer
	 * @return Result set
	 */
	public TA[] plot(TB[] variables, IComputer<TA, TB> computer);
}
