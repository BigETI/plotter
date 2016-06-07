package com.plotter.core;

import java.awt.image.BufferedImage;

/**
 * Fractal algorithm interface
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public interface IImageAlgorithm<TA extends Number, TB extends Number> extends IAlgorithm<TA[], TB[]> {

	/**
	 * Plot image
	 * 
	 * @param x
	 *            X
	 * @param y
	 *            Y
	 * @param zoom
	 *            Zoom
	 * @param image_width
	 *            Image width
	 * @param image_height
	 *            Image height
	 * @param plot_computer
	 *            Plot computer
	 * @param image_computer
	 *            Image computer
	 * @return Plotted image
	 */
	public BufferedImage plotImage(TB x, TB y, TB zoom, int image_width, int image_height, IComputer<TA[], TB[]> plot_computer,
			IComputer<TA[][], TB[][]> image_computer);
}
