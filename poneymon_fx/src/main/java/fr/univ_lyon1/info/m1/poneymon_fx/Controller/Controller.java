package fr.univ_lyon1.info.m1.poneymon_fx.Controller;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;

public final class Controller {
    private Model fieldModel;
    private List<AbstractView> views = new ArrayList<AbstractView>();
    private static Controller INSTANCE;

    /**
     * Creates the controler.
     */
    private Controller() {
    }
    
    /**
     * Gets the only Controller's instance.
     * 
     * @return INSTANCE.
     */
    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    /**
     * Adds a view to the controller.
     * 
     * @param v.
     */
    public void addView(final AbstractView v) {
        views.add(v);
    }

    /**
     * Sets the model.
     * 
     * @param m.
     */
    public void setModel(final Model m) {
        fieldModel = m;
    }
    
    /**
     * Launch all views' functions "runCanvas".
     * 
     */
    public void runViews() {
        for (AbstractView view : views) {
            view.runCanvas();
        }
    }

    /**
     * Starts the model's timer (which includes all the game logic), 
     * and then shows all the views.
     */
    public void run() {
        if (fieldModel != null) {
            fieldModel.startTimer();
        }
        for (AbstractView view : views) {
            view.show();
        }
    }
}
