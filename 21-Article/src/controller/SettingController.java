package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import animations.FadeInUpTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SettingController implements javafx.fxml.Initializable {

	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private JFXCheckBox cb_german;
	
	@FXML
	private JFXCheckBox cb_english;
	
	@FXML
	private JFXCheckBox cb_spanish;
	
	@FXML
	private JFXCheckBox cb_french;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			showUp();
		});
	}
	
	private void showUp(){
	    new FadeInUpTransition(mainPane).play();
	}
}
