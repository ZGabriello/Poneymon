package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;

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
    final GraphicsContext gc;

    final int width;
    final int height;
    int nbPoneys;

    ArrayList<String> input = new ArrayList<String>();

    /**
     * Creates FieldView.
     * 
     * @param w.
     */
    public FieldView(int w, int h, int nbPoneys) {
        super(w, h);
        this.width = w;
        this.height = h;
        this.nbPoneys = nbPoneys;

        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();

        poneysView = new PoneyView[nbPoneys];
        for (int i = 0; i < nbPoneys; i++) {
            poneysView[i] = new PoneyView(colorMap[i]);
            poneysView[i].display(gc);
        }

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
    }

    /**
     * Display().
     * 
     * @param model.
     */
    public void display(final FieldModel model) {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // On nettoie le canvas a chaque frame
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, width, height);

                model.step();
                associate(model);
                for (int i = 0; i < 5; i++) {
                    poneysView[i].display(gc);
                    if (poneysView[i].isWinner()) {
                        System.out.println(colorMap[i] + " poney won. ");
                        this.stop();
                    }
                }
            }
        }.start(); // On lance la boucle de rafraichissement
    }

    /**
     * Associates the data for the view.
     * 
     * @param model.
     */
    public void associate(FieldModel model) {
        for (int j = 0; j < nbPoneys; j++) {
            poneysView[j].setX(model.getPoneysModel()[j].getProgression() * width - 150);
            poneysView[j].setY(model.getPoneysModel()[j].getRow() * 110);
            poneysView[j].setIsWinner(model.getPoneysModel()[j].getIsWinner());
        }
    }
}
