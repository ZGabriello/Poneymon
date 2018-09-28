package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static Factory INSTANCE;
    List<AbstractObjectModel> objectsModel = new ArrayList<AbstractObjectModel>();
    
    /**
     * Creates the Factory and its component.
     * 
     */
    private Factory() {
        for (AbstractObjectModel poney : (new FactoryPoneyModel()).createObjects()) {
            objectsModel.add(poney);
        }
        
        for (AbstractObjectModel coin : (new FactoryCoinModel()).createObjects()) {
            objectsModel.add(coin);
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
    public List<AbstractObjectModel> getObjects() {
        return objectsModel;
    }
    
    
}
