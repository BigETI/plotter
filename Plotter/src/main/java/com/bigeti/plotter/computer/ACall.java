package com.bigeti.plotter.computer;

import java.util.concurrent.Callable;

/**
 * Extended callable abstract class
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
public abstract class ACall<A, B> implements Callable<A>
{

	/**
	 * Value
	 */
	public final B VALUE;

	/**
	 * Constructor
	 * 
	 * @param value
	 *            Value
	 */
	public ACall(B value)
	{
		VALUE = value;
	}

}
