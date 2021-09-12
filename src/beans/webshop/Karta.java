package beans.webshop;

import java.time.LocalDateTime;
import java.util.Objects;

public class Karta {
    private long id;
    private Manifestacija manifestacija;
    private LocalDateTime datumVreme;
    private double cena;
    private String kupacIme;
    private String kupacPrezime;
    private boolean status;
    private TipKarte tip;

    private static long ID = 10;
    public Karta() {
        this.id = ID;
        ID++;
    }

    public Karta(long id, Manifestacija manifestacija, LocalDateTime datumVreme, double cena, String kupacIme, String kupacPrezime, boolean status, TipKarte tip) {
        this.id = id;
        this.manifestacija = manifestacija;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.kupacIme = kupacIme;
        this.kupacPrezime = kupacPrezime;
        this.status = status;
        this.tip = tip;
    }

    public Karta(Manifestacija manifestacija, LocalDateTime datumVreme, double cena, String kupacIme, String kupacPrezime, boolean status, TipKarte tip) {
        this.manifestacija = manifestacija;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.kupacIme = kupacIme;
        this.kupacPrezime = kupacPrezime;
        this.status = status;
        this.tip = tip;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manifestacija getManifestacija() {
        return this.manifestacija;
    }

    public void setManifestacija(Manifestacija manifestacija) {
        this.manifestacija = manifestacija;
    }

    public LocalDateTime getDatumVreme() {
        return this.datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCena() {
        return this.cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getKupacIme() {
        return this.kupacIme;
    }

    public void setKupacIme(String kupacIme) {
        this.kupacIme = kupacIme;
    }

    public String getKupacPrezime() {
        return this.kupacPrezime;
    }

    public void setKupacPrezime(String kupacPrezime) {
        this.kupacPrezime = kupacPrezime;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TipKarte getTip() {
        return this.tip;
    }

    public void setTip(TipKarte tip) {
        this.tip = tip;
    }

    public Karta id(long id) {
        setId(id);
        return this;
    }

    public Karta manifestacija(Manifestacija manifestacija) {
        setManifestacija(manifestacija);
        return this;
    }

    public Karta datumVreme(LocalDateTime datumVreme) {
        setDatumVreme(datumVreme);
        return this;
    }

    public Karta cena(double cena) {
        setCena(cena);
        return this;
    }

    public Karta kupacIme(String kupacIme) {
        setKupacIme(kupacIme);
        return this;
    }

    public Karta kupacPrezime(String kupacPrezime) {
        setKupacPrezime(kupacPrezime);
        return this;
    }

    public Karta status(boolean status) {
        setStatus(status);
        return this;
    }

    public Karta tip(TipKarte tip) {
        setTip(tip);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Karta)) {
            return false;
        }
        Karta karta = (Karta) o;
        return id == karta.id && Objects.equals(manifestacija, karta.manifestacija) && Objects.equals(datumVreme, karta.datumVreme) && cena == karta.cena && Objects.equals(kupacIme, karta.kupacIme) && Objects.equals(kupacPrezime, karta.kupacPrezime) && status == karta.status && Objects.equals(tip, karta.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manifestacija, datumVreme, cena, kupacIme, kupacPrezime, status, tip);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", manifestacija='" + getManifestacija() + "'" +
            ", datumVreme='" + getDatumVreme() + "'" +
            ", cena='" + getCena() + "'" +
            ", kupacIme='" + getKupacIme() + "'" +
            ", kupacPrezime='" + getKupacPrezime() + "'" +
            ", status='" + isStatus() + "'" +
            ", tip='" + getTip() + "'" +
            "}";
    }


}
