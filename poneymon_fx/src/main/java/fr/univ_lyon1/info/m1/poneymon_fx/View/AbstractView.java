package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractView {

    private final Model fieldModel;
    private final Group root;
    private final Scene scene;
    private final Stage stage;

    /**
     * Creates abstractView.
     */
    public AbstractView(final Stage s, final Model m) {
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
    public Model getFieldModel() {
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
