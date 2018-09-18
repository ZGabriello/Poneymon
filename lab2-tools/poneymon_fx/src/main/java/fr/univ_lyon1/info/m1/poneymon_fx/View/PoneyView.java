package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PoneyView extends AbstractObjectView {

    final Image poneyRunning;
    final Image poneyRainbow;

    /**
     * Creates PoneyView.
     * 
     * @param c.
     */
    public PoneyView(String c) {
        color = c;
        type = "poney";
        poneyRunning = new Image("assets/pony-" + color + "-running.gif");
        poneyRainbow = new Image("assets/pony-" + color + "-rainbow.gif");
    }

    /**
     * Displays the poney.
     * 
     * @param graphicsContext.
     */
    public void display(GraphicsContext graphicsContext) {
        image = isNian ? poneyRainbow : poneyRunning;
        graphicsContext.drawImage(image, x, y);
    }

    /**
     * Checks the poney information.
     */
    public void check() {
        System.out.println("Poney color : " + color + " row : " + y + " is nian : " + isNian
                + " progression : " + x);
    }

    /**
     * Gets values from the model.
     * 
     * @param m.
     */
    /*public void getValuesFromModel(FieldModel m, int width, int height) {
        for (int j = 0; j < App.NB_PONEYS; j++) {
            if (m.getPoneysModel()[j].getColor() == color) {
                setX(m.getPoneysModel()[j].getX() * width - 150);
                setY(m.getPoneysModel()[j].getY() * height / App.NB_PONEYS);
                setIsNian(m.getPoneysModel()[j].getIsNian());
            }
        }
    }*/
}
