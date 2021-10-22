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
		size(1000, 500);
	}
	
	public void setup() {
		c = new Controller(this);
		udp = new UDPConnection();
		udp.start();
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		udp.sendsMessage("Hola desde eclipse");
	}
}
