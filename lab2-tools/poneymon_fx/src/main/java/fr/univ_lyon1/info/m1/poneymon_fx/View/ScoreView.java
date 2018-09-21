package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class ScoreView extends AbstractView {
    
    HBox hb;
    ScoreCanvasView scoreCanvasView;

    /**
     * Creates ScoreView.
     * 
     * @param s.
     * @param c.
     * @param m.
     */
    public ScoreView(Stage s, Controller c, FieldModel m) {
        stage = s;
        controller = c;
        fieldModel = m;
        stage.setTitle("Poneymon");
        scoreCanvasView = new ScoreCanvasView();
    }

    /**
     * Runs the view's canvas function "run".
     * 
     */
    public void runCanvas() {
        scoreCanvasView.run(fieldModel);
    }
    
    /**
     * Shows the scores.
     * 
     */
    public void show() {
        root.getChildren().add(scoreCanvasView);
        stage.setY(0);
        stage.setX(100);
        super.show();
    }
}
