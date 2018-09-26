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
    private static FieldModel INSTANCE;
    final StateContext sc = new StateContext();

    /**
     * Creates the FieldModel.
     * 
     * @param c.
     */
    private FieldModel() {
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
     * Gets the only FieldModel's instance.
     * 
     * @return INSTANCE.
     */
    public static FieldModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FieldModel();
        }
        return INSTANCE;
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
                    setPaused(true);
                }
                controller.runViews();
            }
        }.start();
    }
    
    /**
     * Calls step for each poney objects and checks if a poney has taken a coin.
     */
    public void step() {
        checkPoneyCoin();
        for (AbstractObjectsModel objectModel : objectsModel) {
            if (objectModel instanceof PoneyModel) {
                if (objectModel.getY() > 1) {
                    sc.nianIa((PoneyModel) objectModel);
                }
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
    public void setIsNianManually(final boolean b, final String color) {
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
    public void setPaused(final boolean b) {
        paused = b;
    }
    
    /**
     * Sets the controller.
     * 
     * @param c.
     */
    public void setController(final Controller c) {
        controller = c;
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
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Returns the color of the winner.
     * 
     * @return color.
     */
    public String colorWinner() {
        for (AbstractObjectsModel object : objectsModel) { 
            if (object instanceof PoneyModel) {
                if (((PoneyModel) object).getIsWinner()) {
                    String winner = "The " + object.getColor() + " poney won. ";
                    return winner;
                }
            }
        }
        return null;
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
    public String[] checkInformations(final String color) {
        for (int i = 0; i < objectsModel.size(); i++) {
            if (objectsModel.get(i).getColor() == color) {
                return objectsModel.get(i).check();
            }
        }
        return null;
    }
    
    /**
     * Restarts the game.
     */
    public void restart() {
        for (AbstractObjectsModel object : objectsModel) {
            object.reset();
        }
        setPaused(false);
    }
}
