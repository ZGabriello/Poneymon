package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PoneyView extends AbstractObjectView {

    Image poneyRunning;
    Image poneyRainbow;
    String color;
    boolean isNian = false;

    /**
     * Creates PoneyView.
     * 
     * @param c.
     */
    public PoneyView(String c) {
        color = c;
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
     * Sets isNian.
     * 
     * @param b.
     */
    public void setIsNian(boolean b) {
        isNian = b;
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
    public void getValuesFromModel(FieldModel m) {
        for (int j = 0; j < m.getPoneysNb(); j++) {
            if (m.getPoneysModel()[j].getColor() == color) {
                setX(m.getPoneysModel()[j].getProgression() * App.WIDTH - 150);
                setY(m.getPoneysModel()[j].getRow() * App.HEIGHT / App.NB_PONEYS);
                setIsNian(m.getPoneysModel()[j].getIsNian());
            }
        }
    }
}
