package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class FactoryCoinView implements FactoryAbstractObjectsView {

    /**
     * Crée une liste d'objets de pièces.
     * 
     */
    public AbstractObjectView[] createObjects() {
        AbstractObjectView[] coinsModel = new CoinView[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            int j = (i < 5) ? i : (i - 5);
            coinsModel[i] = new CoinView(App.colorMap[j]);
        }
        return coinsModel;
    }

}
