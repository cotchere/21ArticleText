package manager;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;

import util.Constants;

public class UIManager {

	public static void loadBrandNames(JFXComboBox<String> cb_brand) {
		cb_brand.getItems().addAll(Constants.brands);
		cb_brand.getSelectionModel().select(0);
	}

	public static void loadAddArticleList(JFXListView<String> list_view) {
		list_view.getItems().addAll("");
	}

	public static void updateAddArticleList(JFXListView<String> list_view, String artNr){
		list_view.getItems().addAll("");
	}
	
	public static void updateResultTable(JFXComboBox<String> cb_brand) {
		cb_brand.getItems().addAll(Constants.brands);
	}
}
