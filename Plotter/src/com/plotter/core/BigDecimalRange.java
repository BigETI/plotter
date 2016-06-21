package com.plotter.core;

import java.math.BigDecimal;
import java.util.Iterator;

public class BigDecimalRange extends ARange<BigDecimal> {

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
	public BigDecimalRange(BigDecimal from, BigDecimal to, int steps) throws IllegalArgumentException {
		super(from, to, steps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<BigDecimal> iterator() {
		return new BigDecimalRangeIterator(getFrom(), getTo(), getSteps());
	}
}
