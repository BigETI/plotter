package com.plotter.core;

import java.awt.image.BufferedImage;

/**
 * Fractal algorithm interface
 * 
 * @author Ethem Kurt
 *
 * @param <T>
 *            Result and value type
 */
public interface IFractalAlgorithm<T extends Number> extends IAlgorithm<T, T> {

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
	public BufferedImage plotImage(T x, T y, T zoom, int image_width, int image_height, IComputer<T, T> plot_computer,
			IComputer<Integer[][], T[][]> image_computer);
}
