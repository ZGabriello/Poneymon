package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.stage.Stage;

public final class ScoreView extends AbstractView {
    
    private final ScoreCanvasView scoreCanvasView;

    /**
     * Creates ScoreView.
     * 
     * @param s.
     * @param c.
     * @param m.
     */
    public ScoreView(final Stage s, final Controller c, final FieldModel m) {
        super(s, c, m);
        
        getStage().setTitle("Rank");
        scoreCanvasView = new ScoreCanvasView();
    }

    /**
     * Runs the view's canvas function "run".
     * 
     */
    public void runCanvas() {
        scoreCanvasView.run(getFieldModel());
    }
    
    /**
     * Shows the scores.
     * 
     */
    public void show() {
        getRoot().getChildren().add(scoreCanvasView);
        getStage().setY(0);
        getStage().setX(0);
        super.show();
    }
}
