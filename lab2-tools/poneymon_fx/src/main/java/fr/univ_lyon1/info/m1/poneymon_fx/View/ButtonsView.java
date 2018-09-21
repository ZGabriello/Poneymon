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

    Button[] buttons;
    HBox hb;

    /**
     * Creates ButtonsView.
     * 
     * @param s.
     * @param c.
     * @param m.
     */
    public ButtonsView(Stage s, Controller c, FieldModel m) {
        stage = s;
        controller = c;
        fieldModel = m;
        stage.setTitle("Poneymon");

        hb = new HBox(); // Boite où ranger les éléments horizontalement

        Button pause = new Button("Pause");
        pause.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                boolean b = fieldModel.getPaused() ? false : true;
                fieldModel.setPaused(b);
            }
        });

        hb.getChildren().add(pause);

        buttons = new Button[App.colorMap.length];
        for (int i = 0; i < App.colorMap.length; i++) {
            final String color = App.colorMap[i];
            buttons[i] = new Button(color);
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent arg0) {
                    fieldModel.setIsNianManually(true, color);
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
        root.getChildren().add(hb);
        stage.setY(0);
        stage.setX(600);
        super.show();
    }
}
