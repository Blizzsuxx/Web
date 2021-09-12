package beans.webshop;

import java.util.Objects;

public class rezervacija {
    private Integer regularne;
    private Integer fanParti;
    private Integer vip;
    private Long id;



    public rezervacija() {
    }

    public rezervacija(Integer regularne, Integer fanParti, Integer vip, Long id) {
        this.regularne = regularne;
        this.fanParti = fanParti;
        this.vip = vip;
        this.id = id;
    }

    public Integer getRegularne() {
        return this.regularne;
    }

    public void setRegularne(Integer regularne) {
        this.regularne = regularne;
    }

    public Integer getFanParti() {
        return this.fanParti;
    }

    public void setFanParti(Integer fanParti) {
        this.fanParti = fanParti;
    }

    public Integer getVip() {
        return this.vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public rezervacija regularne(Integer regularne) {
        setRegularne(regularne);
        return this;
    }

    public rezervacija fanParti(Integer fanParti) {
        setFanParti(fanParti);
        return this;
    }

    public rezervacija vip(Integer vip) {
        setVip(vip);
        return this;
    }

    public rezervacija id(Long id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof rezervacija)) {
            return false;
        }
        rezervacija rezervacija = (rezervacija) o;
        return Objects.equals(regularne, rezervacija.regularne) && Objects.equals(fanParti, rezervacija.fanParti) && Objects.equals(vip, rezervacija.vip) && Objects.equals(id, rezervacija.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regularne, fanParti, vip, id);
    }

    @Override
    public String toString() {
        return "{" +
            " regularne='" + getRegularne() + "'" +
            ", fanParti='" + getFanParti() + "'" +
            ", vip='" + getVip() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

}
