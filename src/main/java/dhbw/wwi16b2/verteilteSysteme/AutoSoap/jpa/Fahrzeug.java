/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author z003ne3b
 */
@Entity
public class Fahrzeug implements Serializable {
    @Id
    @GeneratedValue(generator = "fahrzeug_ids")
    @TableGenerator(name = "fahrzeug_ids", initialValue = 0, allocationSize = 50)
    private long id = 0;
    
    @NotNull(message = "Hersteller darf nicht null sein")
    private String hersteller;
    
    @NotNull(message = "Modell darf nicht null sein")
    private String Modell;
    
    @NotNull(message = "Baujahr darf nicht null sein")
    private String baujahr;

   //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Fahrzeug(String hersteller, String Modell, String baujahr) {
        this.hersteller = hersteller;
        this.Modell = Modell;
        this.baujahr = baujahr;
    }
    
    public Fahrzeug() {
    }
    
//</editor-fold>
    
   //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public String getModell() {
        return Modell;
    }
    
    public void setModell(String Modell) {
        this.Modell = Modell;
    }
    
    public String getBaujahr() {
        return baujahr;
    }
    
    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }
//</editor-fold>
    
}
