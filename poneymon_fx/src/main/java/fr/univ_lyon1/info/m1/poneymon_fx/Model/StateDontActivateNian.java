package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class StateDontActivateNian implements StateLike {

    
    /**
     * Activates the nian mode for IA poneys if some conditions are satisfied.
     * 
     * @param context.
     * @param poney.
     */
    public void goNian(StateContext context, PoneyModel poney) {
        if ((poney.getSpeed() < 0.0022) 
                || (poney.getLap() == 1)) {
            context.setState(new StateActivateNian());
        }
    }
}
