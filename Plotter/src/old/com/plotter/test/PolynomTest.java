package old.com.plotter.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import old.com.plotter.algorithms.Polynom;
import old.com.plotter.computer.MultiThreadedComputer;
import old.com.plotter.computer.SingleThreadedComputer;

/**
 * Polynom test class
 * 
 * @author Ethem Kurt
 *
 */
public class PolynomTest {

	/**
	 * Polynom
	 */
	private Polynom poly;

	/**
	 * Set up
	 * 
	 * @throws Exception
	 *             Exception
	 */
	@Before
	public void setUp() throws Exception {
		double[] factors = new double[4];
		for (int i = 0; i < factors.length; i++)
			factors[i] = Math.random();
		poly = new Polynom(factors);
		System.out.println(poly);
	}

	/**
	 * Test
	 */
	@Test
	public void test() {
		Double[] values = new Double[10000];
		for (int i = 0; i < values.length; i++)
			values[i] = ((double) i) - 6.0;
//		long a, b;

		// Single threaded
//		a = System.currentTimeMillis();
		poly.plot(values, new SingleThreadedComputer<Double, Double>());
//		b = System.currentTimeMillis();
//		System.out.println("SingleThreadedComputer took " + (b - a) + "ms.");

		// Multi threaded (8 threads)
//		a = System.currentTimeMillis();
		poly.plot(values, new MultiThreadedComputer<Double, Double>(8));
//		b = System.currentTimeMillis();
//		System.out.println("MultiThreadedComputer took " + (b - a) + "ms.");

		// Create plot image
		BufferedImage image = poly.plotImage(-100.0, 100.0, 200.0, 200.0, 1000, 1920, 1080,
				new MultiThreadedComputer<Double, Double>(8), new MultiThreadedComputer<Integer[], Double[]>(8));
		File f = new File("testplot.png");
		try {
			ImageIO.write(image, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
