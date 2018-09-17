package fr.univ_lyon1.info.m1.poneymon_fx.App;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.ButtonsView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.ScoreView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    
    public static final int NB_PONEYS = 5;
    public static final int NB_TOURS = 10;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    
    /**
     * Starts the application.
     * 
     * @param stage.
     */    
    @Override
    public void start(Stage stage) throws Exception {        

        // New windows.
        Stage stageButtons = new Stage();
        Stage stageScore = new Stage();
        Stage stageJfx = new Stage();
        
        FieldModel m = new FieldModel();
        Controller c = new Controller();

        ButtonsView buttonsView = new ButtonsView(stageButtons);
        ScoreView scoreView = new ScoreView(stageScore);
        JfxView jfxView = new JfxView(stageJfx, WIDTH, HEIGHT);
        
        /*Stage stage1 = new Stage();
        JfxView jfxView1 = new JfxView(stage1, WIDTH, HEIGHT);
        jfxView1.setModel(m);
        jfxView1.setControler(c);
        c.addView(jfxView1);*/

        c.setModel(m);
        c.addView(buttonsView);
        c.addView(scoreView);
        c.addView(jfxView);

        jfxView.setModel(m);
        jfxView.setControler(c);

        buttonsView.setModel(m);
        buttonsView.setControler(c);
        
        scoreView.setModel(m);
        scoreView.setControler(c);

        c.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
