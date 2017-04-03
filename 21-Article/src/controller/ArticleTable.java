package controller;

import data.Article;
import java.net.URL;
import java.util.ResourceBundle;

import animations.FadeInUpTransition;
import util.CustomButtonCell;
import util.CustomImageCell;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import manager.DataManager;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ArticleTable implements Initializable {

	@FXML
	private AnchorPane mainPane;

	@FXML
	private TableColumn<Article, String> col_brand;

	@FXML
	private TableColumn<Article, String> col_name;

	@FXML
	private TableColumn<Article, String> col_artNr;

	@FXML
	private TableColumn<Article, Boolean> col_found;

	@FXML
	private TableColumn<Article, Boolean> col_preview;

	@FXML
	private TableView<Article> tableView;

	@FXML
	private ProgressBar bar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Platform.runLater(() -> {
			selectWithService();
		});

	}

	private void setCellValueFactories() {
		col_brand.setCellValueFactory(new PropertyValueFactory("art_nr"));
		col_artNr.setCellValueFactory(new PropertyValueFactory("art_nr"));
		col_name.setCellValueFactory(new PropertyValueFactory("art_name_de"));
		col_found.setCellValueFactory(new PropertyValueFactory("found"));
		col_preview.setCellValueFactory(new PropertyValueFactory("found"));
	}

	private void load() {
		// changed to multiple selection mode
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		// set cell value factories
		setCellValueFactories();

		// set Dummy Data for the TableView
		tableView.setItems(getData());

		// set the Row Factory of the table
		setRowFactory();

		// Set row selection as default
		setRowSelection();
	}

	/**
	 * Change the cell selection boolean value of TableView
	 */
	public void setRowSelection() {
		tableView.getSelectionModel().clearSelection();
		tableView.getSelectionModel().setCellSelectionEnabled(false);
	}

	/**
	 * Change the cell selection boolean value of TableView
	 */
	public void setCellSelection() {
		tableView.getSelectionModel().clearSelection();
		tableView.getSelectionModel().setCellSelectionEnabled(true);

	}

	/**
	 * Set Row Factory for the TableView
	 */
	public void setRowFactory() {

		col_preview.setCellFactory(new Callback<TableColumn<Article, Boolean>, TableCell<Article, Boolean>>() {

			@Override
			public TableCell<Article, Boolean> call(TableColumn<Article, Boolean> param) {

				TableCell<Article, Boolean> cell = new CustomButtonCell();

				return cell;
			}
		});
		
		col_found.setCellFactory(new Callback<TableColumn<Article, Boolean>, TableCell<Article, Boolean>>() {

			@Override
			public TableCell<Article, Boolean> call(TableColumn<Article, Boolean> param) {

				TableCell<Article, Boolean> cell = new CustomImageCell();

				return cell;
			}
		});
	}

	/**
	 * Provides the dummy Person data.
	 *
	 * @return
	 */
	public ObservableList<Article> getData() {

		
		return DataManager.getData();
	}

	private void selectWithService() {
		Service<Integer> service = new Service<Integer>() {
			@Override
			protected Task<Integer> createTask() {
				load();
		        mainPane.setOpacity(0);
				return new Task<Integer>() {
					@Override
					protected Integer call() throws Exception {
						Integer max = 500;
						if (max > 35) {
							max = 30;
						}
						updateProgress(0, max);
						for (int k = 0; k < max; k++) {
							Thread.sleep(40);
							updateProgress(k + 1, max);
						}
						return max;
					}
				};
			}
		};
		service.start();
		bar.progressProperty().bind(service.progressProperty());
		service.setOnRunning((WorkerStateEvent event) -> {
			// imgLoad.setVisible(true);
		});
		service.setOnSucceeded((WorkerStateEvent event) -> {
			// imgLoad.setVisible(false);
			new FadeInUpTransition(mainPane).play();
		});
	}
}