package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import javafx.animation.AnimationTimer;

import java.util.Set;
import java.util.TreeMap;

public final class Model {
    private static Model INSTANCE;
    private Factory factory;
    private List<AbstractObjectModel> objectsModel;
    private Controller controller;
    private boolean paused;
    private StateContext[] sc;
    private String colorWinner;

    /**
     * Creates the FieldModel.
     * 
     * @param c.
     */
    private Model() {
        objectsModel = new ArrayList<AbstractObjectModel>();
        factory = Factory.getInstance();
        sc = new StateContext[App.NB_PONEYS];
        for (int i = 0; i < sc.length; i++) {
            sc[i] = new StateContext();
        }
       
        objectsModel = factory.getObjects();
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
    
    
    /*The steps execute sequentially. This is a business requirement, 
     * this should be part of model. */
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
        for (int i = 0; i < App.NB_PONEYS; i++) {
            //Get the current poney object
            PoneyModel p = (PoneyModel) objectsModel.get(i);
            if (p.getY() > 1) {
                //Let the IA do its job for the three last poneys
                sc[p.getY()].nianIa(p);
            }
            p.step(); 
        }
    }

    /**
     * Sets the poney of the color given isNian field to true or false (for a user action).
     * 
     * @param b.
     * @param index.
     */
    public void setIsNianManually(final boolean b, final int index) {
        ((PoneyModel) objectsModel.get(index)).setNianManually(b);
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
     * Returns the color of the winner.
     * 
     * @return color.
     */
    public String getWinner() {
        String winner = "The " + colorWinner + " poney won. ";
        return winner;
    }

    /**
     * Checks the poneys' rank. Returns a String array.
     * 
     * @return scores.
     */
    public String[] getRank() {
        Map<Double, String> tmap = new TreeMap<Double, String>();
        for (int i = 0; i < App.NB_PONEYS; i++) {
            PoneyModel p = (PoneyModel) objectsModel.get(i);
            tmap.put(p.getTraveledDistance(), p.getColor());
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
     * 
     * @param i the index.
     * @return string String[].
     */
    public String[] checkInformations(final int i) {
        return objectsModel.get(i).check();
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
    
    
    /*      GAME LOGIC      */
    
    /**
     * Checks if a poney has taken a coin or if a coin needs to be reset.
     */
    public void checkPoneyCoin() {
        for (int i = 0; i < App.NB_PONEYS; i++) {
            PoneyModel p = (PoneyModel) objectsModel.get(i);
            for (int j = App.NB_PONEYS; j < (App.NB_PONEYS * 2); j++) {
                CoinModel c = (CoinModel) objectsModel.get(j);
                if (p.getY() == c.getY()) {
                    if (p.getX() == 0) { 
                        c.reset();
                    }
                    //If the poney is above the coin.
                    if (p.getX() > c.getX() - 0.07 
                            && c.getVisible()) {
                        p.setNian(true);
                        c.setVisible(false);
                    }
                }
            }
        }
    }
    
    /**
     * Checks if there's a winner.
     * 
     * @return true or false.
     */
    public boolean checkWinner() {
        for (int i = 0; i < App.NB_PONEYS; i++) {
            if (((PoneyModel) objectsModel.get(i)).getIsWinner()) {
                colorWinner = objectsModel.get(i).getColor();
                return true;
            }
        }
        return false;
    }
    
}
