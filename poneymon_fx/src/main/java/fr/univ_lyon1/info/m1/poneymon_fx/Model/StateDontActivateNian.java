package fr.univ_lyon1.info.m1.poneymon_fx.Model;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;

public class StateDontActivateNian implements StateLike {

    
    /**
     * Activates the nian mode for IA poneys if some conditions are satisfied.
     * 
     */
    public void goNian(StateContext context, PoneyModel p) {
        if ((p.getSpeed() < 0.0022) 
                || (p.getLap() == App.NB_TOURS - 1)) {
            context.setState(new StateActivateNian());
        }
    }
}
