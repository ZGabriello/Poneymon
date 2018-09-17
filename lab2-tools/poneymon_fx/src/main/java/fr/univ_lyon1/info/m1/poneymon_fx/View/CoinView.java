package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CoinView extends AbstractObjectView {

    boolean visible;

    /**
     * Creates CoinView.
     * 
     * @param i.
     */
    public CoinView(int i) {
        image = new Image("assets/gold-coin.gif");
        y = i;
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
     * @param m.
     */
    public void getValuesFromModel(FieldModel m) {
        for (int j = 0; j < m.getPoneysNb(); j++) {
            if (m.getCoinsModel()[j].getY() == y) {
                setX(m.getCoinsModel()[j].getX() * App.WIDTH); // TODO récup valeur width
                setY(m.getCoinsModel()[j].getY() * App.HEIGHT / App.NB_PONEYS);
                setVisible(m.getCoinsModel()[j].getVisible());                
            }
        }
    }
}
