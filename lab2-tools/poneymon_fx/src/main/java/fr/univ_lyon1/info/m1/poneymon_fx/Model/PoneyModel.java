package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class PoneyModel extends AbstractObjectsModel {
    final double low = 0.001; //Arbitrary values for random speed.
    final double high = 0.002;
    int lap;
    double speed;
    boolean canChange;

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
    }

    /**
     * Calls step() for this poney.
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
}
