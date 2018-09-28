package fr.univ_lyon1.info.m1.poneymon_fx.View;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static Factory INSTANCE;
    List<AbstractObjectView> objectsView = new ArrayList<AbstractObjectView>();
    
    /**
     * Creates the Factory and its component.
     * 
     */
    private Factory() {
        for (AbstractObjectView poney : (new FactoryPoneyView()).createObjects()) {
            objectsView.add(poney);
        }
        
        for (AbstractObjectView coin : (new FactoryCoinView()).createObjects()) {
            objectsView.add(coin);
        }
    }
    
    /**
     * Gets the only Factory's instance.
     * 
     * @return INSTANCE.
     */
    public static Factory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Factory();
        }
        return INSTANCE;
    }
    
    /**
     * Returns the created objects.
     * 
     * @return objectsModel.
     */
    public List<AbstractObjectView> getObjects() {
        return objectsView;
    }
    
    
}
