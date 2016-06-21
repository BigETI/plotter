package com.plotter.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.plotter.algorithms.Polynom;
import com.plotter.core.DoubleRange;
import com.plotter.core.IAlgorithm;
import com.plotter.visuals.PanelGraph;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPanelGraphForm extends JFrame {

	private JPanel contentPane;

	private PanelGraph<Double, Double> panelGraph;

	/**
	 * Launch the application.
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
				factors[1] = 0.0;
				factors[2] = 0.0;
				factors[3] = 1.0;
				Polynom polynom = new Polynom(factors);
				panelGraph.clearGraph();
				panelGraph.plot(new DoubleRange(100.0, 100.0, 10000), polynom, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawPolynom);

		JMenuItem mntmDrawSinus = new JMenuItem("Draw sinus");
		mntmDrawSinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IAlgorithm<Double, Double> algorithm = new IAlgorithm<Double, Double>() {

					@Override
					public Double compute(Double value) {
						return Math.sin(value);
					}
				};
				panelGraph.clearGraph();
				panelGraph.plot(new DoubleRange(100.0, 100.0, 10000), algorithm, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawSinus);

		JMenuItem mntmDrawRandom = new JMenuItem("Draw random");
		mntmDrawRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAlgorithm<Double, Double> algorithm = new IAlgorithm<Double, Double>() {

					@Override
					public Double compute(Double value) {
						return (Math.random() - 0.5);
					}
				};
				panelGraph.clearGraph();
				panelGraph.plot(new DoubleRange(100.0, 100.0, 10000), algorithm, Color.WHITE);
			}
		});
		mnEdit.add(mntmDrawRandom);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelGraph = new PanelGraph<Double, Double>(-100.0, 100.0, 0.0, 0.0);
		panelGraph.setSize(100, 100);
		contentPane.add(panelGraph, BorderLayout.CENTER);
	}

}
