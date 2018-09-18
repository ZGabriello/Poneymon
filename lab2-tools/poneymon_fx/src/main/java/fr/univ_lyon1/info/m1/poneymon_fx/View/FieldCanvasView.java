package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;
import java.util.HashMap;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectsModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class FieldCanvasView extends Canvas {

    ArrayList<String> inputs = new ArrayList<String>();
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
    public FieldCanvasView(int w, int h) {
        super(w, h);
        width = w;
        height = h;
        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                inputs.add(e.getCode().toString());
            }
        });

        this.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                inputs.remove(e.getCode().toString());
            }
        });

        keyMap.put("Q", "blue");
        keyMap.put("W", "green");
        keyMap.put("E", "orange");
        keyMap.put("R", "purple");
        keyMap.put("T", "yellow");
        
        PoneyView[] poneysView = new PoneyView[App.NB_PONEYS];
        CoinView[] coinsView = new CoinView[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            poneysView[i] = new PoneyView(colorMap[i]);
            coinsView[i] = new CoinView(colorMap[i]);
        }
        addObjectView(poneysView);
        addObjectView(coinsView);
    }
    
    /**
     * Checks if a key is pressed, returns the color of the poney corresponding to
     * the key.
     * 
     * @param m.
     */
    public void notifyModel(FieldModel m) {
        if (!inputs.isEmpty()) {
            for (String input : inputs) {
                m.setIsNianManually(true, keyMap.get(input));
            }
        }
    }

    /**
     * Associates the data for the view.
     * 
     * @param objectsModel.
     * @param width.
     * @param height.
     */
    public void getValuesFromModel(ArrayList<AbstractObjectsModel> objectsModel,
            int width, int height) {
        for (AbstractObjectsModel objectModel : objectsModel) {
            for (AbstractObjectView objectView : objectsView) { 
                objectView.getValuesFromModel(objectModel, width, height);
            }
        }
    }

    /**
     * Adds an objectView to the array list of objectsViews.
     * 
     * @param v.
     */
    public void addObjectView(AbstractObjectView[] v) {
        for (AbstractObjectView view : v) {
            objectsView.add(view);
        }
    }

    /**
     * Calls display() for each objectView.
     * 
     */
    public void objectsDisplay() {
        for (AbstractObjectView objectView : objectsView) {
            objectView.display(gc);
        }
    }    
    
    /**
     * Updates the view.
     * 
     * @param m.
     * 
     */
    public void update(FieldModel m) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, width, height);
        notifyModel(m);
        getValuesFromModel(m.getObjectsModel(), width, height);
        objectsDisplay();
    }
}
