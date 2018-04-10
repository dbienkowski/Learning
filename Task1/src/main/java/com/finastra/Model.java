package com.finastra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import com.prowidesoftware.swift.io.RJEReader;
import com.prowidesoftware.swift.model.mt.AbstractMT;

public class Model {
	private List<AbstractMT> messages;

	public Model() {
		messages = new ArrayList<AbstractMT>();
	}
	public List<AbstractMT> getMessages() {
		return messages;
	}

	public void setMessages(List<AbstractMT> messages) {
		this.messages = messages;
	}
	
		
}
