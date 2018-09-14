package fr.univ_lyon1.info.m1.poneymon_fx.Controler;

import java.util.ArrayList;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;

public class Controler {
    FieldModel fieldModel;
    JfxView jfxView;

    // TODO faire liste de vues
    ArrayList<AbstractView> abstractViews = new ArrayList<AbstractView>();

    /**
     * Creates the controler.
     */
    public Controler() {

    }

    /**
     * Adds the view to the controler.
     */
    public void addView(JfxView v) {
        this.jfxView = v;
    }

    /**
     * Sets the model.
     * 
     * @param FieldModel.
     */
    public void setModel(FieldModel m) {
        this.fieldModel = m;
    }

    /**
     * Calls notifyFieldView().
     */
    public void notifyView() {
        jfxView.notifyFieldView();
    }

    /**
     * Starts the timer.
     */
    public void startTimer() {
        fieldModel.step();
        jfxView.display();
        jfxView.show();
    }
}
