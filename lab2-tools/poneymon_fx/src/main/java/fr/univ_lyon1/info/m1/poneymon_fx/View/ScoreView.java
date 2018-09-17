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
     * Shows the scores.
     * 
     */
    public void show() {
        /*Text[] scores = fieldModel.checkRank();
        FlowPane fp = new FlowPane();
        for (int i = 0; i < scores.length; i++) {
            fp.getChildren().add(scores[i]);
        } 
        fp.setMaxWidth(100);*/
        scoreCanvasView.display(fieldModel);
        root.getChildren().add(scoreCanvasView);
        stage.setScene(scene);
        stage.setY(0);
        stage.setX(100);
        stage.show();
    }
}
