package fr.univ_lyon1.info.m1.poneymon_fx.Model;


public class CoinModel extends AbstractObjectsModel {
    final double low = 0.3;
    final double high = 0.8;

    /**
     * Creates the CoinModel.
     * 
     * @param i.
     */
    public CoinModel(int i) {
        super(i);
        type = "coin";
        x = randomGenerator.nextFloat() * (high - low) + low;
        setVisible();
    }
    
    /**
     * Resets parameters.
     * 
     */
    public void reset() {
        x = randomGenerator.nextFloat() * (high - low) + low;
        setVisible();
    }

    /**
     * Returns X.
     * 
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns Y.
     * 
     * @return y.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the boolean visible with a chance of 1/5.
     * 
     */
    public void setVisible() {
        int a = randomGenerator.nextInt(4);
        if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4) {
            visible = true;
        }
    }

    /**
     * Checks the coin's information.
     */
    public void check() {
        System.out.println("Coin x : " + x + " y : " + y + " visible" + visible);
    }
}
