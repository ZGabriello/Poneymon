package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class FieldModel {
	
	PoneyModel[] poneysModel;	
	String[] colorMap =
	        new String[] {"blue", "green", "orange", "purple", "yellow"};
	
	int nbPoneys;
		
	public FieldModel(int i) {
		nbPoneys = i;
		poneysModel = new PoneyModel[i];
		for (int j = 0; j < nbPoneys; j++) {
			poneysModel[j] = new PoneyModel(colorMap[j], j);			
		}						
	}

	public void step() {
		for (int i = 0; i < poneysModel.length; i++) {
			poneysModel[i].step();						
		}		
	}
	
	public FieldModel getModel(){
		return this;
	}
	
	public int getPoneysNb() {
		return nbPoneys;
	}
	
	public PoneyModel[] getPoneysModel() {
		return this.poneysModel;
	}
}
