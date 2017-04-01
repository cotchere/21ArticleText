package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AddArticleController implements javafx.fxml.Initializable {

	@FXML
	private AnchorPane paneTable;
	
	@FXML
	private JFXButton btn_add;
	
	@FXML
	private JFXComboBox<String> cb_brand;
	
	@FXML
	private JFXListView<String> list_article;
	
	@FXML
	private JFXTextArea txt_art;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
