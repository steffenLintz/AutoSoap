/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap.ejb;

import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Fahrzeug;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Kunde;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Leihvertrag;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {

    public LeihvertragBean() {
        super(Leihvertrag.class);
    }

    public List<Leihvertrag> findVertraegeByUser(Kunde kunde) {
        return em.createQuery("SELECT l FROM Leihvertrag WHERE l.kunde = :kunde ORDER BY l.beginndatum")
                .setParameter("kunde", kunde)
                .getResultList();
    }

    public Leihvertrag ausleihen(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum) {

        Boolean leihemoeglich = true;
        
        List<Leihvertrag> vertragezwischen = em.createQuery("SELECT l FROM Leihvertrag WHERE l.beginndatum > :kunde ORDER BY l.beginndatum").setParameter("beginndatum", beginndatum).setParameter("enddatum", enddatum).getResultList();
        
        if(vertragezwischen.isEmpty()){
            List<Leihvertrag> außerhalb = em.createQuery("SELECT l FROM Leihvertrag WHERE l.kunde = :kunde ORDER BY l.beginndatum").setParameter("kunde", kunde).getResultList();
        }
        

        if (leihemoeglich) {
            Leihvertrag leihvertrag = new Leihvertrag(kunde, fahrzeug, beginnDatum, endDatum);
            return this.saveNew(leihvertrag);
        } else {
            return null;
        }

    }
