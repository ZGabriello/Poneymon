package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractView {

    FieldModel fieldModel;
    Controller controller;
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
     * Runs the view's canvas function "run".
     * 
     */
    public void runCanvas() {
        
    }

    public void show() {
        stage.setScene(scene);
        stage.show();
    }
}
