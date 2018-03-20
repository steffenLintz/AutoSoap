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
        return em.createQuery("SELECT l FROM Leihvertrag l WHERE l.kunde = :kunde ORDER BY l.beginndatum")
                .setParameter("kunde", kunde)
                .getResultList();
    }

    public Leihvertrag ausleihen(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum) throws Exception {

        Boolean leihemoeglich = false;

        List<Leihvertrag> vertragezwischen = em.createQuery("SELECT l FROM Leihvertrag l"
                + " WHERE l.beginndatum <=:beginndatum"
                + " AND l.enddatum >= :enddatum"
                + " AND l.fahrzeug = :fahrzeug")
                .setParameter("beginndatum", beginndatum)
                .setParameter("enddatum", enddatum)
                .setParameter("fahrzeug", fahrzeug)
                .getResultList();

        if (vertragezwischen.isEmpty()) {
            List<Leihvertrag> außerhalb = em.createQuery("SELECT l FROM Leihvertrag l"
                    + " WHERE l.beginndatum >= :beginndatum"
                    + " AND l.enddatum <= :enddatum"
                    + " AND l.fahrzeug = :fahrzeug")
                    .setParameter("beginndatum", beginndatum)
                    .setParameter("enddatum", enddatum)
                    .setParameter("fahrzeug", fahrzeug)
                    .getResultList();
            if (außerhalb.isEmpty()) {
                List<Leihvertrag> beginnvorher = em.createQuery("SELECT l FROM Leihvertrag l"
                        + " WHERE l.beginndatum >= :beginndatum"
                        + " AND l.beginndatum <= :enddatum"
                        + " AND l.fahrzeug = :fahrzeug")
                        .setParameter("beginndatum", beginndatum)
                        .setParameter("enddatum", enddatum)
                        .setParameter("fahrzeug", fahrzeug)
                        .getResultList();

                if (beginnvorher.isEmpty()) {
                    List<Leihvertrag> endespäter = em.createQuery("SELECT l FROM Leihvertrag l"
                            + " WHERE l.enddatum >= :beginndatum"
                            + " AND l.enddatum <= :enddatum"
                            + " AND l.fahrzeug = :fahrzeug")
                            .setParameter("beginndatum", beginndatum)
                            .setParameter("enddatum", enddatum)
                            .setParameter("fahrzeug", fahrzeug)
                            .getResultList();
                    if (endespäter.isEmpty()) {
                        leihemoeglich = true;
                    }
                }
            }

        }

        if (leihemoeglich) {
            Leihvertrag leihvertrag = new Leihvertrag(kunde, fahrzeug, beginndatum, enddatum);
            return this.saveNew(leihvertrag);
        } else {
            throw new Exception();
        }
    }

}
