package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controler.Controler;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JfxView {

    FieldModel fieldModel;
    Controler controler;
    FieldView fieldView;

    Stage stage;

    int i;
    int j;

    /**
     * Creates JfxView.
     * 
     * @param stage.
     * @param i.
     * @param j.
     * @param nbPoneys.
     */
    public JfxView(Stage stage, int i, int j, int nbPoneys) {
        this.stage = stage;

        stage.setTitle("Poneymon");

        fieldView = new FieldView(i, j, nbPoneys);
    }

    /**
     * Sets the model for the view.
     * 
     * @param FieldModel.
     */
    public void setModel(FieldModel m) {
        this.fieldModel = m;
    }

    /**
     * Sets the controler for the view.
     * 
     * @param Controler.
     */
    public void setControler(Controler c) {
        this.controler = c;
    }

    /**
     * Calls fieldView display().
     */
    public void display() {
        fieldView.display(fieldModel);
    }

    /**
     * Calls fieldView associate().
     */
    public void notifyFieldView() {
        fieldView.associate(this.fieldModel);
    }

    
    /**
     * Show what's need to be shown.
     */
    public void show() {
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(fieldView);
        stage.setScene(scene);
        stage.show();
    }
}
