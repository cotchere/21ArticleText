package controller;

import java.net.URL;
import java.util.ResourceBundle;

import animations.FadeInUpTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SearchArticleController implements javafx.fxml.Initializable {

	@FXML
	private AnchorPane mainPane;
	
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
