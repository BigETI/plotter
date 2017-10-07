package com.bigeti.plotter.computer;

import java.util.concurrent.Callable;

/**
 * Extended callable abstract class
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
public abstract class ACall<TA, TB> implements Callable<TA> {

	/**
	 * Value
	 */
	public final TB VALUE;

	/**
	 * Constructor
	 * 
	 * @param value
	 *            Value
	 */
	public ACall(TB value) {
		VALUE = value;
	}

}
