package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractView {

    private final FieldModel fieldModel;
    private final Group root;
    private final Scene scene;
    private final Stage stage;

    /**
     * Creates abstractView.
     */
    public AbstractView(Stage s, Controller c, FieldModel m) {
        root = new Group();
        scene = new Scene(root);
        stage = s;
        fieldModel = m;
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
    
    /**
     * Gets fieldModel.
     * 
     * @return fieldModel.
     */
    public FieldModel getFieldModel() {
        return fieldModel;
    }
    
    /**
     * Gets root.
     * 
     * @return root.
     */
    public Group getRoot() {
        return root;
    }
    
    /**
     * Gets stage.
     * 
     * @return stage.
     */
    public Stage getStage() {
        return stage;
    }
}