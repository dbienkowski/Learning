package com.finastra;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.prowidesoftware.swift.model.MtSwiftMessage;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	private static final int COLUMN_SENDER = 0;
	private static final int COLUMN_TYPE = 1;
	private static final int COLUMN_RECEIVER = 2;
	private static final int COLUMN_MUR = 3;
	private static final int COLUMN_TNR = 4;

	private static final String[] COLUMN_NAMES = { "Sender", "Type", "Receiver", "MUR", "TRN" };

	private List<MtSwiftMessage> messages;

	public TableModel() {
		messages = new ArrayList<MtSwiftMessage>();
	}

	public void addMessage(MtSwiftMessage msg) {
		messages.add(msg);
		int row = messages.indexOf(msg);
		fireTableRowsInserted(row, row);
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public int getRowCount() {
		return messages.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MtSwiftMessage msg = messages.get(rowIndex);
		Object returnValue = null;

		//here regex
		if (msg.getMessageType().matches("101")) {
			switch (columnIndex) {
			case COLUMN_SENDER:
				returnValue = msg.getSender();
				break;
			case COLUMN_TYPE:
				returnValue = msg.getMessageType();
				break;
			case COLUMN_RECEIVER:
				returnValue = msg.getReceiver();
				break;
			case COLUMN_MUR:
				returnValue = msg.getMur();
				break;
			case COLUMN_TNR:
				returnValue = msg.getReference();
				break;
			default:
				throw new IllegalArgumentException("Invalid column index");
			}
		}

		return returnValue;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}

	public List<MtSwiftMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<MtSwiftMessage> messages) {
		this.messages = messages;
	}
}
