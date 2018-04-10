package com.finastra;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller c = new Controller(model, view);
		c.initController();
	}

}
