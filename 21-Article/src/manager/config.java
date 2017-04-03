package manager;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class config {

	 public static void setModelColumn(TableColumn tb,String a){
	        tb.setCellValueFactory(new PropertyValueFactory(a));
	    }
}
