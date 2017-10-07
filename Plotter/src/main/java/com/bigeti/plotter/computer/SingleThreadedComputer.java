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
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Input type
 */
public class SingleThreadedComputer<TA, TB> implements IComputer<TA, TB> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IComputer#compute(java.lang.Class,
	 * java.lang.Iterable, com.plotter.core.IAlgorithm)
	 */
	@Override
	public Results<TA, TB> compute(Iterable<TB> values, IAlgorithm<TA, TB> algorithm) {
		Results<TA, TB> ret = new Results<>();
		for (TB i : values)
			ret.add(new Result<>(algorithm.compute(i), i));
		return ret;
	}

}
