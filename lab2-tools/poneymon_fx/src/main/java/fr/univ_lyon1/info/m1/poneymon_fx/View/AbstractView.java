package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractView {

    FieldModel fieldModel;
    Controller controler;
    Group root;
    Scene scene;
    Stage stage;

    /**
     * Creates abstractView.
     */
    public AbstractView() {
        root = new Group();
        scene = new Scene(root);
    }

    /**
     * Sets the model for the view.
     * 
     * @param m.
     */
    public void setModel(FieldModel m) {
        fieldModel = m;
    }

    /**
     * Sets the controler for the view.
     * 
     * @param c.
     */
    public void setControler(Controller c) {
        controler = c;
    }

    public void update() {

    }

    public void show() {

    }
}
