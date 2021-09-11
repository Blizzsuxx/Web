package beans.webshop;

import java.util.Objects;

public class Komentar {
    private Kupac kupac;
    private Manifestacija manifestacija;
    private String tekst;
    private int ocena;


    public Komentar() {
    }

    public Komentar(Kupac kupac, Manifestacija manifestacija, String tekst, int ocena) {
        this.kupac = kupac;
        this.manifestacija = manifestacija;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public Kupac getKupac() {
        return this.kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Manifestacija getManifestacija() {
        return this.manifestacija;
    }

    public void setManifestacija(Manifestacija manifestacija) {
        this.manifestacija = manifestacija;
    }

    public String getTekst() {
        return this.tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOcena() {
        return this.ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Komentar kupac(Kupac kupac) {
        setKupac(kupac);
        return this;
    }

    public Komentar manifestacija(Manifestacija manifestacija) {
        setManifestacija(manifestacija);
        return this;
    }

    public Komentar tekst(String tekst) {
        setTekst(tekst);
        return this;
    }

    public Komentar ocena(int ocena) {
        setOcena(ocena);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Komentar)) {
            return false;
        }
        Komentar komentar = (Komentar) o;
        return Objects.equals(kupac, komentar.kupac) && Objects.equals(manifestacija, komentar.manifestacija) && Objects.equals(tekst, komentar.tekst) && ocena == komentar.ocena;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kupac, manifestacija, tekst, ocena);
    }

    @Override
    public String toString() {
        return "{" +
            " kupac='" + getKupac() + "'" +
            ", manifestacija='" + getManifestacija() + "'" +
            ", tekst='" + getTekst() + "'" +
            ", ocena='" + getOcena() + "'" +
            "}";
    }

}
