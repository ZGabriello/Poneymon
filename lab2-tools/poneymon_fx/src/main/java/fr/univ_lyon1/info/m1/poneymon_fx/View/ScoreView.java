package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ScoreView extends AbstractView {
    
    HBox hb;
    ScoreCanvasView scoreCanvasView;

    /**
     * Creates ScoreView.
     * 
     * @param s.
     */
    public ScoreView(Stage s) {
        stage = s;
        stage.setTitle("Poneymon");
        scoreCanvasView = new ScoreCanvasView();
    }

    /**
     * Updates the view.
     * 
     */
    public void update() {
        scoreCanvasView.gcFill(fieldModel);
    }
    
    /**
     * Shows the scores.
     * 
     */
    public void show() {
        root.getChildren().add(scoreCanvasView);
        stage.setScene(scene);
        stage.setY(0);
        stage.setX(100);
        stage.show();
    }
}
