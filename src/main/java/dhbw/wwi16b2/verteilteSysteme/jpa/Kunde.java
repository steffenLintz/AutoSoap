package dhbw.wwi16b2.verteilteSysteme.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Steffen Lintz
 */

@Entity
public class Kunde implements Serializable {
    @Id
    @GeneratedValue
    private long id = 0;
    
    @NotNull(message= "Vorname darf nicht leer sein")
    private String vorname;
    
    @NotNull(message= "Nachname darf nicht leer sein")
    private String nachname;
    
    @NotNull(message = "Straße darf nicht leer sein")
    private String straße;
    
    @NotNull (message = "PLZ darf nicht leer sein")
    private String plz;
    
    @NotNull (message = "Ort darf nicht leer sein")
    private String ort;
    
    @NotNull (message = "Land darf nicht leer sein")
    private String land;
    
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Kunde(String vorname, String nachname, String straße, String plz, String ort, String land, Leihvertrag leihvertrag) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
        this.leihvertrag = leihvertrag;
    }
    
    public Kunde() {
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getter and Setters">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public String getStraße() {
        return straße;
    }
    
    public void setStraße(String straße) {
        this.straße = straße;
    }
    
    public String getPlz() {
        return plz;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }
    
    public String getOrt() {
        return ort;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    public String getLand() {
        return land;
    }
    
    public void setLand(String land) {
        this.land = land;
    }
    
    public Leihvertrag getLeihvertrag() {
        return leihvertrag;
    }
    
    public void setLeihvertrag(Leihvertrag leihvertrag) {
        this.leihvertrag = leihvertrag;
    }
//</editor-fold>
}
