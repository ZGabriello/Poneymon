package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.stage.Stage;

public final class ScoreView extends AbstractView {
    
    private final ScoreCanvasView scoreCanvasView;

    /**
     * Creates ScoreView.
     * 
     * @param stage.
     * @param model.
     */
    public ScoreView(final Stage stage, final Model model) {
        super(stage, model);
        
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
