package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.stage.Stage;

public final class JfxView extends AbstractView {

    private final FieldCanvasView fieldCanvasView;

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
        super(s, c, m);
        
        getStage().setTitle("Poneymon");
        fieldCanvasView = new FieldCanvasView(w, h);
    }

    /**
     * Runs the wiew's canvas function "run".
     */
    public void runCanvas() {
        fieldCanvasView.run(getFieldModel());
    }
    
    /**
     * Shows the stage.
     */
    public void show() {
        getRoot().getChildren().add(fieldCanvasView);
        getStage().setY(150);
        getStage().setX(500);
        super.show();
    }
}
