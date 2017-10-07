package com.bigeti.plotter.core;

import java.awt.Color;

/**
 * Graph interface
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
public interface IGraph<TA extends Number, TB extends Number> {

	/**
	 * Plot algorithm
	 * 
	 * @param values
	 *            Values
	 * @param algorithm
	 *            Algorithm
	 * @param line_color
	 *            Line color
	 * @return Results
	 */
	public Results<TA, TB> plot(Iterable<TB> values, IAlgorithm<TA, TB> algorithm, Color line_color);

	/**
	 * Clear graph
	 */
	public void clearGraph();
}
