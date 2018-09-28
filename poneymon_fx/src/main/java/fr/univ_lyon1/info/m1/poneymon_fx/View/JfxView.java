package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.stage.Stage;

public final class JfxView extends AbstractView {

    private final JfxCanvasView fieldCanvasView;

    /**
     * Creates JfxView.
     * 
     * @param s.
     * @param w.
     * @param h.
     * @param c.
     * @param m.
     */
    public JfxView(final Stage s, final int w, final int h, final Model m) {
        super(s, m);
        
        getStage().setTitle("Poneymon");
        fieldCanvasView = new JfxCanvasView(w, h);
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
