package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public final class PoneyModel extends AbstractObjectsModel {
    final double low = 0.001; //Arbitrary values for random speed.
    final double high = 0.002;
    int lap;
    double speed;
    boolean canChange;
    boolean isNian;
    boolean hasUsedNian;
    boolean isWinner;
    double traveledDistance;

    /**
     * Create poney's model.
     * 
     * @param i.
     */
    public PoneyModel(int i) {
        super(i);
        type = "poney";
        speed = randomGenerator.nextFloat() * (high - low) + low;
        lap = 0;
        canChange = true;
        isNian = false;
        hasUsedNian = false;
        traveledDistance = 0;
    }

    /**
     * Does the every frame game logic for the poney.
     */
    public void step() {
        if (isNian && canChange) {
            speed += speed;
            canChange = false;
        }
        x += speed;
        traveledDistance -= speed; // For the treemap (ascending order)
        if (x > 1) {
            x = 0;
            lap++;
            speed = randomGenerator.nextFloat() * (high - low) + low;
            isNian = false;
            canChange = true;
            if (lap == App.NB_TOURS) {
                isWinner = true;
            }
        }
    }

    /**
     * Checks if the poney has won.
     * 
     * @return true or false.
     */
    boolean win() {
        return (lap == App.NB_TOURS);
    }

    /**
     * Checks the poney's information.
     */
    public void check() {
        System.out.println("Poney color : " + color + " row : " + y + " progression : "
                + x + " lap : " + lap + " isNian : " + isNian + " speed : " + speed);
    }

    /**
     * Returns the poney's distance with another poney.
     * 
     * @param poney.
     * @return progression.
     */
    public double distance(PoneyModel poney) {
        return x - poney.x;
    }
    
    
    /**
     * Sets the int lap.
     * 
     * @param a.
     */
    public void setLap(int a) {
        lap = a;
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
     * Gets speed.
     * 
     * @return speed.
     */
    public double getSpeed() {
        return speed;
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
    
    
}
