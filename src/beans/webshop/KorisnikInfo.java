package beans.webshop;

import java.util.Objects;

public class KorisnikInfo {
    public String username;
    public String password;
    public String ime;
    public String prezime;
    public String datumRodjenja;
    public String uloga;
    public String pol;


    public KorisnikInfo(String username, String password, String ime, String prezime, String datumRodjenja, String uloga, String pol) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.pol = pol;
    }

    public String getUloga() {
        return this.uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getPol() {
        return this.pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public KorisnikInfo uloga(String uloga) {
        setUloga(uloga);
        return this;
    }

    public KorisnikInfo pol(String pol) {
        setPol(pol);
        return this;
    }

    public KorisnikInfo(String username, String password, String ime, String prezime, String datumRodjenja) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
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

    public String getDatumRodjenja() {
        return this.datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public KorisnikInfo ime(String ime) {
        setIme(ime);
        return this;
    }

    public KorisnikInfo prezime(String prezime) {
        setPrezime(prezime);
        return this;
    }

    public KorisnikInfo datumRodjenja(String datumRodjenja) {
        setDatumRodjenja(datumRodjenja);
        return this;
    }

    public KorisnikInfo() {
    }

    public KorisnikInfo(String username, String password) {
        this.username = username;
        this.password = password;
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

    public KorisnikInfo username(String username) {
        setUsername(username);
        return this;
    }

    public KorisnikInfo password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof KorisnikInfo)) {
            return false;
        }
        KorisnikInfo korisnikInfo = (KorisnikInfo) o;
        return Objects.equals(username, korisnikInfo.username) && Objects.equals(password, korisnikInfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}
