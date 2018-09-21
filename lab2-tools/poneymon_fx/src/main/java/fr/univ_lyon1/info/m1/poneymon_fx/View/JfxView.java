package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.stage.Stage;

public final class JfxView extends AbstractView {

    FieldCanvasView fieldCanvasView;

    /**
     * Creates JfxView.
     * 
     * @param s.
     * @param w.
     * @param h.
     */
    public JfxView(Stage s, int w, int h) {
        stage = s;
        stage.setTitle("Poneymon");
        fieldCanvasView = new FieldCanvasView(w, h);
    }

    /**
     * Updates the view.
     */
    public void update() {
        fieldCanvasView.update(fieldModel);
    }
    
    /**
     * Shows the stage.
     */
    public void show() {
        root.getChildren().add(fieldCanvasView);
        stage.setY(150);
        stage.setX(200);
        stage.setScene(scene);
        stage.show();
    }
}
