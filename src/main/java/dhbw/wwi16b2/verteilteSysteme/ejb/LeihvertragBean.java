/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.ejb;

import dhbw.wwi16b2.verteilteSysteme.jpa.Kunde;
import dhbw.wwi16b2.verteilteSysteme.jpa.Leihvertrag;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {
    
    public LeihvertragBean(){
        super(Leihvertrag.class);
    }

    public List<Leihvertrag> findVertraegeByUser(Kunde kunde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
