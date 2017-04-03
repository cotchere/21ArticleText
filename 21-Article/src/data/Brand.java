package data;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Brand extends RecursiveTreeObject<Article>{

	private String name;
	private String brand_link_de;
	private String brand_link_uk;
	private String brand_link_es;
	private String brand_link_fr;

	private final List<Article> articles = new ArrayList<Article>();
	
	public Brand(String name, String brand_link_de, String brand_link_uk, String brand_link_es, String brand_link_fr) {
		super();
		this.name = name;
		this.brand_link_de = brand_link_de;
		this.brand_link_uk = brand_link_uk;
		this.brand_link_es = brand_link_es;
		this.brand_link_fr = brand_link_fr;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand_link_de() {
		return brand_link_de;
	}


	public void setBrand_link_de(String brand_link_de) {
		this.brand_link_de = brand_link_de;
	}


	public String getBrand_link_uk() {
		return brand_link_uk;
	}


	public void setBrand_link_uk(String brand_link_en) {
		this.brand_link_uk = brand_link_en;
	}


	public String getBrand_link_es() {
		return brand_link_es;
	}


	public void setBrand_link_es(String brand_link_es) {
		this.brand_link_es = brand_link_es;
	}


	public String getBrand_link_fr() {
		return brand_link_fr;
	}


	public void setBrand_link_fr(String brand_link_fr) {
		this.brand_link_fr = brand_link_fr;
	}


	public List<Article> getArticles() {
		return articles;
	}
	
	public void addArticleToBrand(Article a){
		this.articles.add(a);
	}
}
