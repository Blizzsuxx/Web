package beans.webshop;

import java.time.LocalDateTime;
import java.util.Objects;

public class Manifestacija {
    private String naziv;
    private String tip;
    private LocalDateTime datumVreme;
    private double cena;
    private boolean status;
    private String slika;
    private Lokacija lokacija;


    public Manifestacija() {
    }

    public Manifestacija(String naziv, String tip, LocalDateTime datumVreme, double cena, boolean status, String slika, Lokacija lokacija) {
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.lokacija = lokacija;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
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

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSlika() {
        return this.slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public Lokacija getLokacija() {
        return this.lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Manifestacija naziv(String naziv) {
        setNaziv(naziv);
        return this;
    }

    public Manifestacija tip(String tip) {
        setTip(tip);
        return this;
    }

    public Manifestacija datumVreme(LocalDateTime datumVreme) {
        setDatumVreme(datumVreme);
        return this;
    }

    public Manifestacija cena(double cena) {
        setCena(cena);
        return this;
    }

    public Manifestacija status(boolean status) {
        setStatus(status);
        return this;
    }

    public Manifestacija slika(String slika) {
        setSlika(slika);
        return this;
    }

    public Manifestacija lokacija(Lokacija lokacija) {
        setLokacija(lokacija);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manifestacija)) {
            return false;
        }
        Manifestacija manifestacija = (Manifestacija) o;
        return Objects.equals(naziv, manifestacija.naziv) && Objects.equals(tip, manifestacija.tip) && Objects.equals(datumVreme, manifestacija.datumVreme) && cena == manifestacija.cena && status == manifestacija.status && Objects.equals(slika, manifestacija.slika) && Objects.equals(lokacija, manifestacija.lokacija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, tip, datumVreme, cena, status, slika, lokacija);
    }

    @Override
    public String toString() {
        return "{" +
            " naziv='" + getNaziv() + "'" +
            ", tip='" + getTip() + "'" +
            ", datumVreme='" + getDatumVreme() + "'" +
            ", cena='" + getCena() + "'" +
            ", status='" + isStatus() + "'" +
            ", slika='" + getSlika() + "'" +
            ", lokacija='" + getLokacija() + "'" +
            "}";
    }

}
