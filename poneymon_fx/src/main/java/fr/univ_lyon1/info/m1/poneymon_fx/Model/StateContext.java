package fr.univ_lyon1.info.m1.poneymon_fx.Model;

public class StateContext {
    private StateLike myState;
    
    StateContext() {
        setState(new StateDontActivateNian());
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    void setState(final StateLike newState) {
        myState = newState;
    }

    public void nianIa(PoneyModel p) {
        myState.goNian(this, p);
    }
}
