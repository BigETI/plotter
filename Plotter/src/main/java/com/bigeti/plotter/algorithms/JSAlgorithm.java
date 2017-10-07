package com.bigeti.plotter.algorithms;

import java.io.StringWriter;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.bigeti.plotter.core.IAlgorithm;

/**
 * JavaScipt algorithm class
 * 
 * @author Ethem Kurt
 * @version 1.0.1
 * @since 1.0.1
 *
 */
public class JSAlgorithm implements IAlgorithm<Double, Double> {

	/**
	 * Script engine
	 */
	private ScriptEngine script_engine = null;

	/**
	 * Compiled script
	 */
	private CompiledScript compiled_script = null;

	/**
	 * String writer
	 */
	private StringWriter writer = new StringWriter();

	/**
	 * Error writer
	 */
	private StringWriter error_writer = new StringWriter();

	/**
	 * Script
	 */
	private String script;

	/**
	 * Constructor
	 * 
	 * @param script
	 *            Script
	 * @throws ScriptException
	 *             Script exception
	 */
	public JSAlgorithm(String script) throws ScriptException {
		setScript(script);
	}

	/**
	 * Get script engine
	 * 
	 * @return Script engine
	 */
	public ScriptEngine getScriptEngine() {
		return script_engine;
	}

	/**
	 * Get compiled script
	 * 
	 * @return Compiled script
	 */
	public CompiledScript getCompiledScript() {
		return compiled_script;
	}

	/**
	 * Get script
	 * 
	 * @return Script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * Set script
	 * 
	 * @param script
	 *            Script
	 * @throws ScriptException
	 *             Script exception
	 */
	public void setScript(String script) throws ScriptException {
		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
		StringWriter sw = new StringWriter();
		StringWriter ew = new StringWriter();
		/*CompiledScript cs = ((Compilable) se).compile("var MathEx = Object.create(Math);\nMathEx.compute = function(x) {\nvar y = 0.0;\n" + script
				+ "\nreturn y;\n};\nfunction compute(x) {\nreturn MathEx.compute(x);\n}\n");*/
		
		CompiledScript cs = ((Compilable) se).compile("var names = Object.getOwnPropertyNames(Math);\nfor (var k in names)\nthis[names[k]] = Math[names[k]];\nfunction compute(x) {\nvar y = 0.0;\n" + script + "\nreturn y;\n}\n");
		Bindings bindings = se.getBindings(ScriptContext.ENGINE_SCOPE);
		cs.eval(bindings);
		se.getContext().setWriter(sw);
		se.getContext().setErrorWriter(ew);
		script_engine = se;
		compiled_script = cs;
		writer = sw;
		error_writer = ew;
	}

	/**
	 * Get output
	 * 
	 * @return Output
	 */
	public String getOutput() {
		return writer.toString();
	}

	public String getError() {
		return error_writer.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.plotter.core.IAlgorithm#compute(java.lang.Object)
	 */
	@Override
	public Double compute(Double value) {
		Double ret = 0.0;
		try {
			Object result = ((Invocable) compiled_script.getEngine()).invokeFunction("compute", value);
			if (result != null)
				ret = Double.valueOf(result.toString());
			else
				System.err.println("result is null!");
		} catch (ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
