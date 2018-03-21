/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap.web;

import dhbw.wwi16b2.verteilteSysteme.AutoSoap.ejb.FahrzeugBean;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.ejb.KundeBean;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.ejb.LeihvertragBean;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Fahrzeug;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Kunde;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.jpa.Leihvertrag;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * Car Sharing - SOAP-Webservice
 */

@Stateless
@WebService(serviceName ="AutoSoap")
public class Webservice {
    
    @EJB
    FahrzeugBean fahrzeugBean;
    
    @EJB
    KundeBean kundeBean;
    
    @EJB
    LeihvertragBean leihvertragBean;
    
    @WebMethod
    @WebResult(name = "fahrzeug")
    public Fahrzeug createNewFahrzeug(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
            return fahrzeugBean.saveNew(fahrzeug);
    }
    
    @WebMethod
    @WebResult(name = "kunde")
    public Kunde createNewKunde(@WebParam(name = "kunde") Kunde kunde){
            return kundeBean.saveNew(kunde);
    }
    
    @WebMethod
    @WebResult(name = "kunde")
    public Kunde getKundebyId (@WebParam(name="id") long id){
        return kundeBean.findById(id);
    }
    
    @WebMethod
    @WebResult(name = "fahrzeuge")
    public List<Fahrzeug> getAllFahrzeuge() {
        return fahrzeugBean.findAll();
    }
    
    @WebMethod
    @WebResult(name = "fahrzeug")
    public Fahrzeug getFahrzeugbyId (@WebParam(name="id") long id){
        return fahrzeugBean.findById(id);
    }
    
    
    @WebMethod
    @WebResult(name = "leihvertraege")
    public List<Leihvertrag> findVertraegeByUser(
            @WebParam(name = "kunde") Kunde kunde) {

        return leihvertragBean.findVertraegeByUser(kunde);
    }
    
    @WebMethod
    @WebResult(name = "leihvertraeg")
    public Leihvertrag ausleihen(
            @WebParam(name = "kunde") Kunde kunde,
            @WebParam(name = "fahrzeug") Fahrzeug fahrzeug,
            @WebParam(name = "beginnDatum") Date beginnDatum,
            @WebParam(name = "endDatum") Date endDatum) throws Exception {

        return leihvertragBean.ausleihen(kunde,fahrzeug, beginnDatum, endDatum);
    }
}
