package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PoneyView {

    double x;
    double y;
    Image currentPoney;
    Image poneyRunning;
    Image poneyRainbow;
    String color;
    boolean isWinner = false;
    boolean isNian = false;

    /**
     * Creates PoneyView.
     * 
     * @param color.
     */
    public PoneyView(String color) {
        this.color = color;
        poneyRunning = new Image("assets/pony-" + color + "-running.gif");
        poneyRainbow = new Image("assets/pony-" + color + "-rainbow.gif");
        // currentPoney = poneyRunning;
    }

    /**
     * Displays the poney.
     * 
     * @param graphicsContext.
     */
    public void display(GraphicsContext graphicsContext) {
        if (!isNian) {
            currentPoney = poneyRunning;
        } else {
            currentPoney = poneyRainbow;
        }
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
     * Sets isNian.
     * 
     * @param boolean.
     */
    public void setIsNian(boolean b) {
        this.isNian = b;
    }

    /**
     * Gets color.
     * 
     */
    public String getColor() {
        return this.color;
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
        System.out.println("Poney color : " + this.color + " row : " + this.y + " is winner : "
                + this.isWinner + " is nian : " + this.isNian + " progression : " + this.x);
    }

    /**
     * Returns the poney's rank.
     * 
     * @param poney.
     */
    public double distance(PoneyView poney) {
        return this.x - poney.x;
    }
}
