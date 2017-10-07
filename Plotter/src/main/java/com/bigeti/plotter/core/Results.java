package com.bigeti.plotter.core;

import java.util.ArrayList;

/**
 * Results class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <TA>
 *            Result type
 * @param <TB>
 *            Input type
 */
public class Results<TA, TB> extends ArrayList<Result<TA, TB>> {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1062398075008657156L;

	/**
	 * Default constructor
	 */
	public Results() {
		super();
	}
}
