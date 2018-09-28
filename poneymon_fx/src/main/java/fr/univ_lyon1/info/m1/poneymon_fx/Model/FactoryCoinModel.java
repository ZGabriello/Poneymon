package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class FactoryCoinModel implements FactoryAbstractObjectsModel {

    /**
     * Crée une liste d'objets de pièces.
     * 
     */
    public AbstractObjectModel[] createObjects() {
        AbstractObjectModel[] coinsModel = new CoinModel[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            coinsModel[i] = new CoinModel(i);
        }
        return coinsModel;
    }

}
