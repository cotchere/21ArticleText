package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import animations.FadeInUpTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import manager.UIManager;

public class AddArticleController implements javafx.fxml.Initializable {

	@FXML
	private AnchorPane mainPane;

	@FXML
	private JFXButton btn_add;

	@FXML
	private JFXComboBox<String> cb_brand;

	@FXML
	private JFXListView<String> list_article;

	@FXML
	private JFXTextArea txt_art;

	@FXML
	private Label lbl_brandLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			loadData();
			showUp();
		});
	}

	private void showUp() {
		new FadeInUpTransition(mainPane).play();

	}

	@FXML
	private void AddArticleListener(MouseEvent event) {
		list_article.getItems().add("Hallo");
	}

	private void loadData() {
		UIManager.loadBrandNames(cb_brand);
		UIManager.loadAddArticleList(list_article);
	}
}
