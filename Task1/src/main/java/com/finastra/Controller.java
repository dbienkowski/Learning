package com.finastra;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import com.prowidesoftware.swift.io.RJEReader;
import com.prowidesoftware.swift.model.MtSwiftMessage;

public class Controller {
	private TableModel model;
	private View view;

	public Controller(TableModel m, View v) {
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

			try {
				reader = new RJEReader(file);
				while (reader.hasNext()) {
					model.addMessage(MtSwiftMessage.parse(reader.next()));
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void searchMessage() {
		
		model.getMessages().remove(0);
		model.fireTableDataChanged();
		
		

	}
}
