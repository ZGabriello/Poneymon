package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.App.App;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.Model;
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
     * @param stage.
     * @param model.
     */
    public ButtonsView(final Stage stage, final Model model) {
        super(stage, model);
        
        getStage().setTitle("Nian activation");

        hb = new HBox(); // Boite où ranger les éléments horizontalement

        Button pause = new Button("Pause");
        pause.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                if (!getFieldModel().checkWinner()) {
                    boolean b = getFieldModel().getPaused() ? false : true;
                    getFieldModel().setPaused(b);
                }
            }
        });
        
        Button restart = new Button("Restart");
        restart.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                getFieldModel().restart();
            }
        });

        hb.getChildren().add(pause);
        hb.getChildren().add(restart);

        buttons = new Button[2];
        for (int i = 0; i < 2; i++) {
            final String color = App.colorMap[i];
            final int index = i;
            buttons[i] = new Button(color);
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent arg0) {
                    getFieldModel().setIsNianManually(true, index);
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
