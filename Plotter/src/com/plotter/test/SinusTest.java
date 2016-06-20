package com.plotter.test;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import com.plotter.core.DoubleRange;
import com.plotter.core.IAlgorithm;
import com.plotter.visuals.ImageGraph;

public class SinusTest {

	private IAlgorithm<Double, Double> sin_algorithm;

	@Before
	public void setUp() throws Exception {
		sin_algorithm = new IAlgorithm<Double, Double>() {

			@Override
			public Double compute(Double value) {
				return Math.sin(value);
			}
		};
	}

	@Test
	public void test() {
		ImageGraph<Double, Double> graph = new ImageGraph<Double, Double>(1920, 1080, 100.0, 100.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-100.0, 100.0, 10000), sin_algorithm, Color.WHITE);
		File f = new File("sin.png");
		try {
			ImageIO.write(graph, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
