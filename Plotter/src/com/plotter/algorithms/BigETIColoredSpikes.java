package com.plotter.algorithms;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.plotter.computer.MultiThreadedComputer;
import com.plotter.core.IComputer;
import com.plotter.core.IImageAlgorithm;
import com.plotter.core.IPlotter;

public class BigETIColoredSpikes implements IImageAlgorithm<Integer, BigDecimal> {

	@Override
	public Integer[][] plot(BigDecimal[][] variables, IComputer<Integer[], BigDecimal[]> computer) {
		return computer.compute(variables, Integer[].class, new IPlotter<Integer[], BigDecimal[]>() {

			@Override
			public Integer[] plotElement(BigDecimal[] value, int index) {
				Integer[] ret = new Integer[value.length];
				int t = 0xFF000000;
				BigDecimal tff = new BigDecimal(0xFF);
				for (int i = 0; i < ret.length; i++) {
					if (value[i].compareTo(BigDecimal.ZERO) > 0)
						t |= value[i].multiply(tff).intValue() & 0xFF;
					else
						t |= (value[i].negate().multiply(tff).intValue() & 0xFF) << 16;
					t |= (BigDecimal.ONE.subtract(value[i].abs()).multiply(tff).intValue() & 0xFF) << 8;
					ret[i] = t;
				}
				return ret;
			}
		});
	}

	@Override
	public BufferedImage plotImage(BigDecimal x, BigDecimal y, BigDecimal zoom, int image_width, int image_height,
			IComputer<Integer[], BigDecimal[]> plot_computer, IComputer<Integer[][], BigDecimal[][]> image_computer) {
		BufferedImage ret = null;
		int i;
		int j;
		if ((zoom.compareTo(BigDecimal.ZERO) > 0) && (image_width > 0) && (image_height > 0)) {
			BigDecimal width = new BigDecimal(image_width);
			BigDecimal height = new BigDecimal(image_height);
			ret = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
			BigDecimal[][] variables = new BigDecimal[image_width][image_height];
			for (i = 0; i < variables.length; i++) {
				for (j = 0; j < variables[i].length; j++)
					variables[i][j] = (new BigDecimal(i)).divide(width, 128, RoundingMode.CEILING).add((new BigDecimal(j)).divide(height, 128, RoundingMode.CEILING))
							.subtract(BigDecimal.ONE);
			}
			Integer[][] results = plot(variables, new MultiThreadedComputer<Integer[], BigDecimal[]>(8));
			for (i = 0; i < variables.length; i++)
				for (j = 0; j < variables[i].length; j++)
					ret.setRGB(i, j, results[i][j]);
		}
		return ret;
	}

}
