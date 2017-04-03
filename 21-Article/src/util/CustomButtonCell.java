package util;

import com.jfoenix.controls.JFXButton;

import data.Article;
import javafx.scene.control.TableCell;

public class CustomButtonCell extends TableCell<Article, Boolean> {

	private JFXButton btn_preview;

	public CustomButtonCell(){
		
		btn_preview = new JFXButton("Vorschau"); btn_preview.
		setStyle("-fx-background-color: #307de1; -fx-text-fill: white;");
		setStyle("-fx-alignment: CENTER;");
		setGraphic(btn_preview);
	}

	@Override
	protected void updateItem(Boolean item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		
		if(!empty && !item){
			this.btn_preview.setDisable(true);
		} else if(empty) {
			this.setGraphic(null);
		}
	}
}
