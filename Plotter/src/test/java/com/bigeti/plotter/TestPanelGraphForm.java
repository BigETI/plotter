package com.bigeti.plotter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.bigeti.plotter.algorithms.JSAlgorithm;
import com.bigeti.plotter.algorithms.Polynom;
import com.bigeti.plotter.core.DoubleRange;
import com.bigeti.plotter.core.IAlgorithm;
import com.bigeti.plotter.visuals.PanelGraph;

public class TestPanelGraphForm extends JFrame
{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -3475129906847394071L;

	/**
	 * Content pane
	 */
	private JPanel contentPane;

	/**
	 * Panel graph
	 */
	private PanelGraph<Double, Double> panelGraph;

	/**
	 * Launch the application
	 *
	 * @param args
	 *            Command line arguments
	 */
	public static void main(final String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			try
			{
				final TestPanelGraphForm frame = new TestPanelGraphForm();
				frame.setVisible(true);
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestPanelGraphForm()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		final JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		final JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		final JMenuItem mntmDrawPolynom = new JMenuItem("Draw polynom");
		mntmDrawPolynom.addActionListener(arg0 ->
		{
			final double[] factors = new double[4];
			factors[0] = 0.0;
			factors[1] = -2.0;
			factors[2] = 0.0;
			factors[3] = 0.02;
			final Polynom polynom = new Polynom(factors);
			panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), polynom, Color.WHITE);
		});
		mnEdit.add(mntmDrawPolynom);

		final JMenuItem mntmDrawSinus = new JMenuItem("Draw sinus");
		mntmDrawSinus.addActionListener(arg0 ->
		{
			final IAlgorithm<Double, Double> algorithm = value -> Math.sin(value) * 50.0;
			panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), algorithm, Color.WHITE);
		});
		mnEdit.add(mntmDrawSinus);

		final JMenuItem mntmDrawRandom = new JMenuItem("Draw random");
		mntmDrawRandom.addActionListener(e ->
		{
			final IAlgorithm<Double, Double> algorithm = value -> Math.random() * 100.0 - 50.0;
			panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), algorithm, Color.WHITE);
		});
		mnEdit.add(mntmDrawRandom);

		final JMenuItem mntmDrawJavaScript = new JMenuItem("Draw JavaScript");
		mntmDrawJavaScript.addActionListener(arg0 ->
		{
			final String script = JOptionPane.showInputDialog(null, "Type in a script to draw: ", "Draw JavaScript input", 1);
			try
			{
				panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), new JSAlgorithm("y = " + script + ";"), Color.WHITE);
			}
			catch (IllegalArgumentException | ScriptException e)
			{
				e.printStackTrace();
			}
		});
		mnEdit.add(mntmDrawJavaScript);

		final JSeparator separator = new JSeparator();
		mnEdit.add(separator);

		final JMenuItem mntmClearGraph = new JMenuItem("Clear graph");
		mntmClearGraph.addActionListener(arg0 -> panelGraph.clearGraph());
		mnEdit.add(mntmClearGraph);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelGraph = new PanelGraph<>(100.0, 100.0, 0.0, 0.0);
		panelGraph.setSize(contentPane.getPreferredSize().width, contentPane.getPreferredSize().height);
		contentPane.add(panelGraph, BorderLayout.CENTER);
	}

}
