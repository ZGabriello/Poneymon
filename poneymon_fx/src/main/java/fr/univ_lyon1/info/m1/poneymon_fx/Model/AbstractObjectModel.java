package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public abstract class AbstractObjectModel {
    private final Random randomGenerator;
    private final String color;
    private final String type;
    private final int y;
    private double x;
    
    /**
     * Abstract constructor. Param i is for the color and the row.
     * 
     * @param i.
     */
    public AbstractObjectModel(final int i, final String t) {
        randomGenerator = new Random();
        type = t;
        x = 0;
        y = i;
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
        return y;
    }
    
    /**
     * Gets the object's type (poney or coin for the moment).
     * 
     * @return row.
     */
    public String getType() {
        return type;
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
