package com.bigeti.plotter.computer;

import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.core.IComputer;
import com.bigeti.plotter.core.Result;
import com.bigeti.plotter.core.Results;

/**
 * Single threaded computer
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
public class SingleThreadedComputer<A, B> implements IComputer<A, B>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IComputer#compute(java.lang.Class, java.lang.Iterable,
	 * com.plotter.core.IAlgorithm)
	 */
	@Override
	public Results<A, B> compute(Iterable<B> values, IAlgorithm<A, B> algorithm)
	{
		Results<A, B> ret = new Results<>();
		for (B i : values)
		{
			ret.add(new Result<>(algorithm.compute(i), i));
		}
		return ret;
	}

}
