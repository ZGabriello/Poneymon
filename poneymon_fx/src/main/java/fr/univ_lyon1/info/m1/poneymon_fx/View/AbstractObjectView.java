package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AbstractObjectView {

    private Image image;
    private String type;
    private String color;
    private double x;
    private double y;
    
    public void display(final GraphicsContext gc, final int width, final int height) {

    }
    
    /**
     * Sets X.
     * 
     * @param d.
     */
    public void setX(final double d) {
        x = d;
    }
    
    /**
     * Gets X.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * Sets Y.
     * 
     * @param d.
     */
    public void setY(final double d) {
        y = d;
    }
    
    /**
     * Gets Y.
     * 
     */
    public double getY() {
        return y;
    }
    
    /**
     * Sets type.
     * 
     * @param s.
     */
    public void setType(final String s) {
        type = s;
    }
    
    /**
     * Gets type.
     * 
     */
    public String getType() {
        return type;
    }
    
    /**
     * Sets color.
     * 
     * @param s.
     */
    public void setColor(final String s) {
        color = s;
    }
    
    /**
     * Gets color.
     * 
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets image.
     * 
     * @param s.
     */
    public void setImage(final Image i) {
        image = i;
    }
    
    /**
     * Gets image.
     * 
     */
    public Image getImage() {
        return image;
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
        if (o.getType() == type && o.getColor() == color) {
            setX(o.getX() * width - (width / 10)); //TODO why /10 ?
            setY(o.getY() * height / App.NB_PONEYS);
        }
    }
}
