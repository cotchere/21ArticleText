package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainForm implements javafx.fxml.Initializable {
	@FXML
	private JFXTextField txt_username;
	@FXML
	private JFXButton btn_login;
	@FXML
	private JFXCheckBox cb_login;
	@FXML
	private JFXSpinner spinner_login;
	
	@FXML
	private ImageView image_search;
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {	
		btn_login.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	System.out.println("klicked");
		    	txt_username.setText("Accepted");
		    }
		});
	}
}
