package fr.univ_lyon1.info.m1.poneymon_fx.Main;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.ButtonsView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static final int NB_PONEYS = 5;
    public static final int NB_TOURS = 10;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    
    /**
     * Starts the application.
     * 
     * @param stage.
     */    
    @Override
    public void start(Stage stage) throws Exception {        

        // New window for buttons.
        Stage stageButtons = new Stage();
        
        FieldModel m = new FieldModel(NB_PONEYS);
        Controller c = new Controller();

        JfxView jfxView = new JfxView(stage, WIDTH, HEIGHT);
        ButtonsView buttonsView = new ButtonsView(stageButtons);

        c.setModel(m);
        c.addView(jfxView);
        c.addView(buttonsView);

        jfxView.setModel(m);
        jfxView.setControler(c);

        buttonsView.setModel(m);
        buttonsView.setControler(c);

        c.startTimer();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
