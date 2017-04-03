package manager;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import Network.AdidasNetwork;
import Network.NikeNetwork;
import Network.PumaNetwork;
import Network.ReebokNetwork;
import Network.UnderArmourNetwork;
import controller.ArticleTable;
import data.Article;
import data.Brand;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.util.Callback;
import util.Constants;

public class DataManager {

	private static final List<Brand> brands = new ArrayList<Brand>();
	private static Brand current_brand;
	private static int counter_article = 0;
	private static List<Article> brands_tableList;
	private static TreeItem<Article> root;
	private static ObservableList<Article> listData = FXCollections.observableArrayList();
	
	public static ObservableList<Article> getData() {
	
        return listData;
    }
	
	
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
	
	

	public static void setupBrands() {

		Brand b;
		for (int i = 0; i < Constants.brands.length; i++) {
			b = new Brand(Constants.brands[i], Constants.brands_link_de[i], Constants.brands_link_uk[i],
					Constants.brands_link_es[i], Constants.brands_link_fr[i]);
			brands.add(b);
		}

		current_brand = brands.get(0);
	}

	public static String[] getBrands() {

		return Constants.brands;
	}

	public static void addArticleToBrand(String s) {

		List<String> list = new ArrayList<String>(Arrays.asList(s.split(",")));
		Article a;
		if (list.size() > 0 && !list.get(0).equals("")) {

			current_brand.getArticles().clear();

			for (String nr : list) {
				a = new Article(nr, null, null, null, null, null, null, null, null, null, null, null, null, null);
				setFinalURL(a);
				current_brand.addArticleToBrand(a);
			}
			System.out.println(current_brand.getArticles().size());

		} else {
			current_brand.getArticles().clear();
		}
		fillList();
		//TIView.lbl_status.setText(current_brand.getArticles().size() + ":" + counter_article);
	}

	public static List<Article> getCurrentArticles() {
		return current_brand.getArticles();
	}

	private static Article setFinalURL(Article a) {

		if (current_brand.getName().equals(Constants.brands[2])) {
			String url_de = current_brand.getBrand_link_de() + "/" + a.getArt_nr();
			String url_uk = current_brand.getBrand_link_uk() + "/" + a.getArt_nr();
			String url_es = current_brand.getBrand_link_es() + "/" + a.getArt_nr();
			String url_fr = current_brand.getBrand_link_fr() + "/" + a.getArt_nr();

			a.setArt_webLink_de(url_de);
			a.setArt_webLink_uk(url_uk);
			a.setArt_webLink_es(url_es);
			a.setArt_webLink_fr(url_fr);
			return a;
		} else if (current_brand.getName().equals(Constants.brands[3])) {
			String url_de = current_brand.getBrand_link_de() + "/" + a.getArt_nr().substring(1) + ".html";
			String url_uk = current_brand.getBrand_link_uk() + "/" + a.getArt_nr().substring(1) + ".html";
			String url_es = current_brand.getBrand_link_es() + "/" + a.getArt_nr().substring(1) + ".html";
			String url_fr = current_brand.getBrand_link_fr() + "/" + a.getArt_nr().substring(1) + ".html";

			a.setArt_webLink_de(url_de);
			a.setArt_webLink_uk(url_uk);
			a.setArt_webLink_es(url_es);
			a.setArt_webLink_fr(url_fr);
			return a;
		} else if (current_brand.getName().equals(Constants.brands[4])) {
			String url_de = current_brand.getBrand_link_de() + "/" + a.getArt_nr() + ".html";
			String url_uk = current_brand.getBrand_link_uk() + "/pcid" + a.getArt_nr();
			String url_es = current_brand.getBrand_link_es() + "/" + a.getArt_nr() + ".html";
			String url_fr = current_brand.getBrand_link_fr() + "/" + a.getArt_nr() + ".html";

			a.setArt_webLink_de(url_de);
			a.setArt_webLink_uk(url_uk);
			a.setArt_webLink_es(url_es);
			a.setArt_webLink_fr(url_fr);
			return a;
		} else {
			String url_de = current_brand.getBrand_link_de() + "/" + a.getArt_nr() + ".html";
			String url_uk = current_brand.getBrand_link_uk() + "/" + a.getArt_nr() + ".html";
			String url_es = current_brand.getBrand_link_es() + "/" + a.getArt_nr() + ".html";
			String url_fr = current_brand.getBrand_link_fr() + "/" + a.getArt_nr() + ".html";

			a.setArt_webLink_de(url_de);
			a.setArt_webLink_uk(url_uk);
			a.setArt_webLink_es(url_es);
			a.setArt_webLink_fr(url_fr);
			return a;
		}
	}

	public static void searchForArticle(boolean german, boolean english, boolean spanish, boolean french) {
		counter_article = 0;
		if (german) {
			for (Brand b : brands) {
				if (b.getName().equals(Constants.brands[0])) {
					search_Adidas(b.getArticles(), 0);
				}

				if (b.getName().equals(Constants.brands[1])) {
					search_Reebok(b.getArticles(), 0);
				}

				if (b.getName().equals(Constants.brands[2])) {
					search_Nike(b.getArticles(), 0);
				}

				if (b.getName().equals(Constants.brands[3])) {
					search_Puma(b.getArticles(), 0);
				}

				if (b.getName().equals(Constants.brands[4])) {
					search_UA(b.getArticles(), 0);
				}
			}
		}

		if (english) {
			for (Brand b : brands) {
				if (b.getName().equals(Constants.brands[0])) {
					search_Adidas(b.getArticles(), 1);
				}

				if (b.getName().equals(Constants.brands[1])) {
					search_Reebok(b.getArticles(), 1);
				}

				if (b.getName().equals(Constants.brands[2])) {
					search_Nike(b.getArticles(), 1);
				}
				if (b.getName().equals(Constants.brands[3])) {
					search_Puma(b.getArticles(), 1);
				}
				if (b.getName().equals(Constants.brands[4])) {
					search_UA(b.getArticles(), 1);
				}
			}
		}

		if (spanish) {
			for (Brand b : brands) {
				if (b.getName().equals(Constants.brands[0])) {
					search_Adidas(b.getArticles(), 2);
				}

				if (b.getName().equals(Constants.brands[1])) {
					search_Reebok(b.getArticles(), 2);
				}

				if (b.getName().equals(Constants.brands[2])) {
					search_Nike(b.getArticles(), 2);
				}
				if (b.getName().equals(Constants.brands[3])) {
					search_Puma(b.getArticles(), 2);
				}
				if (b.getName().equals(Constants.brands[4])) {
					search_UA(b.getArticles(), 2);
				}
			}
		}

		if (french) {
			for (Brand b : brands) {
				if (b.getName().equals(Constants.brands[0])) {
					search_Adidas(b.getArticles(), 3);
				}

				if (b.getName().equals(Constants.brands[1])) {
					search_Reebok(b.getArticles(), 3);
				}

				if (b.getName().equals(Constants.brands[2])) {
					search_Nike(b.getArticles(), 3);
				}
				if (b.getName().equals(Constants.brands[3])) {
					search_Puma(b.getArticles(), 3);
				}
				if (b.getName().equals(Constants.brands[4])) {
					search_UA(b.getArticles(), 3);
				}
			}
		}
	}

	private static void search_Adidas(List<Article> a_list, int l_id) {
		AdidasNetwork network = new AdidasNetwork();
		network.startRequest(a_list, l_id);
	}

	private static void search_Reebok(List<Article> a_list, int l_id) {
		ReebokNetwork network = new ReebokNetwork();
		network.startRequest(a_list, l_id);
	}

	private static void search_Nike(List<Article> a_list, int l_id) {
		NikeNetwork network = new NikeNetwork();
		network.startRequest(a_list, l_id);
	}

	private static void search_Puma(List<Article> a_list, int l_id) {
		PumaNetwork network = new PumaNetwork();
		network.startRequest(a_list, l_id);
	}

	private static void search_UA(List<Article> a_list, int l_id) {
		UnderArmourNetwork network = new UnderArmourNetwork();
		network.startRequest(a_list, l_id);
	}

	public static void updateTableContent(Article a, boolean status) {
		listData.add(a);
		a.setFound(status);
	}

	private static void fillList() {
	
	}

	public static void writeXLSXFile(File file) {
		String excelFileName = file.toString() + ".xlsx";

		String sheetName = "Sheet1";// name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
		int row_id = 1;
		createFirstRow(sheet);
		// iterating r number of rows
		for (Brand b : brands) {

			for (int r = 0; r < b.getArticles().size(); r++) {
				row_id++;
				XSSFRow row = sheet.createRow(row_id);

				// iterating c number of columns
				for (int c = 0; c < 7; c++) {
					XSSFCell cell = row.createCell(c);
					switch (c) {
					case 0:
						cell.setCellValue(b.getArticles().get(r).getArt_nr());
						break;
					case 1:
						cell.setCellValue(b.getName());
						break;
					case 2:
						cell.setCellValue(b.getArticles().get(r).getArt_name_de());
						break;
					case 3:
						cell.setCellValue(b.getName() + " " + b.getArticles().get(r).getArt_name_de() + "\n"
								+ b.getArticles().get(r).getArt_description_de());
						break;
					case 4:
						cell.setCellValue(b.getName() + " " + b.getArticles().get(r).getArt_name_en() + "\n"
								+ b.getArticles().get(r).getArt_description_en());
						break;
					case 5:
						cell.setCellValue(b.getName() + " " + b.getArticles().get(r).getArt_name_es() + "\n"
								+ b.getArticles().get(r).getArt_description_es());
						break;

					case 6:
						cell.setCellValue(b.getName() + " " + b.getArticles().get(r).getArt_name_fr() + "\n"
								+ b.getArticles().get(r).getArt_description_fr());
						break;
					}
				}
			}
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(excelFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// write this workbook to an Outputstream.
		try {
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
			Desktop.getDesktop().open(new File(excelFileName));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createFirstRow(XSSFSheet sheet) {
		XSSFRow row = sheet.createRow(0);

		for (int c = 0; c < 7; c++) {
			XSSFCell cell = row.createCell(c);

			switch (c) {
			case 0:
				cell.setCellValue("Brand");
				break;

			case 1:
				cell.setCellValue("ArtNr.");
				break;

			case 2:
				cell.setCellValue("Art Name (deutsch)");
				break;

			case 3:
				cell.setCellValue("Art Beschreibung de");
				break;

			case 4:
				cell.setCellValue("Art Beschreibung en");
				break;
			case 5:
				cell.setCellValue("Art Beschreibung es");
				break;
			case 6:
				cell.setCellValue("Art Beschreibung fr");
				break;
			}
		}
	}

	public static void setCurrentBrand(String selectedItem) {
		for (Brand b : brands) {
			if (b.getName().equals(selectedItem)) {
				current_brand = b;
				fillList();
			}
		}
	}


	
}
