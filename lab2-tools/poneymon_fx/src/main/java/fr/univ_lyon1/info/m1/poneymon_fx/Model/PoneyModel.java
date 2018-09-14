package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

public class PoneyModel {
    String poneyColor;
    final double row;
    public double progression;
    int lap;
    public double speed;
    static final int NB_TOURS = 10;
    boolean isWinner;
    boolean isNian;
    boolean canChange;

    /**
     * Create poney's model.
     * 
     * @param color of the poney.
     */
    public PoneyModel(String color, double row) {
        Random randomGenerator = new Random();
        this.speed = randomGenerator.nextFloat() * 0.001;
        this.poneyColor = color;
        this.row = row;
        this.progression = 0;
        this.lap = 0;
        this.isNian = false;
        this.canChange = true;
    }

    /**
     * Calls step() for this poney.
     */
    public void step() {
        if (canChange) {
            if (this.isNian) {
                speed += speed;
                canChange = false;
            }
        }
        progression += speed;
        if (progression > 1) {
            progression = 0;
            lap++;
            Random randomGenerator = new Random();
            this.speed = randomGenerator.nextFloat() * 0.001;
            this.isNian = false;
            this.canChange = true;
            if (lap == NB_TOURS) {
                this.isWinner = true;
            }
        }
    }

    /**
     * Gets the poney's row.
     */
    public double getRow() {
        return this.row;
    }

    /**
     * Gets the poney's progression.
     */
    public double getProgression() {
        return this.progression;
    }

    /**
     * Gets the poney's color.
     */
    public String getColor() {
        return this.poneyColor;
    }

    /**
     * Gets the poney's boolean isWinner.
     */
    public boolean getIsWinner() {
        return this.isWinner;
    }

    /**
     * Gets the poney's boolean isNian.
     */
    public boolean getIsNian() {
        return this.isNian;
    }

    /**
     * Checks if the poney has won.
     */
    boolean win() {
        return (lap == NB_TOURS);
    }

    /**
     * Sets the boolean isNian.
     */
    public void setNian(boolean b) {
        this.isNian = b;
    }

    /**
     * Checks the poney's information.
     */
    public void check() {
        System.out.println("Poney color : " + this.poneyColor + " row : " + this.row
                + " progression : " + this.progression + " lap : " + this.lap + " isNian : "
                + this.isNian + " speed : " + this.speed);
    }
}
