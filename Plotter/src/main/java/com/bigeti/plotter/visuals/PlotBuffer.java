package com.bigeti.plotter.visuals;

import java.awt.Color;

import com.bigeti.plotter.core.IAlgorithm;

/**
 * 
 * @author BigETI
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <A>
 *            Result value
 * @param <B>
 *            Input value
 */
public class PlotBuffer<A, B>
{
	/**
	 * Values
	 */
	public final Iterable<B> VALUES;

	/**
	 * Algorithm
	 */
	public final IAlgorithm<A, B> ALGORITHM;

	/**
	 * Line color
	 */
	public final Color LINE_COLOR;

	/**
	 * Constructor
	 * 
	 * @param values
	 *            Values
	 * @param algorithm
	 *            Algorithm
	 * @param line_color
	 *            Line color
	 */
	public PlotBuffer(Iterable<B> values, IAlgorithm<A, B> algorithm, Color line_color)
	{
		VALUES = values;
		ALGORITHM = algorithm;
		LINE_COLOR = line_color;
	}
}
