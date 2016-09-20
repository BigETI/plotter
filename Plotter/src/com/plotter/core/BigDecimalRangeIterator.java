package com.plotter.core;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BigDecimalRangeIterator extends ARangeIterator<BigDecimal> {

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
	public BigDecimalRangeIterator(BigDecimal from, BigDecimal to, int steps) {
		super(from, to, steps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public BigDecimal next() {
		BigDecimal ret;
		if (hasNext()) {
			ret = getTo().subtract(getFrom()).multiply(new BigDecimal(getStep()).divide(new BigDecimal(getSteps()))).add(getFrom());
			++step;
		} else
			throw new NoSuchElementException();
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		//
	}

}
