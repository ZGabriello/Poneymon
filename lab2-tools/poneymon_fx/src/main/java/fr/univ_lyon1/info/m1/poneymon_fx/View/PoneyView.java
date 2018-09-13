package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PoneyView {
	
	double x;
	double y;
	Image currentPoney;
    Image poneyImage;
	String color;
	boolean isWinner = false;
	
	public PoneyView(String color) {
		this.color = color;
		poneyImage = new Image("assets/pony-" + color + "-running.gif");
        currentPoney = poneyImage;		
	}
	
	public void display(GraphicsContext graphicsContext) {		
		graphicsContext.drawImage(currentPoney, x, y);
	}	
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setIsWinner(boolean b) {
		this.isWinner = b;
	}
	
	public boolean isWinner() {
		return isWinner;
	}
	
	public void check() {
		System.out.println(
				"Poney color : " + this.color +
				" row : " + this.y +
				" is winner : " + this.isWinner +
				" progression : " + this.x);
	}
}
