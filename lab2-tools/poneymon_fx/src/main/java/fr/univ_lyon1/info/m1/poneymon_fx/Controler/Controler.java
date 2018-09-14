package fr.univ_lyon1.info.m1.poneymon_fx.Controler;

import java.util.ArrayList;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;

public class Controler {
    FieldModel fieldModel;
    ArrayList<JfxView> jfxViews = new ArrayList<JfxView>();

    /**
     * Creates the controler.
     */
    public Controler() {
    }

    /**
     * Adds the view to the controler.
     */
    public void addView(JfxView v) {
        this.jfxViews.add(v);
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
    /*public void notifyView() {
        for (int i = 0; i < nbViews; i++) {
            jfxView[i].notifyFieldView();            
        }        
    }*/
    
    /**
     * Calls notifyFieldModel().
     */
    public void notifyModel() {
        for (int i = 0; i < jfxViews.size(); i++) {
            jfxViews.get(i).notifyFieldModel(fieldModel);            
        }        
    } 

    /**
     * Starts the timer.
     */
    public void startTimer() {
        if (fieldModel != null) {
            fieldModel.step();
        }        
        for (int i = 0; i < jfxViews.size(); i++) {
            jfxViews.get(i).display();
            jfxViews.get(i).show();
        }
    }
}
