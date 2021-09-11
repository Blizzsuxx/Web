package beans.webshop;

import java.time.LocalDate;
import java.util.Objects;
/** Reprezentuje jedan proizvod. Cuva se id, naziv i jedinicna cena. */
public class Korisnik {

	private String username;
	private String password;
	private String ime;
	private String prezime;
	private LocalDate datumRodjenja;
    private Uloga uloga;
    
	private Pol pol;


	/** Koristi se samo za AngularJS */

	public Korisnik() {
	}
	
	

    public Korisnik(String username, String password, String ime, String prezime, Pol pol, LocalDate datumRodjenja, Uloga uloga) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return this.pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public LocalDate getDatumRodjenja() {
        return this.datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return this.uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }



    public Korisnik username(String username) {
        setUsername(username);
        return this;
    }

    public Korisnik password(String password) {
        setPassword(password);
        return this;
    }

    public Korisnik ime(String ime) {
        setIme(ime);
        return this;
    }

    public Korisnik prezime(String prezime) {
        setPrezime(prezime);
        return this;
    }

    public Korisnik pol(Pol pol) {
        setPol(pol);
        return this;
    }

    public Korisnik datumRodjenja(LocalDate datumRodjenja) {
        setDatumRodjenja(datumRodjenja);
        return this;
    }

    public Korisnik uloga(Uloga uloga) {
        setUloga(uloga);
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Korisnik)) {
            return false;
        }
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(username, korisnik.username) && Objects.equals(password, korisnik.password) && Objects.equals(ime, korisnik.ime) && Objects.equals(prezime, korisnik.prezime) && Objects.equals(pol, korisnik.pol) && Objects.equals(datumRodjenja, korisnik.datumRodjenja) && Objects.equals(uloga, korisnik.uloga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, ime, prezime, pol, datumRodjenja, uloga);
    }
	


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", ime='" + getIme() + "'" +
            ", prezime='" + getPrezime() + "'" +
            ", pol='" + getPol() + "'" +
            ", datumRodjenja='" + getDatumRodjenja() + "'" +
            ", uloga='" + getUloga() + "'" +
            "}";
    }


	
}
