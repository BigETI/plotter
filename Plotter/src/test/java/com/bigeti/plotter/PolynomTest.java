package com.bigeti.plotter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigeti.plotter.algorithms.Polynom;
import com.bigeti.plotter.core.DoubleRange;
import com.bigeti.plotter.visuals.ImageGraph;

/**
 * Polynom test class
 *
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 */
public class PolynomTest
{

	/**
	 * Polynom
	 */
	private Polynom polynom;

	/**
	 * Set up
	 *
	 * @throws Exception
	 *             Setup exception
	 */
	@BeforeAll
	public void setUp() throws Exception
	{
		final double[] factors = new double[4];
		factors[0] = 0.0;
		factors[1] = 0.0;
		factors[2] = 0.0;
		factors[3] = 1.0;
		polynom = new Polynom(factors);
	}

	/**
	 * Test
	 */
	@Test
	public void test()
	{
		final ImageGraph<Double, Double> graph = new ImageGraph<>(1920, 1080, 100.0, 100.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-100.0, 100.0, 10000), polynom, Color.WHITE);
		final File f = new File("wtfplot.png");
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
