package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public abstract class AbstractObjectsModel {
    String color;
    double x;
    int y;
    Random randomGenerator = new Random();
    String type;
    
    public AbstractObjectsModel() {
        
    }
    
    /**
     * Abstract constructor. Param i is for the color and the row.
     * 
     * @param i.
     */
    public AbstractObjectsModel(int i) {
        x = 0;
        y = i;
        color = App.colorMap[i];
    }
    
    public void step() {

    }

    public void check() {

    }
    
    /**
     * Sets the double x.
     * 
     * @param d.
     */
    public void setX(double d) {
        x = d;
    }
    
    /**
     * Sets the int y.
     * 
     * @param d.
     */
    public void setY(int d) {
        y = d;
    }
    
    /**
     * Sets the boolean visible.
     * 
     * @param b.
     */
    public void setVisible(boolean b) {
        
    }
    
    /**
     * Sets the boolean isNian (with a user action).
     * 
     * @param b.
     */
    public void setNianManually(boolean b) {

    }
    
    /**
     * Sets the boolean isNian (with a coin).
     * 
     * @param b.
     */
    public void setNian(boolean b) {

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
     * Returns the boolean visible.
     * 
     * @return visible.
     */
    public boolean getVisible() {
        return true; //TODO return true ?
    }
    
    /**
     * Gets the poney's boolean isNian.
     * 
     * @return isNian.
     */
    public boolean getIsNian() {
        return true; //TODO return true ?
    }
    
    /**
     * Gets the poney's boolean isWinner.
     * 
     * @return isWinner.
     */
    public boolean getIsWinner() {
        return false; //TODO faire ça ?
    }
    
    /**
     * Gets the poney's boolean isNian.
     * 
     * @return isNian.
     */
    public double getTraveledDistance() {
        return 0; //TODO ???
    }
    
    /**
     * Resets parameters.
     * 
     */
    public void reset() {
    }
}
