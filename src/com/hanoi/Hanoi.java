package com.hanoi;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Hanoi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame f = new JFrame("Algorithme Hanoi");
	static DefaultListModel<String> model = new DefaultListModel<>();
	static JList<String> list = new JList<>(model);
	static JScrollPane pane = new JScrollPane(list);

	public Hanoi() {
		list.setFont(new Font("Courier", Font.BOLD,24));
		setLayout(new BorderLayout());
		add(pane);
	}

	public static void AlgoHanoi(int n, String from, String temp, String to) {
		if (n == 0)
			return;
		AlgoHanoi(n - 1, from, to, temp);
		model.addElement("Bougez le disque " + n + " de " + from + " ра " + to);
		AlgoHanoi(n - 1, temp, from, to);
	}

	public static void main(String[] args) {
		String a;
		int n;
		a = JOptionPane.showInputDialog("Combien de diques ?");
		n = Integer.parseInt(a);
		AlgoHanoi(n, "A", "B", "C");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Hanoi());
		f.setSize(460, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
