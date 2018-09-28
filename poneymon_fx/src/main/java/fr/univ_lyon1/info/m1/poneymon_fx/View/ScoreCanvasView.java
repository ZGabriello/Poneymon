package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class ScoreCanvasView extends Canvas {
    
    final GraphicsContext gc;
    
    public ScoreCanvasView() {
        super(300,200);
        gc = this.getGraphicsContext2D();
    }
    
    /**
     * Fills the canvas, displays the score.
     * 
     * @param m.
     * 
     */
    public void run(final Model m) {
        //Fill the canvas.
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, 300, 300);
        
        //Set the color for the font.
        gc.setFill(Color.BLACK);
        
        //Get the array string for scores.
        String[] scores = m.getRank();
        for (int i = 0; i < scores.length; i++) {
            gc.fillText(scores[i], 0, i * 20 + 20);
        } 
        
        if (m.checkWinner()) {
            String winner = m.colorWinner();
            gc.fillText(winner, 0, (App.NB_PONEYS + 1) * 20 + 20);
        }
        
    }
}
