package com.bigeti.plotter.visuals;

import java.awt.Color;

import com.bigeti.plotter.core.IAlgorithm;

public class PlotBuffer<TA, TB> {
	
	public final Iterable<TB> VALUES;
	
	public final IAlgorithm<TA, TB> ALGORITHM;
	
	public final Color LINE_COLOR;
	
	public PlotBuffer(Iterable<TB> values, IAlgorithm<TA, TB> algorithm, Color line_color) {
		VALUES = values;
		ALGORITHM = algorithm;
		LINE_COLOR = line_color;
	}
}
