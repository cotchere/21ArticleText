package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animations.FadeInLeftTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

public class MainUi implements javafx.fxml.Initializable {

	@FXML
	private AnchorPane pane_data;

	@FXML
	private ListView<String> list_menu;

	@FXML
	private Label lbl_Title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		list_menu.getItems().addAll("  Home", "  Artikle (+)", "  suchen", "  Einstellungen", "  Info");
		Platform.runLater(() -> {

			list_menu.getSelectionModel().select(0);
			loadAnchorPane(pane_data, "ArticleTable.fxml");
			list_menu.requestFocus();
		});
	}

	@FXML
	private void MenuListListener(MouseEvent event) {
		new FadeInLeftTransition(lbl_Title).play();
		switch (list_menu.getSelectionModel().getSelectedIndex()) {
		case 0:
			loadAnchorPane(pane_data, "ArticleTable.fxml");
			lbl_Title.setText("Home");
			break;
		case 1:
			loadAnchorPane(pane_data, "AddArticle.fxml");
			lbl_Title.setText("Artikel (+)");
			break;
		case 2:
			loadAnchorPane(pane_data, "SearchArticle.fxml");
			lbl_Title.setText("suchen");
			break;
		case 3:
			loadAnchorPane(pane_data, "ArticleSetting.fxml");
			lbl_Title.setText("Einstellungen");
			break;
		case 4:
			loadAnchorPane(pane_data, "Info.fxml");
			lbl_Title.setText("Info");
			break;
		}
	}

	public void loadAnchorPane(AnchorPane ap, String a) {
		try {
			AnchorPane p = FXMLLoader.load(getClass().getResource("/view/" + a));
			ap.getChildren().setAll(p);
		} catch (IOException e) {
		}
	}
}