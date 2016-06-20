package com.plotter.core;

import java.util.NoSuchElementException;

/**
 * Double precision point range iterator class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class DoubleRangeIterator extends ARangeIterator<Double> {

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
	public DoubleRangeIterator(Double from, Double to, int steps) {
		super(from, to, steps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Double next() {
		Double ret;
		if (hasNext()) {
			ret = (((getTo().doubleValue() - getFrom().doubleValue()) * (double) getStep()) / (double) getSteps())
					+ getFrom().doubleValue();
			++step;
		} else
			throw new NoSuchElementException();
		return ret;
	}

}
