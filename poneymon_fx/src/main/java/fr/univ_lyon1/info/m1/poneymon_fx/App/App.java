package fr.univ_lyon1.info.m1.poneymon_fx.App;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import fr.univ_lyon1.info.m1.poneymon_fx.View.AbstractView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.ButtonsView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.InfoView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;
import fr.univ_lyon1.info.m1.poneymon_fx.View.ScoreView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class App extends Application {
    
    public static final int NB_PONEYS = 5;
    public static final int NB_TOURS = 5;
    public static final String[] colorMap = new String[] 
        { "blue", "green", "orange", "purple", "yellow" }; 
    
    private static Model m;
    private static Controller c;
    
    /**
     * Starts the application.
     * 
     * @param stage.
     */    
    @Override
    public void start(Stage stage) throws Exception {        
        
        c = Controller.getInstance();
        m = Model.getInstance();
        m.setController(c);
        c.setModel(m);
        
        /*Stage stage1 = new Stage();
        JfxView jfxView1 = new JfxView(stage1, 1000, 400, c, m);
        c.addView(jfxView1);*/

        Stage stageJfx = new Stage();
        AbstractView jfxView = new JfxView(stageJfx, 1000, 600, c, m);

        Stage stageButtons = new Stage();
        AbstractView buttonsView = new ButtonsView(stageButtons, c, m);
        
        Stage stageScore = new Stage();
        AbstractView scoreView = new ScoreView(stageScore, c, m);
        
        Stage stageInfo = new Stage();
        AbstractView infoView = new InfoView(stageInfo, c, m);
        
        c.addView(buttonsView);
        c.addView(scoreView);
        c.addView(infoView);
        c.addView(jfxView);
        c.run();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
