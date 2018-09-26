package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public final class PoneyModel extends AbstractObjectsModel {
    private final double low = 0.002; //Arbitrary values for random speed.
    private final double high = 0.004;
    private int lap;
    private double speed;
    private boolean canChange; //So it doubles the speed only one time
    private boolean isNian;
    private boolean hasUsedNian;
    private boolean isWinner;
    private double traveledDistance;
    private int victories = 0;

    /**
     * Create poney's model.
     * 
     * @param i.
     */
    public PoneyModel(final int i) {
        super(i, "poney");
        speed = getRandom().nextFloat() * (high - low) + low;
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
        setX(getX() + speed);
        traveledDistance -= speed; // For the treemap (ascending order)
        if (getX() > 1) {
            setX(0);
            lap++;
            if (lap == App.NB_TOURS) {
                victories++;
            }
            speed = getRandom().nextFloat() * (high - low) + low;
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
    public String[] check() {
        String[] info = new String[10];
        info[0] = "Poney's color : " + getColor();
        info[1] = "speed : " + speed;
        info[2] = "is nian : " + isNian;
        info[3] = "has used nian : " + hasUsedNian;
        info[4] = "is the winner : " + isWinner;
        info[5] = "traveled distance : " + traveledDistance * (-1);
        info[6] = "laps : " + lap;
        info[7] = "x position : " + getX();
        info[8] = "y position : " + getY();
        info[9] = "victories : " + victories;
        return info;
    }

    /**
     * Returns the poney's distance with another poney.
     * 
     * @param poney.
     * @return progression.
     */
    public double distance(final PoneyModel poney) {
        return getX() - poney.getX();
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
    public void setNianManually(final boolean b) {
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
    public void setNian(final boolean b) {
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
    
    /**
     * Gets number of done lap.
     * 
     * @return lap.
     */
    public int getLap() {
        return lap;
    }
    
    /**
     * Resets the poney.
     * 
     */
    public void reset() {
        setX(0);
        speed = getRandom().nextFloat() * (high - low) + low;
        lap = 0;
        isWinner = false;
        canChange = true;
        isNian = false;
        hasUsedNian = false;
        traveledDistance = 0;
    }
    
    
}
