package old.com.plotter.core;

import java.awt.image.BufferedImage;

/**
 * Numeric algorithm interface
 * 
 * @author Ethem Kurt
 *
 * @param <T>
 *            Result and value type
 */
public interface INumericAlgorithm<T extends Number> extends IAlgorithm<T, T> {

	/**
	 * Plot image
	 * 
	 * @param from
	 *            From value
	 * @param to
	 *            To value
	 * @param scope_x
	 *            Scope X
	 * @param scope_y
	 *            Scope Y
	 * @param steps
	 *            Steps
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
	public BufferedImage plotImage(T from, T to, T scope_x, T scope_y, int steps, int image_width, int image_height,
			IComputer<T, T> plot_computer, IComputer<Integer[], T[]> image_computer);
}
