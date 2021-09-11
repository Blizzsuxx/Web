package beans.webshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Kupac extends Korisnik {
    
    private int brojBodova;
    private ArrayList<Karta> karte;
    private TipKupca tipKupca;
    

    public Kupac() {
        super();
    }

    public Kupac(int brojBodova, ArrayList<Karta> karte) {
        this.brojBodova = brojBodova;
        this.karte = karte;
    }

    public Kupac(int brojBodova) {
        this.brojBodova = brojBodova;
        this.karte = new ArrayList<>();
    }


    public Kupac(String username, String password, String ime, String prezime, Pol pol, LocalDate datumRodjenja, Uloga uloga, int brojBodova, ArrayList<Karta> karte, TipKupca tip) {
        super(username, password, ime, prezime, pol, datumRodjenja, uloga);
        this.brojBodova = brojBodova;
        this.karte = karte;
        this.tipKupca = tip;
    }


    public Kupac(String username, String password, String ime, String prezime, Pol pol, LocalDate datumRodjenja, Uloga uloga, int brojBodova) {
        super(username, password, ime, prezime, pol, datumRodjenja, uloga);
        this.brojBodova = brojBodova;
        this.karte = new ArrayList<>();
    }

    public int getBrojBodova() {
        return this.brojBodova;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }

    public ArrayList<Karta> getKarte() {
        return this.karte;
    }

    public void setKarte(ArrayList<Karta> karte) {
        this.karte = karte;
    }

    public Kupac brojBodova(int brojBodova) {
        setBrojBodova(brojBodova);
        return this;
    }

    public Kupac karte(ArrayList<Karta> karte) {
        setKarte(karte);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Kupac)) {
            return false;
        }
        Kupac kupac = (Kupac) o;
        return brojBodova == kupac.brojBodova && Objects.equals(karte, kupac.karte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brojBodova, karte);
    }



    public Kupac(int brojBodova, ArrayList<Karta> karte, TipKupca tipKupca) {
        this.brojBodova = brojBodova;
        this.karte = karte;
        this.tipKupca = tipKupca;
    }

    public TipKupca getTipKupca() {
        return this.tipKupca;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
    }

    public Kupac tipKupca(TipKupca tipKupca) {
        setTipKupca(tipKupca);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " brojBodova='" + getBrojBodova() + "'" +
            ", karte='" + getKarte() + "'" +
            ", tipKupca='" + getTipKupca() + "'" +
            "}";
    }


}
