/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author z003ne3b
 */
@Entity
public class Leihvertrag implements Serializable {
    
    @ManyToOne
    Kunde kunde;
    
    @ManyToOne
    Fahrzeug fahrzeug;
    
    @Id
    @GeneratedValue(generator = "leihvertrag_ids")
    @TableGenerator(name = "leihvertrag_ids", initialValue = 0, allocationSize = 50)
    private long id = 0;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date beginndatum;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date enddatum;
    
    
//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Leihvertrag(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum) {
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.beginndatum = beginndatum;
        this.enddatum = enddatum;
    }
    
    public Leihvertrag() {
    }
    
//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Kunde getKunde() {
        return kunde;
    }
    
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }
    
    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    public Date getBeginndatum() {
        return beginndatum;
    }
    
    public void setBeginndatum(Date beginndatum) {
        this.beginndatum = beginndatum;
    }
    
    public Date getEnddatum() {
        return enddatum;
    }
    
    public void setEnddatum(Date enddatum) {
        this.enddatum = enddatum;
    }
       public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
//</editor-fold>
  
}
