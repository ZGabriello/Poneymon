package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AbstractObjectView {

    Image image;
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
     * @param m.
     */
    public void getValuesFromModel(FieldModel m) {

    }
}
