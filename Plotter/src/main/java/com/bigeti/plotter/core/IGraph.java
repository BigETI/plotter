package com.bigeti.plotter.core;

import java.awt.Color;

/**
 * Graph interface
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
public interface IGraph<A extends Number, B extends Number>
{

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
	public Results<A, B> plot(Iterable<B> values, IAlgorithm<A, B> algorithm, Color line_color);

	/**
	 * Clear graph
	 */
	public void clearGraph();
}
