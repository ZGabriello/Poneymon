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

public final class Model {
    private static Model INSTANCE;
    private List<AbstractObjectModel> objectsModel = new ArrayList<AbstractObjectModel>();
    private Controller controller;
    private boolean paused;
    private StateContext[] sc;

    /**
     * Creates the FieldModel.
     * 
     * @param c.
     */
    private Model() {
        sc = new StateContext[App.NB_PONEYS];
        for (int i = 0; i < sc.length; i++) {
            sc[i] = new StateContext();
        }
       
        objectsModel = Factory.getInstance().getObjects();
    }
    
    /**
     * Gets the only Model's instance.
     * 
     * @return INSTANCE.
     */
    public static Model getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Model();
        }
        return INSTANCE;
    }
    
    
    /*The steps execute sequentially.This is a business requirement. 
     * that manages 
     * this should be part of the business object model (Model). */
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
     * Calls step for each poney, including the check for coins and IA.
     */
    public void step() {
        checkPoneyCoin();
        for (AbstractObjectModel objectModel : objectsModel) {
            if (objectModel instanceof PoneyModel) {
                if (objectModel.getY() > 1) {
                    //Let the IA do its job for the three last poneys
                    sc[objectModel.getY()].nianIa((PoneyModel) objectModel);
                }
                ((PoneyModel) objectModel).step();
            }
        }
    }
    
    /**
     * Checks if a poney has taken a coin or if a coin needs to be reset.
     */
    public void checkPoneyCoin() {
        for (AbstractObjectModel poney : objectsModel) {
            if (poney instanceof PoneyModel) {
                for (AbstractObjectModel coin : objectsModel) { 
                    if (coin instanceof CoinModel
                            && coin.getColor() == poney.getColor()) {
                        //Reset the coin if the poney starts a new lap.
                        if (poney.getX() == 0) { 
                            ((CoinModel) coin).reset();
                        }
                        //If the poney is above the coin.
                        if (poney.getX() > coin.getX() - 0.07 
                                && ((CoinModel) coin).getVisible()) {
                            ((PoneyModel) poney).setNian(true);
                            ((CoinModel) coin).setVisible(false);
                        }
                    }       
                }
            }
        }
    }

    /**
     * Sets the poney of the color given isNian field to true or false (for a user action).
     * 
     * @param b.
     * @param color.
     */
    public void setIsNianManually(final boolean b, final String color) {
        for (AbstractObjectModel object : objectsModel) { 
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
    public List<AbstractObjectModel> getObjectsModel() {
        return objectsModel;
    }

    /**
     * Checks if there's a winner.
     * 
     * @return true or false.
     */
    public boolean checkWinner() {
        for (AbstractObjectModel object : objectsModel) { 
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
        for (AbstractObjectModel object : objectsModel) { 
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
        for (AbstractObjectModel object : objectsModel) { 
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
        for (AbstractObjectModel object : objectsModel) {
            if (object.getColor() == color) {
                return object.check();
            }
        }
        return null;
    }
    
    /**
     * Restarts the game.
     */
    public void restart() {
        for (int i = 0; i < sc.length; i++) {
            sc[i] = new StateContext();
        }
        for (AbstractObjectModel object : objectsModel) {
            object.reset();
        }
        setPaused(false);
    }
}
