package com.plotter.test;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import com.plotter.algorithms.Polynom;
import com.plotter.core.DoubleRange;
import com.plotter.visuals.ImageGraph;

/**
 * Polynom test class
 * 
 * @author EThem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class PolynomTest {

	/**
	 * Polynom
	 */
	private Polynom polynom;

	/**
	 * Set up
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		double[] factors = new double[4];
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
	public void test() {
		ImageGraph<Double, Double> graph = new ImageGraph<Double, Double>(1920, 1080, 100.0, 100.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-100.0, 100.0, 10000), polynom, Color.WHITE);
		File f = new File("wtfplot.png");
		try {
			ImageIO.write(graph, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
