package dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Steffen Lintz
 */

@Entity
public class Kunde implements Serializable {
    @Id
    @GeneratedValue(generator = "kunden_ids")
    @TableGenerator(name = "kunden_ids", initialValue = 0, allocationSize = 50)
    private long id = 0;
    
    @NotNull(message= "Vorname darf nicht leer sein")
    private String vorname;
    
   @NotNull(message= "Nachname darf nicht leer sein")
    private String nachname;
    
   @NotNull(message = "Straße darf nicht leer sein")
    private String straße;
    
   @NotNull(message = "Hausnummer darf nicht leer sein")
    private String hausnummer;
    
   @NotNull (message = "PLZ darf nicht leer sein")
    private String plz;
    
  @NotNull (message = "Ort darf nicht leer sein")
    private String ort;
    
   @NotNull (message = "Land darf nicht leer sein")
    private String land;
    
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Kunde(String vorname, String nachname, String straße, String hausnummer, String plz, String ort, String land) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
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
    
    public String getHausnummer() {
        return hausnummer;
    }
    
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
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
//</editor-fold>
}
