package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

public class CoinModel extends AbstractObjectsModel {
    Random randomGenerator = new Random();
    final int row;
    final double y;
    final double low = 0.3;
    final double high = 0.8;
    double x;
    boolean visible;


    /**
     * Creates the CoinModel.
     * 
     * @param i.
     */
    public CoinModel(int i) {
        y = i;
        x = randomGenerator.nextFloat() * (high - low) + low;
        row = i;
        setVisible();
    }

    /**
     * Returns X.
     * 
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns Y.
     * 
     * @return y.
     */
    public double getY() {
        return y;
    }
    
    /**
     * Returns row.
     * 
     * @return row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Sets the boolean visible with a chance of 1/5.
     * 
     */
    public void setVisible() {
        int a = randomGenerator.nextInt(4);
        if (a == 0 /*|| a == 1 || a == 2 || a == 3 || a == 4*/) {
            visible = true;
        }
    }
    
    /**
     * Sets the boolean visible.
     * 
     * @param b.
     */
    public void setVisible(boolean b) {
        visible = b;
    }

    /**
     * Returns the boolean visible.
     * 
     * @return visible.
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * Checks the coin's information.
     */
    public void check() {
        System.out.println("Coin x : " + x + " y : " + y + " visible" + visible);
    }
}
