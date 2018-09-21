package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectsModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AbstractObjectsView {

    Image image;
    String type;
    String color;
    double x;
    double y;
    
    public void display(GraphicsContext gc) {

    }
    
    /**
     * Sets X.
     * 
     * @param d.
     */
    public void setX(double d) {
        x = d;
    }

    /**
     * Sets Y.
     * 
     * @param d.
     */
    public void setY(double d) {
        y = d;
    }
    
    /**
     * Gets values from the model.
     * 
     * @param o.
     * @param width.
     * @param height.
     */
    public void getValuesFromModel(AbstractObjectsModel o, int width, int height) {
        if (o.getType() == type && o.getColor() == color) {
            setX(o.getX() * width - 100); //TODO why 100 ?
            setY(o.getY() * height / App.NB_PONEYS);
        }
    }
}
