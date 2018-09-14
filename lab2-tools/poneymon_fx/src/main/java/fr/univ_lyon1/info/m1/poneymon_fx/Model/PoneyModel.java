package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import java.util.Random;

public class PoneyModel {
    String poneyColor;
    final double row;
    public double progression;
    int lap;
    public double speed;
    static final int NB_TOURS = 2;
    boolean isWinner;

    /**
     * Create poney's model.
     * 
     * @param color of the poney.
     */
    public PoneyModel(String color, double row) {
        Random randomGenerator = new Random();
        this.speed = randomGenerator.nextFloat() * 0.01;
        this.poneyColor = color;
        this.row = row;
        this.progression = 0;
        this.lap = 0;
    }

    /**
     * Calls step() for this poney.
     */
    public void step() {
        progression += speed;
        if (progression > 1) {
            progression = 0;
            lap++;
            Random randomGenerator = new Random();
            this.speed = randomGenerator.nextFloat() * 0.01;
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
     * Checks if the poney has won.
     */
    boolean win() {
        return (lap == NB_TOURS);
    }

    /**
     * Checks the poney's information.
     */
    public void check() {
        System.out.println("Poney color : " + this.poneyColor 
                + " row : " + this.row 
                + " progression : " 
                + this.progression 
                + " lap : " + this.lap 
                + " speed : " + this.speed);
    }
}
