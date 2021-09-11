package beans.webshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Manager {
    private ArrayList<Kupac> kupci;
    private ArrayList<Prodavac> prodavci;
    private ArrayList<Manifestacija> manifestacije;
    private ArrayList<Karta> karte;
    private ArrayList<Komentar> komentari;
    

    public Korisnik login(KorisnikInfo info){
        for(Korisnik k : kupci){
            if (k.getUsername().equals(info.username) && k.getPassword().equals(info.getPassword())){
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
				Kupac kupac = new Kupac(username, password, ime, prezime, Pol.valueOf(pol), LocalDate.parse(datum), Uloga.valueOf(uloga), Integer.parseInt(brojBodova), null, null);
				kupci.add(kupac);
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
