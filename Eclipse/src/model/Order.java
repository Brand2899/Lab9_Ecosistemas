package model;

import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class Order {
	
	private PApplet app;
	private PImage img;
	private Date orderDate;
	private int posX;
	private int posY;
	private String text;
	
	public Order(PApplet app, String imgLink, int posX, int posY, String text) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.text = text;
		img = app.loadImage(imgLink);
		orderDate = new Date();
	}
	
	public void draw() {
		app.image(img, posX, posY);
		app.fill(0);
		app.textSize(20);
		app.text(text, posX + 210, posY + 30);
		app.text(orderDate + "", posX + 210, posY + 60);
	}

	public PImage getImg() {
		return img;
	}

	public void setImg(PImage img) {
		this.img = img;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
