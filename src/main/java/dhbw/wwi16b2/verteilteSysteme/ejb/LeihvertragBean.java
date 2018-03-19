/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.ejb;

import dhbw.wwi16b2.verteilteSysteme.jpa.Leihvertrag;
import javax.ejb.Stateless;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, String> {
    
    public LeihvertragBean(){
        super(Leihvertrag.class);
    }
    
}
