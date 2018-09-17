package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;
import javafx.animation.AnimationTimer;

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
     */
    public FieldModel() {
        poneysModel = new PoneyModel[App.NB_PONEYS];
        coinsModel = new CoinModel[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            coinsModel[i] = new CoinModel(i);
            poneysModel[i] = new PoneyModel(i);
        }
        addObject(poneysModel);
        addObject(coinsModel);
    }
    
    /**
     * Starts the timer.
     * 
     * @param views.
     */
    public void startTimer(final ArrayList<AbstractView> views) {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (!getPaused()) {
                    step();
                }
                for (AbstractView view : views) {
                    view.update();
                }
                if (checkWinner()) {
                    this.stop();
                }
            }
        }.start(); // On lance la boucle de rafraichissement
    }

    /**
     * Calls step() for each poneys and check the rules for the coins.
     */
    public void step() {
        checkPoneyCoin();
        for (AbstractObjectsModel objectModel : objectsModel) {
            objectModel.step();
        }
    }
    
    /**
     * Checks if a poney has taken a coin.
     */
    public void checkPoneyCoin() {
        for (int i = 0; i < poneysModel.length; i++) {
            // New chance of coin appearing if the poney starts a new lap
            if (poneysModel[i].progression == 0) {
                coinsModel[i] = new CoinModel(i);
            }
            if (poneysModel[i].progression > coinsModel[i].getX() && coinsModel[i].getVisible()) {
                coinsModel[i].setVisible(false);
                poneysModel[i].setNian(true);
            }
        }
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
     * Gets the number of poneys.
     * 
     * @return poneysModel.length.
     */
    public int getPoneysNb() {
        return poneysModel.length;
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
     * Checks the poneys' rank. Returns a String array.
     * 
     * @return scores.
     */
    public String[] getRank() {
        TreeMap<Double, String> tmap = new TreeMap<Double, String>();

        for (int i = 0; i < poneysModel.length; i++) {
            tmap.put(poneysModel[i].getTraveledDistance(), poneysModel[i].getColor());
        }

        int i = 1; // For rank displaying, must be from one to five so it's readable.
        int j = 0; // For scores incrementing, must be from zero to 4.
        Set<Entry<Double, String>> set = tmap.entrySet();
        Iterator<Entry<Double, String>> iterator = set.iterator();
        String[] scores = new String[poneysModel.length];
        while (iterator.hasNext()) {
            Entry<Double, String> mentry = iterator.next();
            scores[j] = new String("The " + mentry.getValue() + " poney's rank is " + i);
            // System.out.println("The " + mentry.getValue() + " poney's rank is " + i);
            i++;
            j++;
        }
        return scores;
    }
    
    /**
     * Checks all objects' informations for the model.
     */
    public void checkInformations() {
        for (int i = 0; i < objectsModel.size(); i++) {
            objectsModel.get(i).check();
        }
    }
}
