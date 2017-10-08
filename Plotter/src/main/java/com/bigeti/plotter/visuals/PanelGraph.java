package com.bigeti.plotter.visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.bigeti.plotter.computer.MultiThreadedComputer;
import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.core.IGraph;
import com.bigeti.plotter.core.Point;
import com.bigeti.plotter.core.Result;
import com.bigeti.plotter.core.Results;

/**
 * Panel graph class
 *
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 * 
 * @param <A>
 *            Result type
 * @param <B>
 *            Input type
 */
public class PanelGraph<A extends Number, B extends Number> extends JPanel implements IGraph<A, B>
{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -6635175220166429868L;

	/**
	 * Image graph
	 */
	private ImageGraph<A, B> image_graph = null;

	/**
	 * View
	 */
	private Point<A> view;

	/**
	 * Offset
	 */
	private Point<A> offset;

	/**
	 * Background color
	 */
	private Color background_color;

	/**
	 * Cached plots
	 */
	// private ArrayList<PlotBuffer<A, B>> cached_plots = new ArrayList<>();

	private final ArrayList<Result<Results<A, B>, Color>> cached_results = new ArrayList<>();

	/**
	 * Constructor
	 *
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 * @param background_color
	 *            Background color
	 */
	public PanelGraph(final A x_view, final A y_view, final A x_offset, final A y_offset, final Color background_color)
	{
		super();
		init(x_view, y_view, x_offset, y_offset, background_color);
	}

	/**
	 * Constructor
	 *
	 * @param isDoubleBuffered
	 *            Double buffered
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 * @param background_color
	 *            Background color
	 */
	public PanelGraph(final boolean isDoubleBuffered, final A x_view, final A y_view, final A x_offset,
			final A y_offset, final Color background_color)
	{
		super(isDoubleBuffered);
		init(x_view, y_view, x_offset, y_offset, background_color);
	}

	/**
	 * Constructor
	 *
	 * @param layout
	 *            Layout manager
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 * @param background_color
	 *            Background color
	 */
	public PanelGraph(final LayoutManager layout, final A x_view, final A y_view, final A x_offset, final A y_offset,
			final Color background_color)
	{
		super(layout);
		init(x_view, y_view, x_offset, y_offset, background_color);
	}

	/**
	 * Constructor
	 *
	 * @param layout
	 *            Layout manager
	 * @param isDoubleBuffered
	 *            Double buffered
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 * @param background_color
	 *            Background color
	 */
	public PanelGraph(final LayoutManager layout, final boolean isDoubleBuffered, final A x_view, final A y_view,
			final A x_offset, final A y_offset, final Color background_color)
	{
		super(layout, isDoubleBuffered);
		init(x_view, y_view, x_offset, y_offset, background_color);
	}

	/**
	 * Constructor
	 *
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 */
	public PanelGraph(final A x_view, final A y_view, final A x_offset, final A y_offset)
	{
		super();
		init(x_view, y_view, x_offset, y_offset, null);
	}

	/**
	 * Constructor
	 *
	 * @param isDoubleBuffered
	 *            Double buffered
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 */
	public PanelGraph(final boolean isDoubleBuffered, final A x_view, final A y_view, final A x_offset,
			final A y_offset)
	{
		super(isDoubleBuffered);
		init(x_view, y_view, x_offset, y_offset, null);
	}

	/**
	 * Constructor
	 *
	 * @param layout
	 *            Layout manager
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 */
	public PanelGraph(final LayoutManager layout, final A x_view, final A y_view, final A x_offset, final A y_offset)
	{
		super(layout);
		init(x_view, y_view, x_offset, y_offset, null);
	}

	/**
	 * Constructor
	 *
	 * @param layout
	 *            Layout manager
	 * @param isDoubleBuffered
	 *            Double buffered
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 */
	public PanelGraph(final LayoutManager layout, final boolean isDoubleBuffered, final A x_view, final A y_view,
			final A x_offset, final A y_offset)
	{
		super(layout, isDoubleBuffered);
		init(x_view, y_view, x_offset, y_offset, null);
	}

	/**
	 * Init
	 *
	 * @param x_view
	 *            X view
	 * @param y_view
	 *            Y view
	 * @param x_offset
	 *            X ofset
	 * @param y_offset
	 *            Y offset
	 * @param backgroundColor
	 *            Background color
	 */
	private void init(final A x_view, final A y_view, final A x_offset, final A y_offset, final Color backgroundColor)
	{
		view = new Point<>(x_view, y_view);
		offset = new Point<>(x_offset, y_offset);
		this.background_color = backgroundColor;
		if (getWidth() > 0 && getHeight() > 0)
		{
			image_graph = new ImageGraph<>(getSize().width, getSize().height, x_view, y_view, x_offset, y_offset,
					backgroundColor);
		}
	}

	/**
	 * Get view
	 *
	 * @return View
	 */
	public Point<A> getView()
	{
		return view;
	}

	/**
	 * Get offset
	 *
	 * @return Offset
	 */
	public Point<A> getOffset()
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

	private void updateSize()
	{
		if (getWidth() > 0 && getHeight() > 0)
		{
			boolean c = false;
			if (image_graph == null)
			{
				c = true;
			}
			else if (getWidth() != image_graph.getWidth() || getHeight() != image_graph.getHeight())
			{
				c = true;
			}
			if (c)
			{
				image_graph = new ImageGraph<>(getWidth(), getHeight(), view.X, view.Y, offset.X, offset.Y,
						background_color);
				for (final Result<Results<A, B>, Color> i : cached_results)
				{
					image_graph.drawResults(i.RESULT, i.VALUE);
				}
			}
		}
		else
		{
			image_graph = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#plot(java.lang.Iterable,
	 * com.plotter.core.IAlgorithm, java.awt.Color)
	 */
	@Override
	public Results<A, B> plot(final Iterable<B> values, final IAlgorithm<A, B> algorithm, final Color line_color)
	{
		Results<A, B> ret = null;
		if (image_graph != null)
		{
			ret = image_graph.plot(values, algorithm, line_color);
			cached_results.add(new Result<>(ret, line_color));
			repaint();
		}
		else
		{
			final MultiThreadedComputer<A, B> computer = new MultiThreadedComputer<>();
			cached_results.add(new Result<>(computer.compute(values, algorithm), line_color));
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#clearGraph()
	 */
	@Override
	public void clearGraph()
	{
		cached_results.clear();
		if (image_graph != null)
		{
			image_graph.clearGraph();
			image_graph = null;
			repaint();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics g)
	{
		super.paintComponent(g);
		updateSize();
		if (image_graph != null)
		{
			g.drawImage(image_graph, 0, 0, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#setSize(int, int)
	 */
	@Override
	public void setSize(final int width, final int height)
	{
		super.setSize(width, height);
		updateSize();
	}

}
