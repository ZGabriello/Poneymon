package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.AbstractObjectModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.Factory;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public final class JfxCanvasView extends Canvas {

    private List<String> inputs = new ArrayList<String>();
    private List<AbstractObjectView> objectsView = new ArrayList<AbstractObjectView>();
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
    public JfxCanvasView(final int w, final int h) {
        super(w, h);
        width = w;
        height = h;

        gc = this.getGraphicsContext2D();
        
        objectsView = Factory.getInstance().getObjects();
        
        setInputs();
    }
    
    /**
     * Fills canvas, notifies the model, gets values from model, and displays
     * objects.
     * 
     * @param m.
     * 
     */
    public void run(final Model m) {
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
        /*for (AbstractObjectModel objectModel : m.getObjectsModel()) {
            for (AbstractObjectView objectView : objectsView) {
                objectView.getValuesFromModel(objectModel, width, height);
            }
        }*/
        List<AbstractObjectModel> objectsModel = m.getObjectsModel();
        for (int i = 0; i < 10; i++) {
            objectsView.get(i).getValuesFromModel(objectsModel.get(i), width, height);
        }
        
        //Display all objects.
        for (AbstractObjectView objectView : objectsView) {
            objectView.display(gc, width, height);
        }
    }
    
    /**
     * Sets input for keyboard inputs.
     * 
     * 
     */
    public void setInputs() {
        this.setFocusTraversable(true);
        
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
     * Get List objectView.
     * 
     * @return objectView.
     */
    public List<AbstractObjectView> getObjectView() {
        return objectsView;
    }
}
