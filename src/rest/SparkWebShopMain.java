package rest;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;

import beans.webshop.Karta;
import beans.webshop.Korisnik;
import beans.webshop.KorisnikInfo;
import beans.webshop.Kupac;
import beans.webshop.Manager;
import beans.webshop.Manifestacija;
import beans.webshop.ManifestacijaInfo;
import beans.webshop.TipKarte;
import beans.webshop.Uloga;
import beans.webshop.rezervacija;
import spark.Request;
import spark.Session;

import java.time.temporal.ChronoUnit;
public class SparkWebShopMain {

	private static Gson g = new Gson();
	private static Manager podaci = new Manager();

	private static Korisnik trenutniKorisnik; // OVO JE PRIVREMENO JER SE ID SESIJE MENJA SVAKI PUT KAD NAPRAVIM HTTP REQUEST


	public static void main(String[] args) throws Exception {
		port(8080);
		
		staticFiles.externalLocation(new File("./static").getCanonicalPath()); 

		podaci.load();
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

		get("/rest/Korisnici/dobaviTrenutnogKorisnika", (req, res) -> {
			res.type("application/json");
			return g.toJson(getKorisnik(req));
		});


		get("/rest/Karte/dobaviKarte", (req, res) -> {
			res.type("application/json");
			Korisnik k = getKorisnik(req);
			if(k.getUloga().equals(Uloga.KUPAC)){
				return g.toJson(((Kupac) k).getKarte());
			} else if(k.getUloga().equals(Uloga.PRODAVAC)){
				return g.toJson(podaci.nabaviRezervisaneKarte());
			} else {
				return g.toJson(podaci.getKarte());
			}
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



		post("rest/Manifestacija/sacuvajPromene", (req, res) ->{
			res.type("application/json");

			//String payload = req.body();
			//ManifestacijaInfo pd = g.fromJson(payload, ManifestacijaInfo.class);
			
			//LocalDate d = LocalDate.parse(pd.getDatumVreme());
			//Manifestacija m = new Manifestacija(naziv, tip, datumVreme, Double.parseDouble(pd.cena), false, slika, lokacija)


			return g.toJson(false);

		}); 


		post("rest/Korisnici/sacuvajPromene", (req, res) ->{
			res.type("application/json");

			String payload = req.body();
			KorisnikInfo pd = g.fromJson(payload, KorisnikInfo.class);
			
			Korisnik k = getKorisnik(req);
			k.setIme(pd.ime);
			k.setPrezime(pd.prezime);
			try{
				k.setDatumRodjenja(Manager.format.parse(pd.datumRodjenja));
			}catch(Exception e){

			}
			k.setPassword(pd.password);
			return true;

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
				Karta karta = new Karta(m, m.getDatumVreme(), m.getCena() - (m.getCena() / (100/k.getTipKupca().getPopust())), k.getIme(), k.getPrezime(), true, TipKarte.REGULAR);
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

		post("/rest/karte/otkaziKartu", (req, res) ->{
			res.type("application/json");

			String payload = req.body();
			rezervacija pd = g.fromJson(payload, rezervacija.class);
			Manifestacija m = podaci.findManifestacija(pd.getId());
			LocalDateTime now = LocalDateTime.now();
			Karta otkKarta = podaci.findKarta(pd.getId());
			long noOfDaysBetween = ChronoUnit.DAYS.between(now, otkKarta.getDatumVreme());
			if (now.isAfter(otkKarta.getDatumVreme()) || noOfDaysBetween < 7  || !otkKarta.getStatus()){
				return false;
			}
			otkKarta.setStatus(false);
			m.setZauzetBrojMesta(m.getZauzetBrojMesta() - 1);
			Kupac k = (Kupac) getKorisnik(req);
			int a =(int) (k.getBrojBodova() - otkKarta.getCena()/1000 * 133 * 4);
			k.setBrojBodova( a);
			return true;

		}); 
		
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
