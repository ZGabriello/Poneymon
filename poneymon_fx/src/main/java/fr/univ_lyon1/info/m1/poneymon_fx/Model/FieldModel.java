package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import javafx.animation.AnimationTimer;

import java.util.Set;
import java.util.TreeMap;

public final class FieldModel {
    private List<AbstractObjectsModel> objectsModel = new ArrayList<AbstractObjectsModel>();
    private Controller controller;
    private boolean paused;

    /**
     * Creates the FieldModel.
     * 
     * @param c.
     */
    public FieldModel(Controller c) {
        controller = c;
        AbstractObjectsModel[] poneysModel = new PoneyModel[App.NB_PONEYS];
        AbstractObjectsModel[] coinsModel = new CoinModel[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            coinsModel[i] = new CoinModel(i);
            poneysModel[i] = new PoneyModel(i);
        }
        for (AbstractObjectsModel object : poneysModel) {
            objectsModel.add(object);
        }
        for (AbstractObjectsModel object : coinsModel) {
            objectsModel.add(object);
        }
    }
    
    /**
     * Starts the timer.
     * 
     */
    public void startTimer() {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (!getPaused()) {
                    step();
                }
                if (checkWinner()) {
                    this.stop();
                }
                controller.runViews();
            }
        }.start();
    }
    
    /**
     * Calls step for each objects and checks if a poney has taken a coin.
     */
    public void step() {
        checkPoneyCoin();
        for (AbstractObjectsModel objectModel : objectsModel) {
            if (objectModel instanceof PoneyModel) {
                ((PoneyModel) objectModel).step();
            }
        }
    }
    
    /**
     * Checks if a poney has taken a coin or if a coin needs to be reset.
     */
    public void checkPoneyCoin() {
        for (AbstractObjectsModel object : objectsModel) {
            if (object instanceof PoneyModel) {
                for (AbstractObjectsModel objectBis : objectsModel) { 
                    if (objectBis instanceof CoinModel
                            && objectBis.getColor() == object.getColor()) {
                        if (object.getX() == 0) { 
                            ((CoinModel) objectBis).reset();
                        }
                        if (object.getX() > objectBis.getX() - 0.1 
                                && ((CoinModel) objectBis).getVisible()) {
                            ((PoneyModel) object).setNian(true);
                            ((CoinModel) objectBis).setVisible(false);
                        }
                    }       
                }
            }
        }
    }

    /**
     * Sets the poney isNian field to true or false (for a user action).
     * 
     * @param b.
     * @param color.
     */
    public void setIsNianManually(boolean b, String color) {
        for (AbstractObjectsModel object : objectsModel) { 
            if (object instanceof PoneyModel && object.getColor() == color) {
                ((PoneyModel) object).setNianManually(b);
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
     * Gets the model objects' list.
     * 
     * @return objectsModel.
     */
    public List<AbstractObjectsModel> getObjectsModel() {
        return objectsModel;
    }

    /**
     * Checks if there's a winner.
     * 
     * @return true or false.
     */
    public boolean checkWinner() {
        for (AbstractObjectsModel object : objectsModel) { 
            if (object instanceof PoneyModel) {
                if (((PoneyModel) object).getIsWinner()) {
                    System.out.println(object.getColor() + " poney won. ");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the poneys' rank. Returns a String array.
     * 
     * @return scores.
     */
    public String[] getRank() {
        TreeMap<Double, String> tmap = new TreeMap<Double, String>();

        for (AbstractObjectsModel object : objectsModel) { 
            if (object instanceof PoneyModel) {
                tmap.put(((PoneyModel) object).getTraveledDistance(), object.getColor());
            }
        }
        int i = 1; // For rank displaying, must be from one to five so it's readable.
        int j = 0; // For scores incrementing, must be from zero to 4.
        Set<Entry<Double, String>> set = tmap.entrySet();
        Iterator<Entry<Double, String>> iterator = set.iterator();
        String[] scores = new String[App.NB_PONEYS];
        while (iterator.hasNext()) {
            Entry<Double, String> mentry = iterator.next();
            scores[j] = new String("The " + mentry.getValue() + " poney's rank is " + i);
            i++;
            j++;
        }
        return scores;
    }
    
    /**
     * Checks all objects' informations for the model.
     */
    public String[] checkInformations(String color) {
        for (int i = 0; i < objectsModel.size(); i++) {
            if (objectsModel.get(i).getColor() == color) {
                return objectsModel.get(i).check();
            }
        }
        return null;
    }
}