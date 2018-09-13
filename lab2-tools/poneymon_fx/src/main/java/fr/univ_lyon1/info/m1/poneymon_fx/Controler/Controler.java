package fr.univ_lyon1.info.m1.poneymon_fx.Controler;
import java.util.ArrayList;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.*;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;

public class Controler {
	FieldModel fieldModel;
	JfxView jfxView;
	
	//TODO faire liste de vues
	ArrayList<AbstractView> abstractViews = new ArrayList<AbstractView>();
	
	public Controler() {
		
	}
	
	public void addView(JfxView v) {
		this.jfxView = v;
	}

	public void setModel(FieldModel m) {
		this.fieldModel = m;	
	}
	
	public void notifyView() {
		jfxView.notifyFieldView();
	}

	public void startTimer() {
		fieldModel.step();
    	jfxView.display(); 
    	jfxView.show();
	}
}
