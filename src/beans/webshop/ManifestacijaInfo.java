package beans.webshop;

import java.util.Objects;

public class ManifestacijaInfo {

    public String naziv;
    public String tip;
    public String datumVreme;
    public String cena;
    public String status;
    public String slika;
    public String geografskaSirina;
    public String geografskaDuzina;
    public String adresa;
    public String brojMesta;



    public ManifestacijaInfo() {
    }

    public ManifestacijaInfo(String naziv, String tip, String datumVreme, String cena, String status, String slika, String geografskaSirina, String geografskaDuzina, String adresa, String brojMesta) {
        this.naziv = naziv;
        this.tip = tip;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.status = status;
        this.slika = slika;
        this.geografskaSirina = geografskaSirina;
        this.geografskaDuzina = geografskaDuzina;
        this.adresa = adresa;
        this.brojMesta = brojMesta;
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

    public String getDatumVreme() {
        return this.datumVreme;
    }

    public void setDatumVreme(String datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getCena() {
        return this.cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlika() {
        return this.slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getGeografskaSirina() {
        return this.geografskaSirina;
    }

    public void setGeografskaSirina(String geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public String getGeografskaDuzina() {
        return this.geografskaDuzina;
    }

    public void setGeografskaDuzina(String geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojMesta() {
        return this.brojMesta;
    }

    public void setBrojMesta(String brojMesta) {
        this.brojMesta = brojMesta;
    }

    public ManifestacijaInfo naziv(String naziv) {
        setNaziv(naziv);
        return this;
    }

    public ManifestacijaInfo tip(String tip) {
        setTip(tip);
        return this;
    }

    public ManifestacijaInfo datumVreme(String datumVreme) {
        setDatumVreme(datumVreme);
        return this;
    }

    public ManifestacijaInfo cena(String cena) {
        setCena(cena);
        return this;
    }

    public ManifestacijaInfo status(String status) {
        setStatus(status);
        return this;
    }

    public ManifestacijaInfo slika(String slika) {
        setSlika(slika);
        return this;
    }

    public ManifestacijaInfo geografskaSirina(String geografskaSirina) {
        setGeografskaSirina(geografskaSirina);
        return this;
    }

    public ManifestacijaInfo geografskaDuzina(String geografskaDuzina) {
        setGeografskaDuzina(geografskaDuzina);
        return this;
    }

    public ManifestacijaInfo adresa(String adresa) {
        setAdresa(adresa);
        return this;
    }

    public ManifestacijaInfo brojMesta(String brojMesta) {
        setBrojMesta(brojMesta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ManifestacijaInfo)) {
            return false;
        }
        ManifestacijaInfo manifestacijaInfo = (ManifestacijaInfo) o;
        return Objects.equals(naziv, manifestacijaInfo.naziv) && Objects.equals(tip, manifestacijaInfo.tip) && Objects.equals(datumVreme, manifestacijaInfo.datumVreme) && Objects.equals(cena, manifestacijaInfo.cena) && Objects.equals(status, manifestacijaInfo.status) && Objects.equals(slika, manifestacijaInfo.slika) && Objects.equals(geografskaSirina, manifestacijaInfo.geografskaSirina) && Objects.equals(geografskaDuzina, manifestacijaInfo.geografskaDuzina) && Objects.equals(adresa, manifestacijaInfo.adresa) && Objects.equals(brojMesta, manifestacijaInfo.brojMesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, tip, datumVreme, cena, status, slika, geografskaSirina, geografskaDuzina, adresa, brojMesta);
    }

    @Override
    public String toString() {
        return "{" +
            " naziv='" + getNaziv() + "'" +
            ", tip='" + getTip() + "'" +
            ", datumVreme='" + getDatumVreme() + "'" +
            ", cena='" + getCena() + "'" +
            ", status='" + getStatus() + "'" +
            ", slika='" + getSlika() + "'" +
            ", geografskaSirina='" + getGeografskaSirina() + "'" +
            ", geografskaDuzina='" + getGeografskaDuzina() + "'" +
            ", adresa='" + getAdresa() + "'" +
            ", brojMesta='" + getBrojMesta() + "'" +
            "}";
    }

    
}
