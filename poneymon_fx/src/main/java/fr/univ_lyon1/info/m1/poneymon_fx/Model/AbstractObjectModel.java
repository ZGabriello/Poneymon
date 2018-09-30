package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public abstract class AbstractObjectModel {
    private final Random randomGenerator;
    private final String color;
    private final int row;
    private double x;
    
    /**
     * Abstract constructor. Param i is for the color and the row.
     * 
     * @param i.
     */
    public AbstractObjectModel(final int i) {
        randomGenerator = new Random();
        x = 0;
        row = i;
        // If number of poneys is above 5
        int j = (i < 5) ? i : (i - 5);
        color = App.colorMap[j];
    }

    public void checkInfo() {

    }
    
    public String[] check() {
        return null;
    }
    
    /**
     * Sets the double x.
     * 
     * @param d.
     */
    public void setX(final double d) {
        x = d;
    }
    
    /**
     * Gets the object's x position.
     * 
     * @return color.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the poney's row.
     * 
     * @return row.
     */
    public int getY() {
        return row;
    }
    
    /**
     * Gets the object's color.
     * 
     * @return color.
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Gets the poney's boolean isNian.
     * 
     * @return isNian.
     */
    public Random getRandom() {
        return randomGenerator;
    }
    
    /**
     * Resets the object.
     * 
     */
    public void reset() {
        
    }
}
