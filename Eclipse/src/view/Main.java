package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {
	
	private UDPConnection udp;
	private Controller c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1000, 1000);
	}
	
	public void setup() {
		background(255);
		c = new Controller(this);
		udp = new UDPConnection();
		udp.start();
	}
	
	public void draw() {
		c.draw();
	}
	
	public void createNewOrder(String imgLink) {
		c.createNewOrder(imgLink);
	}
	
	public void mousePressed() {
		udp.sendMessage("Hola desde eclipse");
	}
}
