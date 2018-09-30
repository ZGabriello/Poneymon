package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class StateDontActivateNian implements StateLike {
    
    /**
     * Activates the nian mode for poneys if some conditions are satisfied.
     * 
     * @param context.
     * @param poney.
     */
    public void goNian(StateContext context, PoneyModel poney) {
        //L'IA est très simple : si sa vitesse est inférieure à 0.0022
        // ou si le nombre de tour est égal à 4, alors il passe
        // en mode nian.
        if ((poney.getSpeed() < 0.0022) 
                || (poney.getLap() == 4)) {
            context.setState(new StateActivateNian());
        }
    }
}
