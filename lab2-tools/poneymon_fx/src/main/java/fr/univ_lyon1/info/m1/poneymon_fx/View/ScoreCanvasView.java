package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ScoreCanvasView extends Canvas {
    
    final GraphicsContext gc;
    
    public ScoreCanvasView() {
        super(300,110);
        gc = this.getGraphicsContext2D();
    }
    
    /**
     * Updates data.
     * 
     * @param m.
     * 
     */
    public void gcFill(FieldModel m) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, 300, 300);
        gc.setFill(Color.BLACK);
        String[] scores = m.checkRank();
        for (int i = 0; i < scores.length; i++) {
            gc.fillText(scores[i], 0, i * 20 + 20);
        } 
    }
}
