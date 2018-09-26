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

    private List<String> inputs = new ArrayList<String>();
    private List<AbstractObjectsView> objectsView = new ArrayList<AbstractObjectsView>();
    private HashMap<String, String> keyMap = new HashMap<String, String>();
    private final GraphicsContext gc;
    private final int width;
    private final int height;

    /**
     * Creates FieldView.
     * 
     * @param w.
     * @param h.
     */
    public FieldCanvasView(final int w, final int h) {
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
        for (AbstractObjectsView view : poneysView) {
            objectsView.add(view);
        }
        for (AbstractObjectsView view : coinsView) {
            objectsView.add(view);
        }

        //Add a string to input if a key is presssed.
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
    }
    
    /**
     * Fills canvas, notifies the model, gets values from model, and displays
     * objects.
     * 
     * @param m.
     * 
     */
    public void run(final FieldModel m) {
        //Fill the canvas.
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
            for (AbstractObjectsView objectView : objectsView) { 
                objectView.getValuesFromModel(objectModel, width, height);
                
            }
        }
        
        //Display all objects.
        for (AbstractObjectsView objectView : objectsView) {
            objectView.display(gc, width, height);
        }
    }
}
