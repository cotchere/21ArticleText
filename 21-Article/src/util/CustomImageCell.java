package util;

import data.Article;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomImageCell extends TableCell<Article, Boolean> {

	private ImageView imageView;

	public CustomImageCell(){
		
		Image image = new Image("ic_check_black_24dp.png", 25, 25, false, false);
		imageView = new ImageView(image); 
		setStyle("-fx-alignment: CENTER;");
		setGraphic(imageView);
	}

	@Override
	protected void updateItem(Boolean item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		
		if(!empty && !item){
			Image image = new Image("ic_clear_black_24dp.png", 25, 25, false, false);
			this.imageView.setImage(image);
		} else if(empty) {
			this.setGraphic(null);
		}
	}
}
