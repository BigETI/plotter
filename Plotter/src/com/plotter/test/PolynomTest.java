package com.plotter.test;

import org.junit.Before;
import org.junit.Test;

import com.plotter.algorithms.Polynom;
import com.plotter.computer.MultiThreadedComputer;
import com.plotter.computer.SingleThreadedComputer;

/**
 * Polynom test class
 * 
 * @author ethem
 *
 */
public class PolynomTest {

	/**
	 * Polynom
	 */
	private Polynom poly;

	/**
	 * Set up
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Before
	public void setUp() throws Exception {
		double[] factors = new double[200];
		for (int i = 0; i < factors.length; i++)
			factors[i] = Math.random();
		poly = new Polynom(factors);
	}

	/**
	 * Test
	 */
	@Test
	public void test() {
		Double[] values = new Double[100000];
		for (int i = 0; i < values.length; i++)
			values[i] = ((double) i) - 50000.0;
		long a, b;

		// Single threaded
		a = System.currentTimeMillis();
		poly.plot(values, new SingleThreadedComputer<Double, Double>());
		b = System.currentTimeMillis();
		System.out.println("SingleThreadedComputer took " + (b - a) + "ms.");

		// Multi threaded (8 threads)
		a = System.currentTimeMillis();
		poly.plot(values, new MultiThreadedComputer<Double, Double>(8));
		b = System.currentTimeMillis();
		System.out.println("MultiThreadedComputer took " + (b - a) + "ms.");
	}

}
