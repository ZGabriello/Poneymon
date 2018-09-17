package fr.univ_lyon1.info.m1.poneymon_fx.View;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonsView extends AbstractView {

    String[] colorMap = new String[] { "blue", "green", "orange", "purple", "yellow" };
    Button[] buttons;
    HBox hb;

    /**
     * Creates ButtonsView.
     * 
     * @param s.
     */
    public ButtonsView(Stage s) {
        stage = s;
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

        buttons = new Button[colorMap.length];
        for (int i = 0; i < colorMap.length; i++) {
            final String color = colorMap[i];
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
        stage.setScene(scene);
        stage.setY(0);
        stage.setX(600);
        stage.show();
    }
}
