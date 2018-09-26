package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class StateActivateNian implements StateLike {
    
    public void goNian(StateContext context, PoneyModel p) {
        p.setNianManually(true);
        context.setState(new StateDontActivateNian());
    }
}
