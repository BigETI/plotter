package old.com.plotter.computer;

import java.lang.reflect.Array;

import old.com.plotter.core.IComputer;
import old.com.plotter.core.IPlotter;

/**
 * Single threaded computer call
 * 
 * @author Ethem Kurt
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Value type
 */
public class SingleThreadedComputer<TA, TB> implements IComputer<TA, TB> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IComputer#compute(java.lang.Object[],
	 * com.plotter.core.IPlotter)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TA[] compute(TB[] values, Class<TA> clazz, IPlotter<TA, TB> plotter) {
		TA[] ret = null;
		if ((values != null) && (plotter != null)) {
			ret = (TA[]) Array.newInstance(clazz, values.length);
			for (int i = 0; i < values.length; i++)
				ret[i] = plotter.plotElement(values[i], i);
		}
		return ret;
	}
}
