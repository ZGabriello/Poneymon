package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class FactoryPoneyView implements FactoryAbstractObjectsView {

    /**
     * Crée une liste d'objets de poneys.
     * 
     */
    public AbstractObjectView[] createObjects() {
        AbstractObjectView[] poneysModel = new PoneyView[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            int j = (i < 5) ? i : (i - 5);
            poneysModel[i] = new PoneyView(App.colorMap[j]);
        }
        return poneysModel;
    }
}