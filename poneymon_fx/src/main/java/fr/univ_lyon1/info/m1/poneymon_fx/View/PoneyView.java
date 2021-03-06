package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.PoneyModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public final class PoneyView extends AbstractObjectView {

    private final Image poneyRunning;
    private final Image poneyRainbow;
    private boolean isNian = false;

    /**
     * Creates PoneyView.
     * 
     * @param c.
     */
    public PoneyView(final String c) {
        setColor(c);
        poneyRunning = new Image("assets/pony-" + getColor() + "-running.gif");
        poneyRainbow = new Image("assets/pony-" + getColor() + "-rainbow.gif");
    }

    /**
     * Displays the poney.
     * 
     * @param graphicsContext.
     */
    public void display(final GraphicsContext graphicsContext, 
            final int w, final int h) {
        setImage(isNian ? poneyRainbow : poneyRunning);
        graphicsContext.drawImage(getImage(), getX(), getY(), w / App.NB_PONEYS, h / App.NB_PONEYS);
    }
    
    /**
     * Sets isNian.
     * 
     * @param b.
     */
    public void setIsNian(final boolean b) {
        isNian = b;
    }
    
    /**
     * Gets values from the model.
     * 
     * @param o.
     * @param width.
     * @param height.
     */
    public void getValuesFromModel(final AbstractObjectModel o, 
            final int width, final int height) {
        super.getValuesFromModel(o, width, height);
        setIsNian(((PoneyModel) o).getIsNian());
    }
}
