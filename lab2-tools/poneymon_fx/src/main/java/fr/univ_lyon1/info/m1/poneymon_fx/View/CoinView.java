package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectsModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public final class CoinView extends AbstractObjectView {

    boolean visible = false;
    
    /**
     * Creates CoinView.
     * 
     * @param c.
     */
    public CoinView(String c) {
        image = new Image("assets/gold-coin.gif");
        color = c;
        type = "coin";
    }

    /**
     * Displays coin.
     * 
     * @param graphicsContext.
     */
    public void display(GraphicsContext graphicsContext) {
        if (visible) {
            graphicsContext.drawImage(image, x, y);
        }
    }

    /**
     * Sets the boolean variable visible.
     * 
     * @param b.
     */
    public void setVisible(boolean b) {
        visible = b;
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
            setVisible(o.getVisible());
        }
    }
}
