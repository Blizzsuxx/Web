package beans.webshop;

import java.time.LocalDateTime;
import java.util.Objects;

public class Manifestacija {
    private long id;
    private String naziv;
    private String tip;
    private LocalDateTime datumVreme;
    private double cena;
    private boolean status;
    private String slika;
    private Lokacija lokacija;
    private long brojMesta;

    private int ocena;
    private String lokacijaPrikaz;
    private String vremePrikaz;
    
    private long zauzetBrojMesta;


    private static long ID;

    public long getZauzetBrojMesta() {
        return this.zauzetBrojMesta;
    }

    public void setZauzetBrojMesta(long zauzetBrojMesta) {
        this.zauzetBrojMesta = zauzetBrojMesta;
    }

    public Manifestacija zauzetBrojMesta(long zauzetBrojMesta) {
        setZauzetBrojMesta(zauzetBrojMesta);
        return this;
    }


    public int getOcena() {
        return this.ocena;
    }


    public String getLokacijaPrikaz() {
        return this.lokacijaPrikaz;
    }



    public String getVremePrikaz() {
        return this.vremePrikaz;
    }





    public Manifestacija(long id, String naziv, String tip, LocalDateTime datumVreme, double cena, boolean status, String slika, Lokacija lokacija, long brojMesta, long zauzetBrojMesta) {
        if(ID < id){
            ID = id;
            ID++;
        }
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.lokacija = lokacija;
        this.brojMesta = brojMesta;
        this.zauzetBrojMesta = zauzetBrojMesta;
        if(lokacija != null){
            this.lokacijaPrikaz = lokacija.getAdresa() + ": \r\n" + lokacija.getGeografskaDuzina() + "-" + lokacija.getGeografskaSirina();
        }
        this.vremePrikaz = this.datumVreme.format(Manager.dateTimeFormat);
    }

    public long getBrojMesta() {
        return this.brojMesta;
    }

    public void setBrojMesta(long brojMesta) {
        this.brojMesta = brojMesta;
    }

    public Manifestacija brojMesta(long brojMesta) {
        setBrojMesta(brojMesta);
        return this;
    }


    public Manifestacija() {
        this.id = ID;
        ID++;
    }


    public Manifestacija(long id, String naziv, String tip, LocalDateTime datumVreme, double cena, boolean status, String slika, Lokacija lokacija) {
        this.id = id;
        if(ID < id){
            ID = id;
            ID++;
        }
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.lokacija = lokacija;
        this.lokacijaPrikaz = lokacija.getAdresa() + ": " + lokacija.getGeografskaDuzina() + "-" + lokacija.getGeografskaSirina();
        this.vremePrikaz = this.datumVreme.format(Manager.dateTimeFormat);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manifestacija id(long id) {
        setId(id);
        return this;
    }



    public Manifestacija(String naziv, String tip, LocalDateTime datumVreme, double cena, boolean status, String slika, Lokacija lokacija) {
        this();
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.lokacija = lokacija;
        this.lokacijaPrikaz = lokacija.getAdresa() + ": " + lokacija.getGeografskaDuzina() + "-" + lokacija.getGeografskaSirina();
        this.vremePrikaz = this.datumVreme.format(Manager.dateTimeFormat);
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


    public Manifestacija(long id, String naziv, String tip, LocalDateTime datumVreme, double cena, boolean status, String slika, Lokacija lokacija, long brojMesta, int ocena, String lokacijaPrikaz, String vremePrikaz) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.lokacija = lokacija;
        this.brojMesta = brojMesta;
        this.ocena = ocena;
        this.lokacijaPrikaz = lokacijaPrikaz;
        this.vremePrikaz = vremePrikaz;
    }
    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
    public void setLokacijaPrikaz(String lokacijaPrikaz) {
        this.lokacijaPrikaz = lokacijaPrikaz;
    }
    public void setVremePrikaz(String vremePrikaz) {
        this.vremePrikaz = vremePrikaz;
    }

    public Manifestacija ocena(int ocena) {
        setOcena(ocena);
        return this;
    }

    public Manifestacija lokacijaPrikaz(String lokacijaPrikaz) {
        setLokacijaPrikaz(lokacijaPrikaz);
        return this;
    }

    public Manifestacija vremePrikaz(String vremePrikaz) {
        setVremePrikaz(vremePrikaz);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", naziv='" + getNaziv() + "'" +
            ", tip='" + getTip() + "'" +
            ", datumVreme='" + getDatumVreme() + "'" +
            ", cena='" + getCena() + "'" +
            ", status='" + isStatus() + "'" +
            ", slika='" + getSlika() + "'" +
            ", lokacija='" + getLokacija() + "'" +
            ", brojMesta='" + getBrojMesta() + "'" +
            ", ocena='" + getOcena() + "'" +
            ", lokacijaPrikaz='" + getLokacijaPrikaz() + "'" +
            ", vremePrikaz='" + getVremePrikaz() + "'" +
            "}";
    }


}
