package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.stage.Stage;

public final class JfxView extends AbstractView {

    private final JfxCanvasView fieldCanvasView;

    /**
     * Creates JfxView.
     * 
     * @param stage.
     * @param width.
     * @param height.
     * @param model.
     */
    public JfxView(final Stage stage, final int width, final int height, final Model model) {
        super(stage, model);
        
        getStage().setTitle("Poneymon");
        fieldCanvasView = new JfxCanvasView(width, height);
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
