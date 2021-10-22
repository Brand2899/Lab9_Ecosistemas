package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private ArrayList<Order> orders;
	
	public Logic(PApplet app) {
		this.app = app;
		orders = new ArrayList<Order>();
	}
	
	public void draw() {
		for(int i = 0; i < orders.size(); i++) {
			orders.get(i).draw();
		}
	}
	
	public void createNewOrder(String imgLink) {
		orders.add(new Order(app, imgLink, 0, 0, ""));
	}
}
