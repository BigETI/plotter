package com.plotter.core;

/**
 * Plottable interface
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Values type
 */
public interface IPlotter<TA, TB> {

	/**
	 * Plots in an n space for a single element
	 * 
	 * @param value
	 *            Values of the n space
	 * @return Result
	 */
	public TA plotElement(TB value);
}
