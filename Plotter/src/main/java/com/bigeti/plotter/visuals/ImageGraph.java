package com.bigeti.plotter.visuals;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import com.bigeti.plotter.computer.MultiThreadedComputer;
import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.core.IComputer;
import com.bigeti.plotter.core.IGraph;
import com.bigeti.plotter.core.Point;
import com.bigeti.plotter.core.Result;
import com.bigeti.plotter.core.Results;

/**
 * Image graph class
 *
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public class ImageGraph<TA extends Number, TB extends Number> extends BufferedImage implements IGraph<TA, TB>
{

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
	public ImageGraph(final int width, final int height, final TA x_view, final TA y_view, final TA x_offset, final TA y_offset)
	{
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
	public ImageGraph(final int width, final int height, final TA x_view, final TA y_view, final TA x_offset, final TA y_offset, final Color background_color)
	{
		super(width, height, BufferedImage.TYPE_INT_RGB);
		view = new Point<>(x_view, y_view);
		offset = new Point<>(x_offset, y_offset);
		this.background_color = background_color;
		clearGraph();
		final int x = (int) (getWidth() * offset.X.doubleValue() / view.X.doubleValue() + getWidth() * 0.5);
		final int y = -(int) (getHeight() * offset.Y.doubleValue() / view.Y.doubleValue() - getHeight() * 0.5);
		getGraphics().setColor(Color.WHITE);
		getGraphics().drawLine(0, y, getWidth(), y);
		getGraphics().drawLine(x, 0, x, getHeight());
	}

	/**
	 * Get view
	 *
	 * @return View
	 */
	public Point<TA> getView()
	{
		return view;
	}

	/**
	 * Get offset
	 *
	 * @return Offset
	 */
	public Point<TA> getOffset()
	{
		return offset;
	}

	/**
	 * Get background color
	 *
	 * @return Background color
	 */
	public Color getBackgroundColor()
	{
		return background_color;
	}

	/**
	 * Draw results
	 *
	 * @param results
	 *            Results
	 * @param line_color
	 *            Line color
	 */
	public void drawResults(final Results<TA, TB> results, final Color line_color)
	{
		getGraphics().setColor(line_color);
		final Polygon p = new Polygon();
		for (final Result<TA, TB> i : results)
		{
			p.addPoint((int) (getWidth() * (i.VALUE.doubleValue() + offset.X.doubleValue())
					/ view.X.doubleValue()
					+ getWidth() * 0.5), -(int) (getHeight() * (i.RESULT.doubleValue() + offset.Y.doubleValue())
							/ view.Y.doubleValue() - getHeight() * 0.5));
		}
		getGraphics().drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}

	/*
	 * (non-Javadoc)
	 * @see com.plotter.core.IGraph#plot(java.lang.Iterable, com.plotter.core.IAlgorithm,
	 * java.awt.Color)
	 */
	@Override
	public Results<TA, TB> plot(final Iterable<TB> values, final IAlgorithm<TA, TB> algorithm, final Color line_color)
	{
		final IComputer<TA, TB> computer = new MultiThreadedComputer<>();
		final Results<TA, TB> ret = computer.compute(values, algorithm);
		drawResults(ret, line_color);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * @see com.plotter.core.IGraph#clearGraph()
	 */
	@Override
	public void clearGraph()
	{
		flush();
		if (background_color != null)
		{
			getGraphics().setColor(background_color);
			getGraphics().fillRect(0, 0, getWidth(), getHeight());
		}
	}

}
