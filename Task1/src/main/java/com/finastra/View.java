package com.finastra;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class View {
	
	private JTextField senderTextField;
//	private JTextField receiverTextField;
//	private JTextField trnTextField;
//	private JTextField messageTypeTextField;
//	private JTextField murTextField;
	
	private JLabel senderLabel;
	private JButton searchButton;
	private JButton openFileButton;
	private JTable table;
	private JScrollPane tableScrollPane;
	
	public View() {
		// Create views swing UI components 
		senderTextField = new JTextField(26);
//		receiverTextField = new JTextField(26);
//		trnTextField = new JTextField(26);
//		messageTypeTextField = new JTextField(26);
//		murTextField = new JTextField(26);
		
		//senderLabel = new JLabel("Sender:");
		searchButton = new JButton("Search");
		openFileButton = new JButton("Open file");
		table = new JTable(new DefaultTableModel());

		// Create table model
		//Model model = new Model();
		table.setModel(new DefaultTableModel(null, new Object[]{"Sender", "Type", "Receiver", "MUR", "TRN"}));

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		//ctrlPane.add(senderLabel);
		ctrlPane.add(senderTextField);
		ctrlPane.add(searchButton);
		ctrlPane.add(openFileButton);
		

		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Messages",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("SWIFT FIN messages");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JTextField getSenderTextField() {
		return senderTextField;
	}

	public void setSenderTextField(JTextField senderTextField) {
		this.senderTextField = senderTextField;
	}

	public JLabel getSenderLabel() {
		return senderLabel;
	}

	public void setSenderLabel(JLabel senderLabel) {
		this.senderLabel = senderLabel;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JButton getOpenFileButton() {
		return openFileButton;
	}

	public void setOpenFileButton(JButton openFileButton) {
		this.openFileButton = openFileButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
}
