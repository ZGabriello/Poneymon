package fr.univ_lyon1.info.m1.poneymon_fx.Model;


public final class CoinModel extends AbstractObjectsModel {
    private final double low = 0.3;
    private final double high = 0.8;
    private boolean visible;
    
    /**
     * Creates the CoinModel.
     * 
     * @param i.
     */
    public CoinModel(final int i) {
        super(i, "coin");
        setX(getRandom().nextFloat() * (high - low) + low);
        setVisible();
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
        int a = getRandom().nextInt(4);
        if (a == 0 /*|| a == 1 || a == 2 || a == 3 || a == 4*/) {
            visible = true;
        }
    }
    
    /**
     * Sets the boolean visible with a parameter.
     * 
     * @param b.
     */
    public void setVisible(final boolean b) {
        visible = b;
    }
    
    /**
     * Gets number of done lap.
     * 
     * @return lap.
     */
    public void reset() {
        setX(getRandom().nextFloat() * (high - low) + low);
        setVisible();
    }
}
