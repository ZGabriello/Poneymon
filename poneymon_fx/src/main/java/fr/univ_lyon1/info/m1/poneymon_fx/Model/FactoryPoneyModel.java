package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class FactoryPoneyModel implements FactoryAbstractObjectsModel {

    /**
     * Crée une liste d'objets de poneys.
     * 
     */
    public AbstractObjectsModel[] createObjects() {
        AbstractObjectsModel[] poneysModel = new PoneyModel[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            poneysModel[i] = new PoneyModel(i);
        }
        return poneysModel;
    }
}
