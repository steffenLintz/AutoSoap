/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap.ejb;

import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Fahrzeug;
import javax.ejb.Stateless;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class FahrzeugBean extends EntityBean<Fahrzeug, Long> {
    
    public FahrzeugBean() {
        super(Fahrzeug.class);
    }
    
}
