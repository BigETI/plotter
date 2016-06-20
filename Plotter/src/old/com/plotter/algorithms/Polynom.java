package old.com.plotter.algorithms;

import java.awt.image.BufferedImage;

import old.com.plotter.core.IAlgorithm;
import old.com.plotter.core.IComputer;
import old.com.plotter.core.INumericAlgorithm;
import old.com.plotter.core.IPlotter;

/**
 * Polynom class
 * 
 * @author Ethem Kurt
 *
 */
public class Polynom implements INumericAlgorithm<Double> {

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
			public Double plotElement(Double value, int index) {
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
	 * @see com.plotter.core.INumericAlgorithm#plotImage(java.lang.Number,
	 * java.lang.Number, java.lang.Number, java.lang.Number, int, int, int,
	 * com.plotter.core.IComputer, com.plotter.core.IComputer)
	 */
	@Override
	public BufferedImage plotImage(Double from, Double to, Double scope_x, Double scope_y, int steps, int image_width,
			int image_height, IComputer<Double, Double> plot_computer, IComputer<Integer[], Double[]> image_computer) {
		BufferedImage ret = null;
		int i;
		int[] xps;
		int[] yps;
		if ((steps > 0) && (scope_x.doubleValue() > 0.0) && (scope_y.doubleValue() > 0.0)) {
			Double[] values = new Double[steps];
			Double step = (to.doubleValue() - from.doubleValue()) / (double) steps;
			for (i = 0; i < steps; i++)
				values[i] = from + (step * (double) i);
			Double[] results = plot(values, plot_computer);
			IAlgorithm<Integer[], Double[]> image_algorithm = new IAlgorithm<Integer[], Double[]>() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see com.plotter.core.IAlgorithm#plot(java.lang.Object[],
				 * com.plotter.core.IComputer)
				 */
				@Override
				public Integer[][] plot(Double[][] variables, IComputer<Integer[], Double[]> computer) {
					return computer.compute(variables, Integer[].class, new IPlotter<Integer[], Double[]>() {

						/*
						 * (non-Javadoc)
						 * 
						 * @see com.plotter.core.IPlotter#plotElement(java.lang.
						 * Object)
						 */
						@Override
						public Integer[] plotElement(Double[] value, int index) {
							Integer[] ret = new Integer[2];
							ret[0] = new Integer(
									(int) ((((double) image_width * value[0].doubleValue()) / scope_x.doubleValue()))
											+ (image_width / 2));
							ret[1] = new Integer(image_height
									- (int) ((((double) image_height * value[1].doubleValue()) / scope_y.doubleValue()))
									- (image_height / 2));
							return ret;
						}
					});
				}
			};
			Double[][] variables = new Double[results.length][2];
			for (i = 0; i < results.length; i++) {
				variables[i][0] = values[i];
				variables[i][1] = results[i];
			}
			Integer[][] image_result = image_algorithm.plot(variables, image_computer);
			xps = new int[results.length];
			yps = new int[results.length];

			ret = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
			for (i = 0; i < results.length; i++) {
				xps[i] = image_result[i][0].intValue();
				yps[i] = image_result[i][1].intValue();
			}
			ret.getGraphics().drawPolyline(xps, yps, results.length);
			ret.getGraphics().drawLine(0, image_height / 2, image_width, image_height / 2);
			ret.getGraphics().drawLine(image_width / 2, 0, image_width / 2, image_height);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("y = ");
		for (int i = 0; i < factors.length; i++) {
			if (i > 0) {
				sb.append(" + ");
				sb.append(factors[i]);
				if (i == 1)
					sb.append("x");
				else {
					sb.append("x^");
					sb.append(i);
				}
			} else
				sb.append(factors[i]);
		}
		return sb.toString();
	}
}
