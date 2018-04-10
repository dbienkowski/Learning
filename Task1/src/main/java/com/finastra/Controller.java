package com.finastra;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import com.prowidesoftware.swift.io.RJEReader;
import com.prowidesoftware.swift.model.mt.AbstractMT;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
	}

	public void initController() {
		view.getOpenFileButton().addActionListener(e -> openFile());
		view.getSearchButton().addActionListener(e -> searchMessage());
	}

	private void openFile() {
		JFileChooser chooser = new JFileChooser();

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();

			RJEReader reader;
			DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
			try {
				reader = new RJEReader(file);
				AbstractMT msg; 
				while (reader.hasNext()) {
					msg = reader.nextMT();
					model.getMessages().add(msg);
					tableModel.addRow(new Object[] {msg.getSender(),msg.getMessageType(),msg.getReceiver()});
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void searchMessage() {
		
	}
}
