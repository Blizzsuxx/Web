package beans.webshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Prodavac extends Korisnik {

    private ArrayList<Manifestacija> manifestacije;
    

    public Prodavac() {
        this.manifestacije = new ArrayList<>();
    }

    public Prodavac(ArrayList<Manifestacija> manifestacije) {
        this.manifestacije = manifestacije;
    }


    public Prodavac(String username, String password, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga, ArrayList<Manifestacija> manifestacije) {
        super(username, password, ime, prezime, pol, datumRodjenja, uloga);
        this.manifestacije = manifestacije;
    }


    public ArrayList<Manifestacija> getManifestacije() {
        return this.manifestacije;
    }

    public void setManifestacije(ArrayList<Manifestacija> manifestacije) {
        this.manifestacije = manifestacije;
    }

    public Prodavac manifestacije(ArrayList<Manifestacija> manifestacije) {
        setManifestacije(manifestacije);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Prodavac)) {
            return false;
        }
        Prodavac prodavac = (Prodavac) o;
        return Objects.equals(manifestacije, prodavac.manifestacije);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(manifestacije);
    }

    @Override
    public String toString() {
        return "{" +
            " manifestacije='" + getManifestacije() + "'" +
            "}";
    }
    
}
