package com.bigeti.plotter.core;

import java.util.Iterator;

/**
 * Double precision point range class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class DoubleRange extends ARange<Double>
{

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
	public DoubleRange(Double from, Double to, int steps) throws IllegalArgumentException
	{
		super(from, to, steps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Double> iterator()
	{
		return new DoubleRangeIterator(getFrom(), getTo(), getSteps());
	}

}
