package fr.univ_lyon1.info.m1.poneymon_fx.Model;


public final class CoinModel extends AbstractObjectsModel {
    final double low = 0.3;
    final double high = 0.8;
    boolean visible;
    
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
     * Resets x position.
     * 
     */
    public void reset() {
        x = randomGenerator.nextFloat() * (high - low) + low;
        setVisible();
    }

    /**
     * Returns x.
     * 
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns y.
     * 
     * @return y.
     */
    public int getY() {
        return y;
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
     * Sets the boolean visible with a chance of 1/5.
     * 
     */
    public void setVisible() {
        int a = randomGenerator.nextInt(4);
        if (a == 0 /*|| a == 1 || a == 2 || a == 3 || a == 4*/) {
            visible = true;
        }
    }
    
    /**
     * Sets the boolean visible with a parameter.
     * 
     * @param b.
     */
    public void setVisible(boolean b) {
        visible = b;
    }
    

    /**
     * Checks the coin's information.
     */
    public void check() {
        System.out.println("Coin x : " + x + " y : " + y + " visible" + visible);
    }
}
