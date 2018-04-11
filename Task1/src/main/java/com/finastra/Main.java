package com.finastra;

public class Main {

	public static void main(String[] args) {
		TableModel model = new TableModel();
		View view = new View(model);
		Controller c = new Controller(model, view);
		c.initController();
	}
}
