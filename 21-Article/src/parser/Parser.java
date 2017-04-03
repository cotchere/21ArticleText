package parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Network.NikeNetwork.NetworkRequest;
import data.Article;
import manager.DataManager;
import util.Constants;

public class Parser {

	public static void parseString_Adidas(String html, Article a, String language) {

		Document doc = Jsoup.parse(html);
		Elements description = doc.select("div.product-details-description");
		String name = doc.select("meta[name=keywords]").attr("content").toString();
		Elements li = description.select("ul li");

		if (language.equals(Constants.language[0])) {
			a.setArt_name_de(name);
			a.setArt_description_de(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[1])) {
			a.setArt_name_en(name);
			a.setArt_description_en(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[2])) {
			a.setArt_name_es(name);
			a.setArt_description_es(description.text().replace("\n\r", "<br>") + "\n"
					+ li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[3])) {
			a.setArt_name_fr(name);
			a.setArt_description_fr(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		}
		DataManager.updateTableContent(a, true);
	}

	private static void parseString_Nike(String html, Article a, int l_id) {

		Document doc = Jsoup.parse(html);
		Elements description = doc.select("div.pi-pdpmainbody");
		String name = doc.select("meta[property=og:title]").attr("content").toString();
		Elements li = description.select("ul li");

		switch (l_id) {
		case 0:
			a.setArt_name_de(name);
			a.setArt_description_de(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
			break;
		case 1:
			a.setArt_name_en(name);
			a.setArt_description_en(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
			break;
		case 2:
			a.setArt_name_es(name);
			a.setArt_description_es(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
			break;
		case 3:
			a.setArt_name_fr(name);
			a.setArt_description_fr(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
			break;
		}

		DataManager.updateTableContent(a, true);
	}

	/*  Nike check 
	 *  1. check if Article can be found
	 *  2. check if there are multiple Articles (other color-codes)
	 *  2.1 reparse html-code with new article-link
	 *  3. Article can be found -> parse html 
	 */
	public static void parseString_NikeCheck(String html, Article a, int l_id) {
		Document doc = Jsoup.parse(html);
		Elements found = doc.select("div.no-results-subheader");

		if (found.isEmpty()) {
			try {
				String link = doc.select("div.grid-item-image-wrapper > a").first().attr("href");
				NetworkRequest nr;
				nr = new NetworkRequest(link, a, l_id);
				nr.execute();
			} catch (NullPointerException e) {
				parseString_Nike(html, a, l_id);
			}
		} else {
			DataManager.updateTableContent(a, false);
		}
	}

	public static void parseString_Reebok(String html, Article a, String language) {

		Document doc = Jsoup.parse(html);
		Elements description = doc.select("div.product-details-description");
		String name = doc.select("meta[name=keywords]").attr("content").toString();
		Elements li = description.select("ul li");

		if (language.equals(Constants.language[0])) {
			a.setArt_name_de(name);
			a.setArt_description_de(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[1])) {
			a.setArt_name_en(name);
			a.setArt_description_en(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[2])) {
			a.setArt_name_es(name);
			a.setArt_description_es(description.text().replace("\n\r", "<br>") + "\n"
					+ li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		} else if (language.equals(Constants.language[3])) {
			a.setArt_name_fr(name);
			a.setArt_description_fr(
					description.text() + "\n" + li.toString().replaceAll("<li>", "-").replaceAll("</li>", ""));
		}

		DataManager.updateTableContent(a, true);
	}

	public static void parseString_Puma(String html, Article a, String language) {

		Document doc = Jsoup.parse(html);
		Elements description = doc.select("div.tab-pane");
		String name = doc.select("meta[name=keywords]").attr("content").toString();

		if (language.equals(Constants.language[0])) {
			a.setArt_name_de(name);
			a.setArt_description_de("Puma " + description.text().replace(":", ""));
		} else if (language.equals(Constants.language[1])) {
			a.setArt_name_en(name);
			a.setArt_description_en("Puma " + description.text().replace(":", ""));
		} else if (language.equals(Constants.language[2])) {
			a.setArt_name_es(name);
			a.setArt_description_es("Puma " + description.text().replace("\n\r", "<br>").replace(":", ""));
		} else if (language.equals(Constants.language[3])) {
			a.setArt_name_fr(name);
			a.setArt_description_fr("Puma " + description.text().replace(":", ""));
		}

		DataManager.updateTableContent(a, true);
	}

	public static void parseString_UnderArmour(String html, Article a, String language) {

		Document doc = Jsoup.parse(html);
		Elements description = doc.select("div.description");
		String name = doc.select("meta[name=keywords]").attr("content").toString();

		if (language.equals(Constants.language[0])) {
			a.setArt_name_de(name);
			a.setArt_description_de("Under Armour" + description.text());
		} else if (language.equals(Constants.language[1])) {
			a.setArt_name_en(name);
			a.setArt_description_en("Under Armour " + description.text());
		} else if (language.equals(Constants.language[2])) {
			a.setArt_name_es(name);
			a.setArt_description_es("Under Armour " + description.text());
		} else if (language.equals(Constants.language[3])) {
			a.setArt_name_fr(name);
			a.setArt_description_fr("Under Armour " + description.text());
		}

		DataManager.updateTableContent(a, true);
	}

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://store.nike.com/de/de_de/pd/sb-stefan-janoski-max-herren-skateboardschuh/pid-10045001/pgid-11778884").get();

			Elements found = doc.select("div.no-results-subheader");

			if (found.isEmpty()) {
				System.out.println("Article found - further test are running");
				String name = doc.select("meta[property=og:title]").attr("content").toString();
				System.out.println("Name: " + name);
			} else {
				System.out.println("Article not found");
			}

			// check wheather article is available or not
			// program has to choose between multiple articles (catch
			// NullPointerException)
			// -> String link = doc.select("div.grid-item-image-wrapper >
			// a").first().attr("href");

			// check for article not found
			// -> String fileNotFound =
			// doc.selecet("div.no-results-header-wrapper");
			// check for article found = Parser.parseString_Nike(...);

			// System.out.println(found);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
