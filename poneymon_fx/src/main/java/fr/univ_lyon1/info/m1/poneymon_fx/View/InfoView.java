package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class InfoView extends AbstractView {

    private final HBox hb;
    private final Button[] buttons;
    private final InfoCanvasView infoCanvasView;
    private int askedIndex;

    /**
     * Creates ScoreView.
     * 
     * @param stage.
     * @param model.
     */
    public InfoView(final Stage stage, final Model model) {
        super(stage, model);
        
        getStage().setTitle("Informations");
        //Default askedColor
        askedIndex = 0;
        
        hb = new HBox();
        
        buttons = new Button[App.NB_PONEYS];
        for (int i = 0; i < App.NB_PONEYS; i++) {
            int j = (i < 5) ? i : (i - 5);
            final String color = App.colorMap[j];
            final int k = i;
            buttons[i] = new Button(color);
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent arg0) {
                    askedIndex = k;
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
        infoCanvasView.run(getFieldModel(), askedIndex);
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
