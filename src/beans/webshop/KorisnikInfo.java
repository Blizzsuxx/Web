package beans.webshop;

import java.util.Objects;

public class KorisnikInfo {
    public String username;
    public String password;



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
