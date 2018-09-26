package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class ButtonsView extends AbstractView {

    private final Button[] buttons;
    private final HBox hb;

    /**
     * Creates ButtonsView.
     * 
     * @param s.
     * @param c.
     * @param m.
     */
    public ButtonsView(Stage s, Controller c, FieldModel m) {
        super(s, c, m);
        
        getStage().setTitle("Nian activation");

        hb = new HBox(); // Boite où ranger les éléments horizontalement

        Button pause = new Button("Pause");
        pause.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                boolean b = getFieldModel().getPaused() ? false : true;
                getFieldModel().setPaused(b);
            }
        });

        hb.getChildren().add(pause);

        buttons = new Button[App.NB_PONEYS];
        for (int i = 0; i < 2; i++) {
            final String color = App.colorMap[i];
            buttons[i] = new Button(color);
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent arg0) {
                    getFieldModel().setIsNianManually(true, color);
                }
            });
            hb.getChildren().add(buttons[i]);
        }
    }

    /**
     * Show the buttons.
     * 
     */
    public void show() {
        getRoot().getChildren().add(hb);
        getStage().setY(300);
        getStage().setX(0);
        super.show();
    }
}
