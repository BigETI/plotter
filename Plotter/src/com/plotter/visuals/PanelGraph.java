package com.plotter.visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import com.plotter.core.IAlgorithm;
import com.plotter.core.IGraph;
import com.plotter.core.Point;

/**
 * Panel graph class
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Input type
 */
public class PanelGraph<TA extends Number, TB extends Number> extends JPanel implements IGraph<TA, TB> {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -6635175220166429868L;

	/**
	 * Image graph
	 */
	private ImageGraph<TA, TB> image_graph = null;

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
	public PanelGraph(TA x_view, TA y_view, TA x_offset, TA y_offset, Color background_color) {
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
	public PanelGraph(boolean isDoubleBuffered, TA x_view, TA y_view, TA x_offset, TA y_offset,
			Color background_color) {
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
	public PanelGraph(LayoutManager layout, TA x_view, TA y_view, TA x_offset, TA y_offset, Color background_color) {
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
	public PanelGraph(LayoutManager layout, boolean isDoubleBuffered, TA x_view, TA y_view, TA x_offset, TA y_offset,
			Color background_color) {
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
	public PanelGraph(TA x_view, TA y_view, TA x_offset, TA y_offset) {
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
	public PanelGraph(boolean isDoubleBuffered, TA x_view, TA y_view, TA x_offset, TA y_offset) {
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
	 * @param background_color
	 *            Background color
	 */
	public PanelGraph(LayoutManager layout, TA x_view, TA y_view, TA x_offset, TA y_offset) {
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
	public PanelGraph(LayoutManager layout, boolean isDoubleBuffered, TA x_view, TA y_view, TA x_offset, TA y_offset) {
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
	 * @param background_color
	 *            Background color
	 */
	private void init(TA x_view, TA y_view, TA x_offset, TA y_offset, Color background_color) {
		if ((getWidth() > 0) && (getHeight() > 0))
			image_graph = new ImageGraph<TA, TB>(getSize().width, getSize().height, x_view, y_view, x_offset, y_offset,
					background_color);
	}

	/**
	 * Get view
	 * 
	 * @return View
	 */
	public Point<TA> getView() {
		return image_graph.getView();
	}

	/**
	 * Get offset
	 * 
	 * @return Offset
	 */
	public Point<TA> getOffset() {
		return image_graph.getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#plot(java.lang.Iterable,
	 * com.plotter.core.IAlgorithm, java.awt.Color)
	 */
	@Override
	public void plot(Iterable<TB> values, IAlgorithm<TA, TB> algorithm, Color line_color) {
		image_graph.plot(values, algorithm, line_color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IGraph#clearGraph()
	 */
	@Override
	public void clearGraph() {
		image_graph.clearGraph();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image_graph != null)
			g.drawImage(image_graph, 0, 0, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#setSize(int, int)
	 */
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		if (image_graph != null) {
			if ((width > 0) && (height > 0))
				image_graph = new ImageGraph<TA, TB>(width, height, image_graph.getView().X, image_graph.getView().Y,
						image_graph.getOffset().X, image_graph.getOffset().Y, image_graph.getBackgroundColor());
			else
				image_graph = null;
		}
	}

}
