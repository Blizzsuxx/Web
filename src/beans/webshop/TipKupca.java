package beans.webshop;

import java.util.Objects;

public class TipKupca {

    private String imeTipa;
    private int popust;
    private int potrebniBodovi;
    
    

    public TipKupca(String imeTipa) {
        if(imeTipa.equals("Zlatni")){
            popust = 10;
        } else if (imeTipa.equals("Srebrni")){
            popust = 5;
        } else {
            popust = 1;
        }
    }

    public TipKupca(String imeTipa, int popust, int potrebniBodovi) {
        this.imeTipa = imeTipa;
        this.popust = popust;
        this.potrebniBodovi = potrebniBodovi;
    }

    public String getImeTipa() {
        return this.imeTipa;
    }

    public void setImeTipa(String imeTipa) {
        this.imeTipa = imeTipa;
    }

    public int getPopust() {
        return this.popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getPotrebniBodovi() {
        return this.potrebniBodovi;
    }

    public void setPotrebniBodovi(int potrebniBodovi) {
        this.potrebniBodovi = potrebniBodovi;
    }

    public TipKupca imeTipa(String imeTipa) {
        setImeTipa(imeTipa);
        return this;
    }

    public TipKupca popust(int popust) {
        setPopust(popust);
        return this;
    }

    public TipKupca potrebniBodovi(int potrebniBodovi) {
        setPotrebniBodovi(potrebniBodovi);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipKupca)) {
            return false;
        }
        TipKupca tipKupca = (TipKupca) o;
        return Objects.equals(imeTipa, tipKupca.imeTipa) && popust == tipKupca.popust && potrebniBodovi == tipKupca.potrebniBodovi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imeTipa, popust, potrebniBodovi);
    }

    @Override
    public String toString() {
        return "{" +
            " imeTipa='" + getImeTipa() + "'" +
            ", popust='" + getPopust() + "'" +
            ", potrebniBodovi='" + getPotrebniBodovi() + "'" +
            "}";
    }
    
}
