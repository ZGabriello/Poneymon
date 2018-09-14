package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class FieldModel {
    PoneyModel[] poneysModel;
    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };

    int nbPoneys;

    /**
     * Creates the FieldModel.
     * 
     * @param i number of poneys.
     */
    public FieldModel(int i) {
        nbPoneys = i;
        poneysModel = new PoneyModel[i];
        for (int j = 0; j < nbPoneys; j++) {
            poneysModel[j] = new PoneyModel(colorMap[j], j);
        }
    }

    /**
     * Calls step() for each poneys.
     */
    public void step() {
        for (int i = 0; i < poneysModel.length; i++) {
            poneysModel[i].step();
        }
    }

    /**
     * Gets the model.
     */
    public FieldModel getModel() {
        return this;
    }

    /**
     * Gets the number of poneys.
     */
    public int getPoneysNb() {
        return nbPoneys;
    }
    
    /**
     * Gets the number of poneys.
     */
    public void setIsNian(boolean b, String color) {
        for (int i = 0; i < poneysModel.length; i++) {
            if (poneysModel[i].getColor() == color) {
                poneysModel[i].setNian(b);
            }            
        }
    }       

    /**
     * Gets the poney's array.
     */
    public PoneyModel[] getPoneysModel() {
        return this.poneysModel;
    }
    
    /**
     * Checks poney's state.
     */
    public void check() {
        for (int i = 0; i < poneysModel.length; i++) {
            poneysModel[i].check();       
        }
    }
}
