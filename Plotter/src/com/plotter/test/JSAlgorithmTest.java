package com.plotter.test;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import com.plotter.algorithms.JSAlgorithm;
import com.plotter.core.DoubleRange;
import com.plotter.visuals.ImageGraph;

/**
 * JavaScript algorithm test class
 * 
 * @author Ethem Kurt
 * @version 1.0.1
 * @since 1.0.1
 *
 */
public class JSAlgorithmTest {

	/**
	 * JavaScript algorithm
	 */
	private JSAlgorithm js_algorithm;

	/**
	 * Before test
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Before
	public void setUp() throws Exception {
		js_algorithm = new JSAlgorithm("y = sin(x);");
	}

	/**
	 * Test
	 */
	@Test
	public void test() {
		ImageGraph<Double, Double> graph = new ImageGraph<Double, Double>(1920, 1080, 20.0, 20.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-20.0, 20.0, 10000), js_algorithm, Color.WHITE);
		File f = new File("jsplot.png");
		try {
			ImageIO.write(graph, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
