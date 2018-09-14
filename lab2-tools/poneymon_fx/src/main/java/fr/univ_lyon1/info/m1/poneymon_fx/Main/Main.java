package fr.univ_lyon1.info.m1.poneymon_fx.Main;

import fr.univ_lyon1.info.m1.poneymon_fx.Controler.Controler;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.View.JfxView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     * Starts the application.
     * 
     * @param stage.
     */
    @Override
    public void start(Stage stage) throws Exception {
        final int nb_poneys = 5; // 5 poneys

        FieldModel m = new FieldModel(nb_poneys);
        JfxView v = new JfxView(stage, 600, 600, nb_poneys); // 600x600 pixels
        Controler c = new Controler();

        c.addView(v);
        c.setModel(m);

        v.setModel(m);
        v.setControler(c);

        c.startTimer();
    }

    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
        Application.launch(args);
    }
}
