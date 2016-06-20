package com.plotter.core;

/**
 * Point class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T>
 *            Return type
 */
public class Point<T extends Number> {

	/**
	 * X
	 */
	public final T X;

	/**
	 * Y
	 */
	public final T Y;

	/**
	 * Constructor
	 * 
	 * @param x
	 *            X
	 * @param y
	 *            Y
	 */
	public Point(T x, T y) {
		X = x;
		Y = y;
	}

}
