package com.plotter.computer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.plotter.core.IAlgorithm;
import com.plotter.core.IComputer;
import com.plotter.core.Result;
import com.plotter.core.Results;

/**
 * Multi threaded computer class
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
public class MultiThreadedComputer<TA, TB> implements IComputer<TA, TB> {

	/**
	 * Thread pool
	 */
	private ExecutorService pool;

	/**
	 * Default constructor
	 */
	public MultiThreadedComputer() {
		this(Runtime.getRuntime().availableProcessors());
	}

	/**
	 * Constructor
	 * 
	 * @param threads
	 *            Threads
	 */
	public MultiThreadedComputer(int threads) {
		pool = Executors.newFixedThreadPool(threads);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IComputer#compute(java.lang.Class,
	 * java.lang.Iterable, com.plotter.core.IAlgorithm)
	 */
	@Override
	public Results<TA, TB> compute(Iterable<TB> values, IAlgorithm<TA, TB> algorithm) {
		Results<TA, TB> ret = new Results<>();
		Results<Future<TA>, TB> futures = new Results<>();
		for (TB i : values) {
			futures.add(new Result<>(pool.submit(new ACall<TA, TB>(i) {

				@Override
				public TA call() throws Exception {
					return algorithm.compute(VALUE);
				}
			}), i));
		}
		for (Result<Future<TA>, TB> i : futures) {
			try {
				ret.add(new Result<>(i.RESULT.get(), i.VALUE));
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
