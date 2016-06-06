package com.plotter.algorithms;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;

import com.plotter.core.IComputer;
import com.plotter.core.IFractalAlgorithm;
import com.plotter.core.IPlotter;

public class Mandelbrot implements IFractalAlgorithm<BigDecimal> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IAlgorithm#plot(java.lang.Object[],
	 * com.plotter.core.IComputer)
	 */
	@Override
	public BigDecimal[] plot(BigDecimal[] variables, IComputer<BigDecimal, BigDecimal> computer) {
		return computer.compute(variables, BigDecimal.class, new IPlotter<BigDecimal, BigDecimal>() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.plotter.core.IPlotter#plotElement(java.lang.Object)
			 */
			@Override
			public BigDecimal plotElement(BigDecimal value) {
				return null;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IFractalAlgorithm#plotImage(java.lang.Number,
	 * java.lang.Number, java.lang.Number, int, int, com.plotter.core.IComputer,
	 * com.plotter.core.IComputer)
	 */
	@Override
	public BufferedImage plotImage(BigDecimal x, BigDecimal y, BigDecimal zoom, int image_width, int image_height,
			IComputer<BigDecimal, BigDecimal> plot_computer, IComputer<Integer[][], BigDecimal[][]> image_computer) {
		return null;
	}

}
