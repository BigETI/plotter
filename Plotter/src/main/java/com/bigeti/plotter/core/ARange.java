package com.bigeti.plotter.core;

/**
 * Iterable range class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 * 
 * @param <T>
 *            Return type
 */
public abstract class ARange<T extends Number> implements Iterable<T> {

	/**
	 * From
	 */
	private T from;

	/**
	 * To
	 */
	private T to;

	/**
	 * Steps
	 */
	private int steps;

	/**
	 * Constructor
	 * 
	 * @param from
	 *            From
	 * @param to
	 *            To
	 * @param steps
	 *            Steps
	 * @throws IllegalArgumentException
	 *             If "steps" is negative
	 */
	public ARange(T from, T to, int steps) throws IllegalArgumentException {
		if (steps < 0)
			throw new IllegalArgumentException("\"steps\" can't be negative.");
		this.from = from;
		this.to = to;
		this.steps = steps;
	}

	/**
	 * Get from
	 * 
	 * @return From
	 */
	public T getFrom() {
		return from;
	}

	/**
	 * Get to
	 * 
	 * @return To
	 */
	public T getTo() {
		return to;
	}

	/**
	 * Get steps
	 * 
	 * @return Steps
	 */
	public int getSteps() {
		return steps;
	}
}
