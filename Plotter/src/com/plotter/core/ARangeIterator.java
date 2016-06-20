package com.plotter.core;

import java.util.Iterator;

/**
 * Range iterator class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class ARangeIterator<T> implements Iterator<T> {

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
	 * Step
	 */
	protected int step = 0;

	/**
	 * Constructor
	 * 
	 * @param from
	 *            From
	 * @param to
	 *            To
	 * @param steps
	 *            Steps
	 */
	public ARangeIterator(T from, T to, int steps) {
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

	/**
	 * Get step
	 * 
	 * @return Step
	 */
	public int getStep() {
		return step;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return (step < steps);
	}

}
