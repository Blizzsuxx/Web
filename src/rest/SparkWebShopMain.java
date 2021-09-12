package rest;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.io.File;
import java.time.LocalDateTime;

import com.google.gson.Gson;

import beans.webshop.Karta;
import beans.webshop.Korisnik;
import beans.webshop.KorisnikInfo;
import beans.webshop.Kupac;
import beans.webshop.Manager;
import beans.webshop.Manifestacija;
import beans.webshop.ProductToAdd;
import beans.webshop.Products;
import beans.webshop.ShoppingCart;
import beans.webshop.TipKarte;
import beans.webshop.rezervacija;
import spark.Request;
import spark.Session;

public class SparkWebShopMain {

	private static Products products = new Products();
	private static Gson g = new Gson();
	private static Manager podaci = new Manager();

	private static Korisnik trenutniKorisnik; // OVO JE PRIVREMENO JER SE ID SESIJE MENJA SVAKI PUT KAD NAPRAVIM HTTP REQUEST


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
				trenutniKorisnik = korisnik;
			}
			return g.toJson(korisnik);
		});


		post("/rest/korisnici/dodajKupca", (req, res) -> {
			res.type("application/json");
			String payload = req.body();
			KorisnikInfo pd = g.fromJson(payload, KorisnikInfo.class);

			Korisnik korisnik = podaci.findKorisnik(pd.getUsername());
			if (korisnik != null){
				return false;
			}
			Kupac kupac = new Kupac(pd);
			podaci.getKupci().add(kupac);
			System.out.println(pd);
			return true;
		});


		get("/rest/kupci/dobaviTrenutnogKupca", (req, res) -> {
			res.type("application/json");
			return g.toJson((Kupac)getKorisnik(req));
		});


		get("/rest/manifestacije/dobaviManifestacije", (req, res) -> {
			res.type("application/json");
			return g.toJson(podaci.getManifestacije());
		});

		post("/rest/manifestacije/dobaviKomentare", (req, res) ->{
			res.type("application/json");

			String payload = req.body();
			Manifestacija pd = g.fromJson(payload, Manifestacija.class);
			
			return g.toJson(podaci.nabaviKomentareDogadjaja(pd.getId()));

		}); 


		post("/rest/karte/rezervisiKarte", (req, res) ->{
			res.type("application/json");

			String payload = req.body();
			rezervacija pd = g.fromJson(payload, rezervacija.class);
			Manifestacija m = podaci.findManifestacija(pd.getId());
			if (m.getDatumVreme().isBefore(LocalDateTime.now()) || m.getZauzetBrojMesta() + pd.getRegularne()+ pd.getVip()+ pd.getFanParti() > m.getBrojMesta() || !m.getStatus()){
				return false;
			}
			m.setZauzetBrojMesta(m.getZauzetBrojMesta() + pd.getRegularne()+ pd.getVip()+ pd.getFanParti());
			Kupac k = (Kupac) getKorisnik(req);
			for (int i = 0; i < pd.getRegularne(); i++){
				Karta karta = new Karta(m, m.getDatumVreme(), m.getCena() - (m.getCena() / (100/k.getTipKupca().getPopust())), k.getIme(), k.getPrezime(), false, TipKarte.REGULAR);
				Double bodovi = karta.getCena()/1000 * 133;
				k.setBrojBodova(k.getBrojBodova()+ bodovi.intValue());
				podaci.getKarte().add(karta);
			}
			for (int i = 0; i < pd.getFanParti(); i++){
				Karta karta = new Karta(m, m.getDatumVreme(), (m.getCena()*2) - ((m.getCena()*2) / (100/k.getTipKupca().getPopust())), k.getIme(), k.getPrezime(), false, TipKarte.FAN_PIT);
				Double bodovi = karta.getCena()/1000 * 133;
				podaci.getKarte().add(karta);
				k.setBrojBodova(k.getBrojBodova()+ bodovi.intValue());
			}
			for (int i = 0; i < pd.getVip(); i++){
				Karta karta = new Karta(m, m.getDatumVreme(), (m.getCena()*4) - ((m.getCena()*4) / (100/k.getTipKupca().getPopust())), k.getIme(), k.getPrezime(), false, TipKarte.VIP);
				Double bodovi = karta.getCena()/1000 * 133;
				podaci.getKarte().add(karta);
				k.setBrojBodova(k.getBrojBodova()+ bodovi.intValue());
			}
			return true;

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
		if (sc == null && trenutniKorisnik != null) {
			return trenutniKorisnik;
		}
		return sc;
	}
}
