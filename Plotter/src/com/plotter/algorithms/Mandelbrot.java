package com.plotter.algorithms;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;

import com.plotter.core.IComputer;
import com.plotter.core.IImageAlgorithm;
import com.plotter.core.IPlotter;

public class Mandelbrot implements IImageAlgorithm<Long, BigDecimal> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IAlgorithm#plot(java.lang.Object[],
	 * com.plotter.core.IComputer)
	 */
	@Override
	public Long[][] plot(BigDecimal[][] variables, IComputer<Long[], BigDecimal[]> computer) {
		return computer.compute(variables, Long[].class, new IPlotter<Long[], BigDecimal[]>() {

			@Override
			public Long[] plotElement(BigDecimal[] value, int index) {
				Long[] ret = new Long[2];
				ret[0] = 0L;
				ret[1] = 0L;
				return ret;
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
			IComputer<Long[], BigDecimal[]> plot_computer, IComputer<Long[][], BigDecimal[][]> image_computer) {
		BufferedImage ret = null;
		if ((image_width > 0) && (image_height > 0)) {
			
		}
		return ret;
	}

}
