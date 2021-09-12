package beans.webshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Manager {
    private ArrayList<Kupac> kupci;
    private ArrayList<Prodavac> prodavci;
    private ArrayList<Manifestacija> manifestacije;
    private ArrayList<Karta> karte;
    private ArrayList<Komentar> komentari;
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    

    public Korisnik login(KorisnikInfo info){
        for(Korisnik k : kupci){
            if (k.getUsername().equals(info.username) && k.getPassword().equals(info.getPassword())){
                return k;
            }
        }
        return null;
    }


    public Korisnik findKorisnik(String username){
        if(username == null || username.equals("")){
            return null;
        }
        for (Korisnik k : kupci){
            if (k.getUsername().equals(username)){
                return k;
            }
        }

        for (Korisnik k : prodavci){
            if (k.getUsername().equals(username)){
                return k;
            }
        }

        return null;
    }

    private void loadKupci() throws IOException{



        BufferedReader in = new BufferedReader(new FileReader("./kupci.txt"));
        String line, username = "", password = "", ime = "", prezime = "", datum = "", uloga = "", pol = "", brojBodova = "", karte = "", tipKupca = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					username = st.nextToken().trim();
					password = st.nextToken().trim();
					ime = st.nextToken().trim();
					prezime = st.nextToken().trim();
					pol = st.nextToken().trim();
					datum = st.nextToken().trim();
					uloga = st.nextToken().trim();
					brojBodova = st.nextToken().trim();
					karte = st.nextToken().trim();
					tipKupca = st.nextToken().trim();
				}
				Kupac kupac = new Kupac(username, password, ime, prezime, Pol.valueOf(pol), format.parse(datum), Uloga.valueOf(uloga), Integer.parseInt(brojBodova), null, null);
				kupci.add(kupac);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        in.close();




    }






    private void loadProdavci() throws IOException{



        BufferedReader in = new BufferedReader(new FileReader("./prodavci.txt"));
        String line, username = "", password = "", ime = "", prezime = "", datum = "", uloga = "", pol = "", manifestacije = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					username = st.nextToken().trim();
					password = st.nextToken().trim();
					ime = st.nextToken().trim();
					prezime = st.nextToken().trim();
					pol = st.nextToken().trim();
					datum = st.nextToken().trim();
					uloga = st.nextToken().trim();
					manifestacije = st.nextToken().trim();
				}
				Prodavac prodavac = new Prodavac(username, password, ime, prezime, Pol.valueOf(pol), format.parse(datum), Uloga.valueOf(uloga), null);
				prodavci.add(prodavac);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        in.close();




    }



    private void loadKomentari() throws IOException{



        BufferedReader in = new BufferedReader(new FileReader("./komentari.txt"));
        String line, username = "", manifestacija = "", tekst = "", ocena = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					username = st.nextToken().trim();
					manifestacija = st.nextToken().trim();
					tekst = st.nextToken().trim();
					ocena = st.nextToken().trim();
				}
				Komentar komentar = new Komentar(null, null, tekst, Integer.parseInt(ocena));
				komentari.add(komentar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        in.close();




    }




    private void loadKarte() throws IOException{



        BufferedReader in = new BufferedReader(new FileReader("./karte.txt"));
        String line, id = "", manifestacija = "", datumVreme = "", cena = "", kupacIme = "", kupacPrezime = "", status = "", tip = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					manifestacija = st.nextToken().trim();
					datumVreme = st.nextToken().trim();
					cena = st.nextToken().trim();
					kupacIme = st.nextToken().trim();
					kupacPrezime = st.nextToken().trim();
					status = st.nextToken().trim();
					tip = st.nextToken().trim();
				}
				Karta karta = new Karta(Long.parseLong(id), null, LocalDateTime.parse(datumVreme, dateTimeFormat), Double.parseDouble(cena), kupacIme, kupacPrezime, Boolean.parseBoolean(status), TipKarte.valueOf(tip));
				karte.add(karta);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        in.close();




    }



    private void loadManifestacije() throws IOException{



        BufferedReader in = new BufferedReader(new FileReader("./manifestacije.txt"));
        String line, id = "", naziv = "", tip = "", datumVreme = "", cena = "", status = "", slika = "", lokacija = "", brojMesta = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					naziv = st.nextToken().trim();
					tip = st.nextToken().trim();
					datumVreme = st.nextToken().trim();
					cena = st.nextToken().trim();
					status = st.nextToken().trim();
					slika = st.nextToken().trim();
					lokacija = st.nextToken().trim();
					brojMesta = st.nextToken().trim();

				}
				Manifestacija manifestacija = new Manifestacija(Long.parseLong(id), naziv, tip, LocalDateTime.parse(datumVreme, dateTimeFormat), Double.parseDouble(cena), Boolean.parseBoolean(status), slika, null, Long.parseLong(brojMesta));
				manifestacije.add(manifestacija);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        in.close();




    }




    public void load(){
        
        try {
            loadKupci();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            loadProdavci();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            loadKarte();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            loadKomentari();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            loadManifestacije();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    

    public Manager() {
        this.kupci = new ArrayList<>();
        this.prodavci = new ArrayList<>();
        this.manifestacije = new ArrayList<>();
        this.karte = new ArrayList<>();
        this.komentari = new ArrayList<>();

    }

    public Manager(ArrayList<Kupac> korisnici, ArrayList<Manifestacija> manifestacije, ArrayList<Karta> karte, ArrayList<Komentar> komentari) {
        this.kupci = korisnici;
        this.manifestacije = manifestacije;
        this.karte = karte;
        this.komentari = komentari;
    }

    public ArrayList<Kupac> getKorisnici() {
        return this.kupci;
    }

    public void setKorisnici(ArrayList<Kupac> korisnici) {
        this.kupci = korisnici;
    }

    public ArrayList<Manifestacija> getManifestacije() {
        return this.manifestacije;
    }

    public void setManifestacije(ArrayList<Manifestacija> manifestacije) {
        this.manifestacije = manifestacije;
    }

    public ArrayList<Karta> getKarte() {
        return this.karte;
    }

    public void setKarte(ArrayList<Karta> karte) {
        this.karte = karte;
    }

    public ArrayList<Komentar> getKomentari() {
        return this.komentari;
    }

    public void setKomentari(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }

    public Manager korisnici(ArrayList<Kupac> korisnici) {
        setKorisnici(korisnici);
        return this;
    }

    public Manager manifestacije(ArrayList<Manifestacija> manifestacije) {
        setManifestacije(manifestacije);
        return this;
    }

    public Manager karte(ArrayList<Karta> karte) {
        setKarte(karte);
        return this;
    }

    public Manager komentari(ArrayList<Komentar> komentari) {
        setKomentari(komentari);
        return this;
    }


 

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manager)) {
            return false;
        }
        Manager manager = (Manager) o;
        return Objects.equals(kupci, manager.kupci) && Objects.equals(prodavci, manager.prodavci) && Objects.equals(manifestacije, manager.manifestacije) && Objects.equals(karte, manager.karte) && Objects.equals(komentari, manager.komentari);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kupci, prodavci, manifestacije, karte, komentari);
    }

    @Override
    public String toString() {
        return "{" +
            " kupci='" + getKupci() + "'" +
            ", prodavci='" + getProdavci() + "'" +
            ", manifestacije='" + getManifestacije() + "'" +
            ", karte='" + getKarte() + "'" +
            ", komentari='" + getKomentari() + "'" +
            "}";
    }





    public Manager(ArrayList<Kupac> kupci, ArrayList<Prodavac> prodavci, ArrayList<Manifestacija> manifestacije, ArrayList<Karta> karte, ArrayList<Komentar> komentari) {
        this.kupci = kupci;
        this.prodavci = prodavci;
        this.manifestacije = manifestacije;
        this.karte = karte;
        this.komentari = komentari;
    }

    public ArrayList<Kupac> getKupci() {
        return this.kupci;
    }

    public void setKupci(ArrayList<Kupac> kupci) {
        this.kupci = kupci;
    }

    public ArrayList<Prodavac> getProdavci() {
        return this.prodavci;
    }

    public void setProdavci(ArrayList<Prodavac> prodavci) {
        this.prodavci = prodavci;
    }

    public Manager kupci(ArrayList<Kupac> kupci) {
        setKupci(kupci);
        return this;
    }

    public Manager prodavci(ArrayList<Prodavac> prodavci) {
        setProdavci(prodavci);
        return this;
    }


}
