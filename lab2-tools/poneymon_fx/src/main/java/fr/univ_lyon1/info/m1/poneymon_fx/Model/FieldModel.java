package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FieldModel {
    ArrayList<AbstractObjectsModel> objectsModel = new ArrayList<AbstractObjectsModel>();
    PoneyModel[] poneysModel;
    CoinModel[] coinsModel;    
    boolean paused;

    /**
     * Creates the FieldModel.
     * 
     * @param nbPoneys number of poneys.
     */
    public FieldModel(int nbPoneys) {
        poneysModel = new PoneyModel[nbPoneys];
        coinsModel = new CoinModel[nbPoneys];
        for (int i = 0; i < nbPoneys; i++) {            
            coinsModel[i] = new CoinModel(i);
            poneysModel[i] = new PoneyModel(i);
        }
        addObject(poneysModel);
        addObject(coinsModel);
    }

    /**
     * Calls step() for each poneys.
     */
    public void step() {  
        //checkPoneyCoin();
        for (int i = 0; i < objectsModel.size(); i++) {
            objectsModel.get(i).step();
        }
    }

    /**
     * Gets the number of poneys.
     * 
     * @return poneysModel.length.
     */
    public int getPoneysNb() {
        return poneysModel.length;
    }

    /**
     * Sets the poney isNian field to true or false.
     * 
     * @param b.
     * @param color.
     */
    public void setIsNianManually(boolean b, String color) {
        for (int i = 0; i < poneysModel.length; i++) {
            if (poneysModel[i].getColor() == color) {
                poneysModel[i].setNianManually(b);
            }
        }
    }

    /**
     * Sets the boolean paused.
     * 
     * @param b.
     */
    public void setPaused(boolean b) {
        paused = b;
    }

    /**
     * Gets the boolean paused.
     * 
     * @return paused.
     */
    public boolean getPaused() {
        return paused;
    }

    /**
     * Gets the poneys' array.
     * 
     * @return poneysModel.
     */
    public PoneyModel[] getPoneysModel() {
        return poneysModel;
    }

    /**
     * Gets the coins' array.
     * 
     * @return coinsModel.
     */
    public CoinModel[] getCoinsModel() {
        return coinsModel;
    }

    /**
     * Checks all objects' informations for the model.
     */
    public void check() {
        for (int i = 0; i < objectsModel.size(); i++) {
            objectsModel.get(i).check();
        }
    }
    
    /**
     * Checks if there's a winner.
     * 
     * @return true or false.
     */
    public boolean checkWinner() {
        for (int i = 0; i < poneysModel.length; i++) {
            if (poneysModel[i].getIsWinner()) {
                System.out.println(poneysModel[i].getColor() + " poney won. ");
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an objectModel to the objectsModel list.
     * 
     * @param o.
     */
    public void addObject(AbstractObjectsModel[] o) {
        for (int i = 0; i < o.length; i++) {
            objectsModel.add(o[i]);
        }
    }
    
    /**
     * Checks if a poney has taken a coin.
     */
    public void checkPoneyCoin() {
        for (int i = 0; i < poneysModel.length; i++) {
            //System.out.println("progression poney " + i + poneysModel[i].progression);
            //System.out.println("x pièce " + i + coinsModel[i].getX());
            if (poneysModel[i].progression > coinsModel[i].getX()) {
                System.out.println(i);
                coinsModel[i].setVisible(false);
            }            
        }
    }
    
    /**
     * Checks the poney's color rank for the current lap.
     * 
     * @param color.
     */
    public int checkRankLap(String color) {
        ArrayList<Double> ranking = new ArrayList<Double>();
        for (int i = 0; i < poneysModel.length; i++) {
            if (poneysModel[i].getColor() == color) {
                for (int j = 0; j < poneysModel.length; j++) {
                    if (i != j) {
                        ranking.add(poneysModel[i].distance(poneysModel[j]));
                    }
                }
            }
        }
        // The number of positive distances indicates
        // the poney's ranking
        int positiveNumbers = 0;
        int rank = 0;
        for (int i = 0; i < ranking.size(); i++) {
            if (ranking.get(i) > 0) {
                positiveNumbers++;
            }
        }
        if (positiveNumbers == 4) {
            rank = 1;
        }
        if (positiveNumbers == 3) {
            rank = 2;
        }
        if (positiveNumbers == 2) {
            rank = 3;
        }
        if (positiveNumbers == 1) {
            rank = 4;
        }
        if (positiveNumbers == 0) {
            rank = 5;
        }
        //System.out.println(rank);
        return rank;
    }
    
    public String[] checkRank() {
        TreeMap<Double, String> tmap = new TreeMap<Double, String>();
        
        for (int i = 0; i < poneysModel.length; i++) {
            tmap.put(poneysModel[i].getTraveledDistance(), poneysModel[i].getColor());
        }        
        
        int i = 1;
        int j = 0;
        Set<Entry<Double, String>> set = tmap.entrySet();
        Iterator<Entry<Double, String>> iterator = set.iterator();
        String[] scores = new String[poneysModel.length];
        while(iterator.hasNext()) {
           Entry<Double, String> mentry = iterator.next();
           scores[j] = new String( "The " + mentry.getValue() + " poney's rank is " + i);
           //System.out.println("The " + mentry.getValue() + " poney's rank is " + i);
           i++;   
           j++;
        }
        return scores;
    }
}
