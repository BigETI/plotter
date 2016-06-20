package com.plotter.test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import com.plotter.core.DoubleRange;
import com.plotter.core.IAlgorithm;
import com.plotter.visuals.ImageGraph;

public class RandomTest {

	private IAlgorithm<Double, Double> rand_algorithm;

	@Before
	public void setUp() throws Exception {
		rand_algorithm = new IAlgorithm<Double, Double>() {

			@Override
			public Double compute(Double value) {
				return Math.random();
			}
		};
	}

	@Test
	public void test() {
		ImageGraph<Double, Double> graph = new ImageGraph<Double, Double>(1920, 1080, 100.0, 100.0, 0.0, 0.0);
		graph.plot(new DoubleRange(-100.0, 100.0, 100), rand_algorithm, Color.WHITE);
		File f = new File("random.png");
		try {
			ImageIO.write(graph, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
