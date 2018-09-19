package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectsModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PoneyView extends AbstractObjectView {

    final Image poneyRunning;
    final Image poneyRainbow;
    boolean isNian = false;

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
     * Sets isNian.
     * 
     * @param b.
     */
    public void setIsNian(boolean b) {
        isNian = b;
    }
    
    /**
     * Gets values from the model.
     * 
     * @param o.
     * @param width.
     * @param height.
     */
    public void getValuesFromModel(AbstractObjectsModel o, int width, int height) {
        super.getValuesFromModel(o, width, height);
        if (o.getType() == type && o.getColor() == color) { 
            setIsNian(o.getIsNian());
        }
    }
}
