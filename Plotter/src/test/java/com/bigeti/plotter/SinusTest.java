package com.bigeti.plotter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigeti.plotter.core.DoubleRange;
import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.visuals.ImageGraph;

public class SinusTest
{

	private IAlgorithm<Double, Double> sin_algorithm;

	@BeforeAll
	public void setUp() throws Exception
	{
		sin_algorithm = value -> Math.sin(value);
	}

	@Test
	public void test()
	{
		final ImageGraph<Double, Double> graph = new ImageGraph<>(1920, 1080, 100.0, 100.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-100.0, 100.0, 10000), sin_algorithm, Color.WHITE);
		final File f = new File("sin.png");
		try
		{
			ImageIO.write(graph, "PNG", f);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

}
