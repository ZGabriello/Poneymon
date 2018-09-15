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

    ArrayList<String> input = new ArrayList<String>();
    ArrayList<AbstractObjectView> objectsView = new ArrayList<AbstractObjectView>();
    HashMap<String, String> keyMap = new HashMap<String, String>();
    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };
    final GraphicsContext gc;
    final int width;
    final int height;

    /**
     * Creates FieldView.
     * 
     * @param w.
     * @param h.
     */
    public FieldView(int w, int h) {
        super(w, h);
        width = w;
        height = h;

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
            PoneyView[] poneysView = new PoneyView[model.getPoneysNb()];
            CoinView[] coinsView = new CoinView[model.getPoneysNb()];
            for (int i = 0; i < model.getPoneysNb(); i++) {
                poneysView[i] = new PoneyView(colorMap[i]);
                coinsView[i] = new CoinView(i);
            }
            addObjectView(poneysView);
            addObjectView(coinsView);

            objectsDisplay();
        }
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, width, height);

                if (model != null) {
                    if (!model.getPaused()) {
                        model.step();
                    }                    
                    notifyModel(model);
                    getValuesFromModel(model);
                    objectsDisplay();
                    if (model.checkWinner()) {
                        this.stop();
                    }
                }

            }
        }.start(); // On lance la boucle de rafraichissement
    }

    /**
     * Checks if a key is pressed, returns the color of the poney corresponding to
     * the key.
     * 
     * @param m.
     */
    public void notifyModel(FieldModel m) {
        if (!input.isEmpty()) {
            for (int i = 0; i < input.size(); i++) {
                m.setIsNianManually(true, keyMap.get(input.get(i)));
            }
            if (input.contains("SPACE")) {
                m.checkRank("blue");
            }
        }
    }

    /**
     * Associates the data for the view.
     * 
     * @param model.
     */
    public void getValuesFromModel(FieldModel model) {
        if (model != null) {
            for (int j = 0; j < objectsView.size(); j++) {
                objectsView.get(j).getValuesFromModel(model);
            }
        }
    }    

    /**
     * Adds an objectView to the array list of objectsViews.
     * 
     * @param v.
     */
    public void addObjectView(AbstractObjectView[] v) {
        for (int i = 0; i < v.length; i++) {
            objectsView.add(v[i]);
        }
    }

    /**
     * Calls display() for each objectView.
     * 
     */
    public void objectsDisplay() {
        for (int i = 0; i < objectsView.size(); i++) {
            objectsView.get(i).display(gc);
        }
    }

}
