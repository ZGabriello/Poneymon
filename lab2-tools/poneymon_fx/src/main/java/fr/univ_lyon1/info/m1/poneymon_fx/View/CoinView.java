package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CoinView extends AbstractObjectView {


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
     * Gets values from the model.
     * 
     * @param m.
     */
    /*public void getValuesFromModel(FieldModel m, int width, int height) {
        for (int j = 0; j < App.NB_PONEYS; j++) {
            if (m.getCoinsModel()[j].getColor() == color) {
                setX(m.getCoinsModel()[j].getX() * width);
                setY(m.getCoinsModel()[j].getY() * height / App.NB_PONEYS);
                setVisible(m.getCoinsModel()[j].getVisible());  
                //setRow(m.getCoinsModel()[j].getRow());
            }
        }
    }*/
}
