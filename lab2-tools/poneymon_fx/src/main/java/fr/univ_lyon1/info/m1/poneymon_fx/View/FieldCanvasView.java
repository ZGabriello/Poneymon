package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectsModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public final class FieldCanvasView extends Canvas {

    List<String> inputs = new ArrayList<String>();
    List<AbstractObjectView> objectsView = new ArrayList<AbstractObjectView>();
    HashMap<String, String> keyMap = new HashMap<String, String>();
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
        
        PoneyView[] poneysView = new PoneyView[App.NB_PONEYS];
        CoinView[] coinsView = new CoinView[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            poneysView[i] = new PoneyView(App.colorMap[i]);
            coinsView[i] = new CoinView(App.colorMap[i]);
        }
        //Add all objects view to the list objectsView.
        for (AbstractObjectView view : poneysView) {
            objectsView.add(view);
        }
        for (AbstractObjectView view : coinsView) {
            objectsView.add(view);
        }

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
        
        //Notify model if a key is pressed.
        if (!inputs.isEmpty()) {
            for (String input : inputs) {
                m.setIsNianManually(true, keyMap.get(input));
            }
        }
        
        //Get values from model.
        for (AbstractObjectsModel objectModel : m.getObjectsModel()) {
            for (AbstractObjectView objectView : objectsView) { 
                objectView.getValuesFromModel(objectModel, width, height);
                
            }
        }
        
        //Display all objects.
        for (AbstractObjectView objectView : objectsView) {
            objectView.display(gc);
        }
    }
}
