package old.com.plotter.computer;

import java.util.concurrent.Callable;

/**
 * Abstract multi thread call class
 * 
 * @author Ethem Kurt
 *
 * @param <T>
 *            Result type
 */
public abstract class AMultiThreadCall<T> implements Callable<T> {

	/**
	 * Index
	 */
	protected final int index;

	/**
	 * Constructor
	 * 
	 * @param index
	 *            Index
	 */
	public AMultiThreadCall(int index) {
		this.index = index;
	}
}
