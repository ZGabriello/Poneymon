package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.CoinModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public final class CoinView extends AbstractObjectView {

    private boolean visible = false;
    
    /**
     * Creates CoinView.
     * 
     * @param c.
     */
    public CoinView(final String c) {
        setImage(new Image("assets/gold-coin.gif"));
        setColor(c);
        setType("coin");
    }

    /**
     * Displays coin.
     * 
     * @param graphicsContext.
     */
    public void display(final GraphicsContext graphicsContext, final int w, 
            final int h) {
        if (visible) {
            graphicsContext.drawImage(getImage(), getX(), 
                    getY(), w / App.NB_PONEYS, h / App.NB_PONEYS);
        }
    }

    /**
     * Sets the boolean variable visible.
     * 
     * @param b.
     */
    public void setVisible(final boolean b) {
        visible = b;
    }
    
    /**
     * Gets values from the model.
     * 
     * @param o.
     * @param width.
     * @param height.
     */
    public void getValuesFromModel(final AbstractObjectModel o, final int width, 
            final int height) {
        super.getValuesFromModel(o, width, height);
        setVisible(((CoinModel) o).getVisible());
    }
}
