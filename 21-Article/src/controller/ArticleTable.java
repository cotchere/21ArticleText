package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import animations.FadeInUpTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ArticleTable implements javafx.fxml.Initializable {
	
	@FXML
	private JFXButton btn_save;
	
	@FXML
	private AnchorPane paneTable;
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {	
		Platform.runLater(() -> {
			showUp();
		});
	}
	
	private void showUp(){
	    new FadeInUpTransition(paneTable).play();

	}
}
