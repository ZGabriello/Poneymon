package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static Factory INSTANCE;
    List<AbstractObjectModel> objectsModel = new ArrayList<AbstractObjectModel>();
    FactoryAbstractObjectsModel factoryPoney;
    FactoryAbstractObjectsModel factoryCoin;
    
    /**
     * Creates the Factory and its component.
     * 
     */
    private Factory() {
        factoryPoney = new FactoryPoneyModel();
        factoryCoin = new FactoryCoinModel();
        for (AbstractObjectModel poney : factoryPoney.createObjects()) {
            objectsModel.add(poney);
        }
        
        for (AbstractObjectModel coin : factoryCoin.createObjects()) {
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
