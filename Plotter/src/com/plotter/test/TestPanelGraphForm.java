package com.plotter.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.plotter.algorithms.JSAlgorithm;
import com.plotter.algorithms.Polynom;
import com.plotter.core.DoubleRange;
import com.plotter.core.IAlgorithm;
import com.plotter.visuals.PanelGraph;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class TestPanelGraphForm extends JFrame {

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPanelGraphForm frame = new TestPanelGraphForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestPanelGraphForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmDrawPolynom = new JMenuItem("Draw polynom");
		mntmDrawPolynom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double[] factors = new double[4];
				factors[0] = 0.0;
				factors[1] = -2.0;
				factors[2] = 0.0;
				factors[3] = 0.02;
				Polynom polynom = new Polynom(factors);
				panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), polynom, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawPolynom);

		JMenuItem mntmDrawSinus = new JMenuItem("Draw sinus");
		mntmDrawSinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IAlgorithm<Double, Double> algorithm = new IAlgorithm<Double, Double>() {

					@Override
					public Double compute(Double value) {
						return (Math.sin(value) * 50.0);
					}
				};
				panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), algorithm, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawSinus);

		JMenuItem mntmDrawRandom = new JMenuItem("Draw random");
		mntmDrawRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAlgorithm<Double, Double> algorithm = new IAlgorithm<Double, Double>() {

					@Override
					public Double compute(Double value) {
						return ((Math.random() * 100.0) - 50.0);
					}
				};
				panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), algorithm, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawRandom);

		JMenuItem mntmDrawJavaScript = new JMenuItem("Draw JavaScript");
		mntmDrawJavaScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String script = JOptionPane.showInputDialog(null, "Type in a script to draw: ", "Draw JavaScript input", 1);
				try {
					panelGraph.plot(new DoubleRange(-100.0, 100.0, 1000), new JSAlgorithm(script), Color.WHITE);
				} catch (IllegalArgumentException | ScriptException e) {
					e.printStackTrace();
				}
			}
		});
		mnEdit.add(mntmDrawJavaScript);

		JSeparator separator = new JSeparator();
		mnEdit.add(separator);

		JMenuItem mntmClearGraph = new JMenuItem("Clear graph");
		mntmClearGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGraph.clearGraph();
			}
		});
		mnEdit.add(mntmClearGraph);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelGraph = new PanelGraph<Double, Double>(100.0, 100.0, 0.0, 0.0);
		panelGraph.setSize(contentPane.getPreferredSize().width, contentPane.getPreferredSize().height);
		contentPane.add(panelGraph, BorderLayout.CENTER);
	}

}
