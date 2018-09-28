package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class InfoCanvasView extends Canvas {
    
    private final GraphicsContext gc;
    
    public InfoCanvasView() {
        super(300,240);
        gc = this.getGraphicsContext2D();
    }
    
    /**
     * Fills the canvas, displays the score.
     * 
     * @param m.
     * 
     */
    public void run(final Model m, final int index) {
        //Fill the canvas.
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, 300, 300);
        
        //Set the color for the font.
        gc.setFill(Color.BLACK);
        
        //Get the array string for scores.
        String[] info = m.checkInformations(index);
        for (int i = 0; i < info.length; i++) {
            gc.fillText(info[i], 0, i * 20 + 50);
        } 
    }
}
