package com.plotter.visuals;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import com.plotter.computer.MultiThreadedComputer;
import com.plotter.core.IAlgorithm;
import com.plotter.core.IComputer;
import com.plotter.core.IGraph;
import com.plotter.core.Point;
import com.plotter.core.Result;
import com.plotter.core.Results;

/**
 * Image graph class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public class ImageGraph<TA extends Number, TB extends Number> extends BufferedImage implements IGraph<TA, TB> {

	/**
	 * View
	 */
	private Point<TA> view;

	/**
	 * Offset
	 */
	private Point<TA> offset;

	/**
	 * Background color
	 */
	private Color background_color;

	/**
	 * Constructor
	 * 
	 * @param width
	 *            Width
	 * @param height
	 *            Height
	 * @param x_view
	 *            X Scale
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X Offset
	 * @param y_offset
	 *            Y Offset
	 */
	public ImageGraph(int width, int height, TA x_view, TA y_view, TA x_offset, TA y_offset) {
		this(width, height, x_view, y_view, x_offset, y_offset, null);
	}

	/**
	 * Constructor
	 * 
	 * @param width
	 *            Width
	 * @param height
	 *            Height
	 * @param x_view
	 *            X Scale
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X Offset
	 * @param y_offset
	 *            Y Offset
	 * @param background_color
	 *            Background color
	 */
	public ImageGraph(int width, int height, TA x_view, TA y_view, TA x_offset, TA y_offset, Color background_color) {
		super(width, height, BufferedImage.TYPE_INT_ARGB);
		view = new Point<>(x_view, y_view);
		offset = new Point<>(x_offset, y_offset);
		if (background_color != null) {
			getGraphics().setColor(background_color);
			getGraphics().fillRect(0, 0, width, height);
		}
		getGraphics().setColor(Color.WHITE);
		int x = (int) (((((double) getWidth() * offset.X.doubleValue()) / view.X.doubleValue())) + (getWidth() * 0.5));
		int y = (-(int) (((((double) getHeight() * offset.Y.doubleValue()) / view.Y.doubleValue()))
				- (getHeight() * 0.5)));
		getGraphics().drawLine(0, y, getWidth(), y);
		getGraphics().drawLine(x, 0, x, getHeight());
	}

	/**
	 * Get view
	 * 
	 * @return View
	 */
	public Point<TA> getView() {
		return view;
	}

	/**
	 * Get offset
	 * 
	 * @return Offset
	 */
	public Point<TA> getOffset() {
		return offset;
	}

	/**
	 * Get background color
	 * 
	 * @return Background color
	 */
	public Color getBackgroundColor() {
		return background_color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#plot(java.lang.Iterable,
	 * com.plotter.core.IAlgorithm, java.awt.Color)
	 */
	@Override
	public void plot(Iterable<TB> values, IAlgorithm<TA, TB> algorithm, Color line_color) {
		IComputer<TA, TB> computer = new MultiThreadedComputer<>();
		Results<TA, TB> result = computer.compute(values, algorithm);
		getGraphics().setColor(line_color);
		Polygon p = new Polygon();
		for (Result<TA, TB> i : result) {
			p.addPoint(
					(int) (((((double) getWidth() * (i.VALUE.doubleValue() + offset.X.doubleValue()))
							/ view.X.doubleValue())) + (getWidth() * 0.5)),
					(-(int) (((((double) getHeight() * (i.RESULT.doubleValue() + offset.Y.doubleValue()))
							/ view.Y.doubleValue())) - (getHeight() * 0.5))));
		}
		getGraphics().drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#clearGraph()
	 */
	@Override
	public void clearGraph() {
		getGraphics().clearRect(0, 0, getWidth(), getHeight());
	}

}
