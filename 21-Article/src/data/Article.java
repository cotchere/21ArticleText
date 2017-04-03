package data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Article {

	private StringProperty art_nr = new SimpleStringProperty();
	private StringProperty art_name_de = new SimpleStringProperty();
	private StringProperty art_name_en = new SimpleStringProperty();
	private StringProperty art_name_es = new SimpleStringProperty();
	private StringProperty art_name_fr = new SimpleStringProperty();
	private StringProperty art_description_de = new SimpleStringProperty();
	private StringProperty art_description_en = new SimpleStringProperty();
	private StringProperty art_description_es = new SimpleStringProperty();
	private StringProperty art_description_fr = new SimpleStringProperty();
	private String art_webLink_de ;
	private String art_webLink_uk;
	private String art_webLink_es;
	private String art_webLink_fr;
	private String art_imageLink;
	private BooleanProperty found = new SimpleBooleanProperty();

	
	
	public Article(String art_nr, String art_name_de, String art_name_en,
			String art_name_es, String art_name_fr, String art_description_de,
			String art_description_en, String art_description_es, String art_description_fr,
			String art_webLink_de, String art_webLink_uk, String art_webLink_es,
			String art_webLink_fr, String art_imageLink) {
		super();
		this.art_nr.setValue(art_nr);
		this.art_name_de.setValue(art_name_de);
		this.art_name_en.setValue(art_name_en);
		this.art_name_es.setValue(art_name_es);
		this.art_name_fr.setValue(art_name_fr);
		this.art_description_de.setValue(art_description_de);
		this.art_description_en.setValue(art_description_en);
		this.art_description_es.setValue(art_description_es);
		this.art_description_fr.setValue(art_description_fr);
		this.art_webLink_de = art_webLink_de;
		this.art_webLink_uk = art_webLink_uk;
		this.art_webLink_es = art_webLink_es;
		this.art_webLink_fr = art_webLink_fr;
		this.art_imageLink = art_imageLink;
	}
	
	public String getArt_nr() {
		return art_nr.get();
	}
	public void setArt_nr(StringProperty art_nr) {
		this.art_nr = art_nr;
	}
	public String getArt_name_de() {
		return art_name_de.get();
	}
	public void setArt_name_de(String art_name_de) {
		this.art_name_de.set(art_name_de);
	}
	public String getArt_name_en() {
		return art_name_en.get();
	}
	public void setArt_name_en(String art_name_en) {
		this.art_name_en.setValue(art_name_en);
	}
	public String getArt_name_es() {
		return art_name_es.get();
	}
	public void setArt_name_es(String art_name_es) {
		this.art_name_es.set(art_name_es);
	}
	public String getArt_name_fr() {
		return art_name_fr.get();
	}
	public void setArt_name_fr(String art_name_fr) {
		this.art_name_fr.set(art_name_fr);
	}
	public String getArt_description_de() {
		return art_description_de.get();
	}
	public void setArt_description_de(String art_description_de) {
		this.art_description_de.set(art_description_de);
	}
	public String getArt_description_en() {
		return art_description_en.get();
	}
	public void setArt_description_en(String art_description_en) {
		this.art_description_en.set(art_description_en);
	}
	public String getArt_description_es() {
		return art_description_es.get();
	}
	public void setArt_description_es(String art_description_es) {
		this.art_description_es.set(art_description_es);
	}
	public String getArt_description_fr() {
		return art_description_fr.get();
	}
	public void setArt_description_fr(String art_description_fr) {
		this.art_description_fr.set(art_description_fr);
	}
	public String getArt_webLink_de() {
		return art_webLink_de;
	}
	public void setArt_webLink_de(String art_webLink_de) {
		this.art_webLink_de = art_webLink_de;
	}
	public String getArt_webLink_uk() {
		return art_webLink_uk;
	}
	public void setArt_webLink_uk(String art_webLink_uk) {
		this.art_webLink_uk = art_webLink_uk;
	}
	public String getArt_webLink_es() {
		return art_webLink_es;
	}
	public void setArt_webLink_es(String art_webLink_es) {
		this.art_webLink_es = art_webLink_es;
	}
	public String getArt_webLink_fr() {
		return art_webLink_fr;
	}
	public void setArt_webLink_fr(String art_webLink_fr) {
		this.art_webLink_fr = art_webLink_fr;
	}
	public String getArt_imageLink() {
		return art_imageLink;
	}
	public void setArt_imageLink(String art_imageLink) {
		this.art_imageLink = art_imageLink;
	}

	public boolean isFound() {
		return found.get();
	}

	public void setFound(boolean found) {
		this.found.setValue(found);
	}
}
