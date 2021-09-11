package rest;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import beans.webshop.Korisnik;
import beans.webshop.KorisnikInfo;
import beans.webshop.Kupac;
import beans.webshop.Manager;
import beans.webshop.ProductToAdd;
import beans.webshop.Products;
import beans.webshop.ShoppingCart;
import spark.Request;
import spark.Session;

public class SparkWebShopMain {

	private static Products products = new Products();
	private static Gson g = new Gson();
	private static Manager podaci = new Manager();


	public static void main(String[] args) throws Exception {
		port(8080);
		
		staticFiles.externalLocation(new File("./static").getCanonicalPath()); 

		podaci.load();
		get("/test", (req, res) -> {
			return "Works";
		});
		
		get("/rest/proizvodi/getJustProducts", (req, res) -> {
			res.type("application/json");
			return g.toJson(products.values());
		});
		
		get("/rest/proizvodi/getJustSc", (req, res) -> {
			res.type("application/json");
			return g.toJson(getSc(req).getItems());
		});
		
		get("/rest/proizvodi/getTotal", (req, res) -> {
			res.type("application/json");
			return g.toJson(getSc(req).getTotal());
		});
		
		post("/rest/proizvodi/add", (req, res) -> {
			res.type("application/json");
			String payload = req.body();
			ProductToAdd pd = g.fromJson(payload, ProductToAdd.class);
			getSc(req).addItem(products.getProduct(pd.id), pd.count);
			return ("OK");
		});
		
		post("/rest/proizvodi/clearSc", (req, res) -> {
			res.type("application/json");
			getSc(req).getItems().clear();
			return "OK";
		});

		post("/rest/korisnici/prijava", (req, res) -> {
			res.type("application/json");
			String payload = req.body();
			KorisnikInfo pd = g.fromJson(payload, KorisnikInfo.class);
			Korisnik korisnik = podaci.login(pd);
			if (korisnik != null){
				Session ss = req.session(true);
				ss.attribute("korisnik", korisnik); 
			}
			return g.toJson(korisnik);
		});
	}
	
	private static ShoppingCart getSc(Request req) {
		Session ss = req.session(true);
		ShoppingCart sc = ss.attribute("sc"); 
		if (sc == null) {
			sc = new ShoppingCart();
			ss.attribute("sc", sc);
		}
		return sc;
	}


	private static Korisnik getKorisnik(Request req) {
		Session ss = req.session(true);
		Korisnik sc = ss.attribute("korisnik"); 
		if (sc == null) {
			return null;
		}
		return sc;
	}
}
