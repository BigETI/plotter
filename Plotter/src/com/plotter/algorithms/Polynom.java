package com.plotter.algorithms;

import com.plotter.core.IAlgorithm;
import com.plotter.core.IComputer;
import com.plotter.core.IPlotter;

/**
 * Polynom class
 * 
 * @author Ethem Kurt
 *
 */
public class Polynom implements IAlgorithm<Double, Double> {

	/**
	 * Factors
	 */
	private Double[] factors;

	/**
	 * Constructor
	 * 
	 * @param factors
	 *            Factors
	 */
	public Polynom(double[] factors) {
		if (factors == null)
			throw new IllegalArgumentException("\"factors\" can't be \"null\".");
		else {
			if (factors.length <= 0)
				throw new IllegalArgumentException("\"factors\" can't be zero by its length.");
			else {
				this.factors = new Double[factors.length];
				for (int i = 0; i < factors.length; i++)
					this.factors[i] = factors[i];
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IAlgorithm#plot(java.lang.Object[],
	 * com.plotter.core.IComputer)
	 */
	@Override
	public Double[] plot(Double[] values, IComputer<Double, Double> computer) {
		return computer.compute(values, Double.class, new IPlotter<Double, Double>() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.plotter.core.IPlotter#plotElement(java.lang.Object)
			 */
			@Override
			public Double plotElement(Double value) {
				double ret = 0;
				for (int i = 0; i < factors.length; i++)
					ret += factors[i] * Math.pow(value, i);
				return ret;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("y =");
		for (int i = 0; i < factors.length; i++) {
			sb.append("");
			if (i > 0) {
				if (i == 1)
					sb.append("x");
				else {
					sb.append("x^");
					sb.append(i);
				}
			}
		}
		return sb.toString();
	}
}
