package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.stage.Stage;

public final class JfxView extends AbstractView {

    FieldCanvasView fieldCanvasView;

    /**
     * Creates JfxView.
     * 
     * @param s.
     * @param w.
     * @param h.
     * @param c.
     * @param m.
     */
    public JfxView(Stage s, int w, int h, Controller c, FieldModel m) {
        super();
        stage = s;
        stage.setTitle("Poneymon");
        fieldCanvasView = new FieldCanvasView(w, h);
        controller = c;
        fieldModel = m;
    }

    /**
     * Runs the wiew's canvas function "run".
     */
    public void runCanvas() {
        fieldCanvasView.run(fieldModel);
    }
    
    /**
     * Shows the stage.
     */
    public void show() {
        root.getChildren().add(fieldCanvasView);
        stage.setY(150);
        stage.setX(200);
        super.show();
    }
}
