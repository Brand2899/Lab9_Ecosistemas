package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	
	private Logic l;
	
	public Controller(PApplet app) {
		l = new Logic(app);
	}
	
	public void draw() {
		l.draw();
	}
	
	public void createNewOrder(String imgLink) {
		l.createNewOrder(imgLink);
	}
}
