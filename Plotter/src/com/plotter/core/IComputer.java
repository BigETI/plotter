package com.plotter.core;

/**
 * Computer interface
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public interface IComputer<TA, TB> {

	/**
	 * Compute
	 * 
	 * @param values
	 *            Values
	 * @param clazz
	 *            Class type of TA
	 * @param plotter
	 *            Plotter
	 * @return Result set
	 */
	public TA[] compute(TB[] values, Class<TA> clazz, IPlotter<TA, TB> plotter);
}
