package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CoinView extends AbstractObjectView {

    boolean visible;
    int row;

    /**
     * Creates CoinView.
     * 
     * @param i.
     */
    public CoinView(int i) {
        image = new Image("assets/gold-coin.gif");
        y = i;
        row = i;
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
     * Sets row.
     * 
     * @param a.
     */
    public void setRow(int a) {
        row = a;
    }

    /**
     * Gets values from the model.
     * 
     * @param m.
     */
    public void getValuesFromModel(FieldModel m, int width, int height) {
        for (int j = 0; j < App.NB_PONEYS; j++) {
            if (m.getCoinsModel()[j].getRow() == row) {
                setX(m.getCoinsModel()[j].getX() * width);
                setY(m.getCoinsModel()[j].getY() * height / App.NB_PONEYS);
                setVisible(m.getCoinsModel()[j].getVisible());  
                setRow(m.getCoinsModel()[j].getRow());
            }
        }
    }
}
