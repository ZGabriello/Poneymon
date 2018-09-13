package fr.univ_lyon1.info.m1.poneymon_fx.View;

import fr.univ_lyon1.info.m1.poneymon_fx.Controler.Controler;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JfxView {

	FieldModel fieldModel;
	Controler controler;
	FieldView fieldView;
	
	Stage stage;
	
	int i;
	int j;
	
	public JfxView(Stage stage, int i, int j, int nbPoneys) {		
		this.stage = stage;
		
        stage.setTitle("Poneymon");                
        
        fieldView = new FieldView(i, j, nbPoneys);        
	}

	public void setModel(FieldModel m) {
		this.fieldModel = m;
	}

	public void setControler(Controler c) {
		this.controler = c;	
	}	
	
	public void display() {	
		fieldView.display(fieldModel);
	}
	
	public void notifyFieldView() {
		fieldView.associate(this.fieldModel);
	}
	
	public void show() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.getChildren().add(fieldView);        
        stage.setScene(scene);
        stage.show();
	}
}
