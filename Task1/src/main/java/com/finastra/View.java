package com.finastra;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class View {
	
	private JTextField senderTextField;
	private JTextField receiverTextField;
	private JTextField trnTextField;
	private JTextField messageTypeTextField;
	private JTextField murTextField;
	
	private JLabel senderLabel;
	private JLabel receiverLabel;
	private JLabel trnLabel;
	private JLabel murLabel;
	private JLabel messageTypeLabel;
	private JButton searchButton;
	private JButton openFileButton;
	
	private JTable table;
	private JScrollPane tableScrollPane;
	private JFrame frame;
		
	public View(TableModel tableModel) {
		
		// Create views swing UI components 
		senderTextField = new JTextField(11);
		receiverTextField = new JTextField(11);
		trnTextField = new JTextField(11);
		messageTypeTextField = new JTextField(6);
		murTextField = new JTextField(11);
		
		senderLabel = new JLabel("Sender:");
		receiverLabel = new JLabel("Receiver:");
		trnLabel = new JLabel("TRN:");
		murLabel = new JLabel("MUR:");
		messageTypeLabel = new JLabel("Type:");
		
		searchButton = new JButton("Search");
		openFileButton = new JButton("Open file");
		
		// Create table 
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);

		// Set the view layout
        JPanel searchPanel = new JPanel();
        searchPanel.add(senderLabel);
        searchPanel.add(senderTextField);
        searchPanel.add(messageTypeLabel);
        searchPanel.add(messageTypeTextField);
        searchPanel.add(receiverLabel);
        searchPanel.add(receiverTextField);
        searchPanel.add(murLabel);
        searchPanel.add(murTextField);
        searchPanel.add(trnLabel);
        searchPanel.add(trnTextField);
        searchPanel.add(searchButton);
        searchPanel.add(openFileButton);
		

		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Messages",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, searchPanel, tableScrollPane);
		splitPane.setDividerLocation(65);
		
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		frame = new JFrame("SWIFT FIN messages");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.add(splitPane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(frame,msg);
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

	public JScrollPane getTableScrollPane() {
		return tableScrollPane;
	}

	public void setTableScrollPane(JScrollPane tableScrollPane) {
		this.tableScrollPane = tableScrollPane;
	}
	
}
