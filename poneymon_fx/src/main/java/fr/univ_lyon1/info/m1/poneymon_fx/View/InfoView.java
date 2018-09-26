package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class InfoView extends AbstractView {

    private final HBox hb;
    private final Button[] buttons;
    private final InfoCanvasView infoCanvasView;
    private String askedColor;

    /**
     * Creates ScoreView.
     * 
     * @param s.
     * @param c.
     * @param m.
     */
    public InfoView(Stage s, Controller c, FieldModel m) {
        super(s, c, m);
        
        getStage().setTitle("Informations");
        //Default askedColor
        askedColor = "blue";
        
        hb = new HBox();
        
        buttons = new Button[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            final String color = App.colorMap[i];
            buttons[i] = new Button(color);
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent arg0) {
                    askedColor = color;
                }
            });
            hb.getChildren().add(buttons[i]);
        }
        
        infoCanvasView = new InfoCanvasView();
    }

    /**
     * Runs the view's canvas function "run".
     * 
     */
    public void runCanvas() {
        infoCanvasView.run(getFieldModel(), askedColor);
    }
    
    /**
     * Shows the scores.
     * 
     */
    public void show() {
        getRoot().getChildren().add(infoCanvasView);
        getRoot().getChildren().add(hb);
        getStage().setY(500);
        getStage().setX(0);
        super.show();
    }
}
