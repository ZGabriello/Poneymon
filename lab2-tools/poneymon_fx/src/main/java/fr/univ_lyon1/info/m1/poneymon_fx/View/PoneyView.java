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

    /**
     * Creates PoneyView.
     * 
     * @param color.
     */
    public PoneyView(String color) {
        this.color = color;
        poneyImage = new Image("assets/pony-" + color + "-running.gif");
        currentPoney = poneyImage;
    }

    /**
     * Displays the poney.
     * 
     * @param graphicsContext.
     */
    public void display(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(currentPoney, x, y);
    }

    /**
     * Sets x.
     * 
     * @param double.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets y.
     * 
     * @param double.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets isWinner.
     * 
     * @param boolean.
     */
    public void setIsWinner(boolean b) {
        this.isWinner = b;
    }

    /**
     * Checks if the poney has won.
     */
    public boolean isWinner() {
        return isWinner;
    }

    /**
     * Checks the poney information.
     */
    public void check() {
        System.out.println("Poney color : " + this.color 
                + " row : " + this.y 
                + " is winner : " + this.isWinner 
                + " progression : " + this.x);
    }
}
