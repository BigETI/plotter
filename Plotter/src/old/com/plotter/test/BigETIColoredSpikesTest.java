package old.com.plotter.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import old.com.plotter.algorithms.BigETIColoredSpikes;
import old.com.plotter.computer.MultiThreadedComputer;

public class BigETIColoredSpikesTest {

	private BigETIColoredSpikes color_gradient;
	
	@Before
	public void setUp() throws Exception {
		color_gradient = new BigETIColoredSpikes();
	}

	@Test
	public void test() {
		BufferedImage image = color_gradient.plotImage(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE, 1920, 1080, new MultiThreadedComputer<Integer[], BigDecimal[]>(8), new MultiThreadedComputer<Integer[][], BigDecimal[][]>(8));
		File f = new File("bigeticoloredspikes.png");
		try {
			ImageIO.write(image, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
