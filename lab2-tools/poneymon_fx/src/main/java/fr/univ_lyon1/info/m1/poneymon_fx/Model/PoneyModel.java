package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class PoneyModel extends AbstractObjectsModel {
    Random randomGenerator = new Random();
    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };
    String poneyColor;
    final double low = 0.001; //Arbitrary values for random speed.
    final double high = 0.002;
    final double row;
    double progression;
    int lap;
    double speed;
    boolean isWinner;
    boolean isNian;
    boolean hasUsedNian;
    double traveledDistance;
    boolean canChange;

    /**
     * Create poney's model.
     * 
     * @param i.
     */
    public PoneyModel(int i) {
        speed = randomGenerator.nextFloat() * (high - low) + low;
        poneyColor = colorMap[i];
        row = i;
        progression = 0;
        lap = 0;
        isNian = false;
        hasUsedNian = false;
        traveledDistance = 0;
        canChange = true;
    }

    /**
     * Calls step() for this poney.
     */
    public void step() {
        if (isNian && canChange) {
            speed += speed;
            canChange = false;
        }
        progression += speed;
        traveledDistance -= speed; // For the treemap (ascending order)
        if (progression > 1) {
            progression = 0;
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
     * Gets the poney's row.
     * 
     * @return row.
     */
    public double getRow() {
        return row;
    }

    /**
     * Gets the poney's progression.
     * 
     * @return progression.
     */
    public double getProgression() {
        return progression;
    }

    /**
     * Gets the poney's color.
     * 
     * @return poneyColor.
     */
    public String getColor() {
        return poneyColor;
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
    public boolean getIsNian() {
        return isNian;
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
     * Checks if the poney has won.
     * 
     * @return true or false.
     */
    boolean win() {
        return (lap == App.NB_TOURS);
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
     * Checks the poney's information.
     */
    public void check() {
        System.out.println("Poney color : " + poneyColor + " row : " + row + " progression : "
                + progression + " lap : " + lap + " isNian : " + isNian + " speed : " + speed);
    }

    /**
     * Returns the poney's distance with another poney.
     * 
     * @param poney.
     * @return progression.
     */
    public double distance(PoneyModel poney) {
        return progression - poney.progression;
    }
}
