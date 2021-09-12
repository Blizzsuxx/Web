package beans.webshop;

import java.util.Date;

public class Admin extends Korisnik{

    public Admin(String username, String password, String ime, String prezime, Pol valueOf, Date parse,
            Uloga valueOf2) 
            {
                super(username, password, ime, prezime, valueOf, parse, valueOf2);
    }

    
    
}
