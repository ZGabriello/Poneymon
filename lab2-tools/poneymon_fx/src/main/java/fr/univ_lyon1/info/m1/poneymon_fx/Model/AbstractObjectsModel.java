package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

public abstract class AbstractObjectsModel {
    String color;
    double x;
    int y;
    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };
    Random randomGenerator = new Random();
    String type;
    boolean visible;
    boolean isNian;
    boolean hasUsedNian;
    boolean isWinner;
    double traveledDistance;
    
    public AbstractObjectsModel() {
        
    }
    
    /**
     * Abstract constructor.
     * 
     * @param i.
     */
    public AbstractObjectsModel(int i) {
        x = 0;
        y = i;
        color = colorMap[i];
        isNian = false;
        hasUsedNian = false;
        traveledDistance = 0;
    }
    
    public void step() {

    }

    public void check() {

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
     * Sets the boolean isNian (for a user action).
     * 
     * @param b.
     */
    public void setNianManually(boolean b) {
        if (!hasUsedNian) {
            isNian = b;
            hasUsedNian = true;
        }
    }
    
    /**
     * Sets the boolean isNian (for the coin).
     * 
     * @param b.
     */
    public void setNian(boolean b) {
        isNian = b;
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
     * Gets the object's type.
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
     * Returns the boolean visible.
     * 
     * @return visible.
     */
    public boolean getVisible() {
        return visible;
    }
    
    /**
     * Gets the poney's boolean isNian.
     * 
     * @return isNian.
     */
    public boolean getIsNian() {
        return isNian;
    }
    
    /**
     * Gets the poney's boolean isWinner.
     * 
     * @return isWinner.
     */
    public boolean getIsWinner() {
        return isWinner;
    }
    
    /**
     * Gets the poney's boolean isNian.
     * 
     * @return isNian.
     */
    public double getTraveledDistance() {
        return traveledDistance;
    }
    
    /**
     * Resets parameters.
     * 
     */
    public void reset() {
    }
}
