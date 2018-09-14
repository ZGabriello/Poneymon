package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;
import java.util.HashMap;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class FieldView extends Canvas {

    PoneyView[] poneysView;
    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };
    HashMap<String, String> keyMap = new HashMap<String, String>();
    final GraphicsContext gc;

    final int width;
    final int height;

    ArrayList<String> input = new ArrayList<String>();

    /**
     * Creates FieldView.
     * 
     * @param w.
     */
    public FieldView(int w, int h) {
        super(w, h);
        this.width = w;
        this.height = h;

        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                input.add(e.getCode().toString());            
            }
        });

        this.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                input.remove(e.getCode().toString());
            }
        });
        
        keyMap.put("Q", "blue");
        keyMap.put("W", "green");
        keyMap.put("E", "orange");
        keyMap.put("R", "purple");
        keyMap.put("T", "yellow");
    }

    /**
     * Display().
     * 
     * @param model.
     */
    public void display(final FieldModel model) {
        if (model != null) {                             
            poneysView = new PoneyView[model.getPoneysNb()];
            for (int i = 0; i < model.getPoneysNb(); i++) {
                poneysView[i] = new PoneyView(colorMap[i]);
                poneysView[i].display(gc);                
            }                        
        }
        new AnimationTimer() {
            public void handle(long currentNanoTime) {                
                // On nettoie le canvas a chaque frame
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, width, height);

                if (model != null) {
                    model.step();
                    notifyModel(model);
                    associate(model);
                    for (int i = 0; i < model.getPoneysNb(); i++) {                        
                        poneysView[i].display(gc);
                        if (poneysView[i].isWinner()) {
                            System.out.println(colorMap[i] + " poney won. ");
                            this.stop();
                        }
                    }
                    
                }
                
            }
        }.start(); // On lance la boucle de rafraichissement
    }    

    /**
     * Checks if a key is pressed, returns the color of the poney corresponding to the key.
     * 
     * @param model.
     */
    public void notifyModel(FieldModel m) {
        if (!input.isEmpty()) {
            if (!input.contains("SPACE")) {
                for (int i = 0; i < input.size(); i++) {
                    m.setIsNian(true, keyMap.get(input.get(i)));
                }
            }
            if (input.contains("SPACE")) {
                checkRank("blue");
            }
            
        }       
    }
    
    /**
     * Associates the data for the view.
     * 
     * @param model.
     */
    public void associate(FieldModel model) {
        if (model != null) {
            for (int j = 0; j < model.getPoneysNb(); j++) {
                poneysView[j].setX(model.getPoneysModel()[j].getProgression() * width - 150);
                poneysView[j].setY(model.getPoneysModel()[j].getRow() * 110);
                poneysView[j].setIsWinner(model.getPoneysModel()[j].getIsWinner());
                poneysView[j].setIsNian(model.getPoneysModel()[j].getIsNian());
            }
        }        
    }
    
    /**
     * Checks the poney's color rank.
     * 
     * @param color.
     */
    public void checkRank(String color) {
        ArrayList<Double> ranking = new ArrayList<Double>();
        for (int i = 0; i < poneysView.length; i++) {
            if (poneysView[i].getColor() == color) {
                for (int j = 0; j < poneysView.length; j++) {
                    if (i != j) {                        
                        ranking.add(poneysView[i].distance(poneysView[j]));
                    }
                }
            }
        }
        int positiveNumbers = 0;
        int rank = 0;
        for (int i = 0; i < ranking.size(); i++) {
            if (ranking.get(i) > 0) {
                positiveNumbers++;
            }
        }
        if (positiveNumbers == 4) {
            rank = 1;
        }
        if (positiveNumbers == 3) {
            rank = 2;
        }
        if (positiveNumbers == 2) {
            rank = 3;
        }
        if (positiveNumbers == 1) {
            rank = 4;
        }
        if (positiveNumbers == 0) {
            rank = 5;
        }
        System.out.println(rank);
    }
}
