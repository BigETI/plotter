package com.bigeti.plotter.computer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.core.IComputer;
import com.bigeti.plotter.core.Result;
import com.bigeti.plotter.core.Results;

/**
 * Multi threaded computer class
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
public class MultiThreadedComputer<A, B> implements IComputer<A, B>
{

	/**
	 * Thread pool
	 */
	private ExecutorService pool;

	/**
	 * Default constructor
	 */
	public MultiThreadedComputer()
	{
		this(Runtime.getRuntime().availableProcessors());
	}

	/**
	 * Constructor
	 * 
	 * @param threads
	 *            Threads
	 */
	public MultiThreadedComputer(int threads)
	{
		pool = Executors.newFixedThreadPool(threads);
	}

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
		Results<Future<A>, B> futures = new Results<>();
		for (B i : values)
		{
			futures.add(new Result<>(pool.submit(new ACall<A, B>(i)
			{

				@Override
				public A call() throws Exception
				{
					return algorithm.compute(VALUE);
				}
			}), i));
		}
		for (Result<Future<A>, B> i : futures)
		{
			try
			{
				ret.add(new Result<>(i.RESULT.get(), i.VALUE));
			}
			catch (InterruptedException | ExecutionException e)
			{
				e.printStackTrace();
			}
		}
		return ret;
	}
}
