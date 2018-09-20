package fr.univ_lyon1.info.m1.poneymon_fx.Controller;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;

public class Controller {
    FieldModel fieldModel;
    List<AbstractView> views = new ArrayList<AbstractView>();

    /**
     * Creates the controler.
     */
    public Controller() {
    }

    /**
     * Adds the view to the controller.
     * 
     * @param v.
     */
    public void addView(AbstractView v) {
        views.add(v);
    }
    
    /**
     * Updates views.
     * 
     */
    public void updateViews() {
        for (AbstractView view : views) {
            view.update();
        }
    }

    /**
     * Sets the model.
     * 
     * @param m.
     */
    public void setModel(FieldModel m) {
        fieldModel = m;
    }

    /**
     * Starts the controller.
     */
    public void start() {
        if (fieldModel != null) {
            fieldModel.startTimer(views);
        }
        for (AbstractView view : views) {
            view.show();
        }
    }
}
