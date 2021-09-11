package beans.webshop;

import java.util.Objects;

public class Lokacija {

    private double geografskaSirina;
    private double geografskaDuzina;
    private String adresa;
    



    public Lokacija() {
    }

    public Lokacija(double geografskaSirina, double geografskaDuzina, String adresa) {
        this.geografskaSirina = geografskaSirina;
        this.geografskaDuzina = geografskaDuzina;
        this.adresa = adresa;
    }

    public double getGeografskaSirina() {
        return this.geografskaSirina;
    }

    public void setGeografskaSirina(double geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public double getGeografskaDuzina() {
        return this.geografskaDuzina;
    }

    public void setGeografskaDuzina(double geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Lokacija geografskaSirina(double geografskaSirina) {
        setGeografskaSirina(geografskaSirina);
        return this;
    }

    public Lokacija geografskaDuzina(double geografskaDuzina) {
        setGeografskaDuzina(geografskaDuzina);
        return this;
    }

    public Lokacija adresa(String adresa) {
        setAdresa(adresa);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lokacija)) {
            return false;
        }
        Lokacija lokacija = (Lokacija) o;
        return geografskaSirina == lokacija.geografskaSirina && geografskaDuzina == lokacija.geografskaDuzina && Objects.equals(adresa, lokacija.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geografskaSirina, geografskaDuzina, adresa);
    }

    @Override
    public String toString() {
        return "{" +
            " geografskaSirina='" + getGeografskaSirina() + "'" +
            ", geografskaDuzina='" + getGeografskaDuzina() + "'" +
            ", adresa='" + getAdresa() + "'" +
            "}";
    }

}
