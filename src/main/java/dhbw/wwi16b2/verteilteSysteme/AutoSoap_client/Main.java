/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.verteilteSysteme.AutoSoap_client;

import dhbw.wwi16b2.verteilteSysteme.AutoSoap.web.Webservice;
import dhbw.wwi16b2.verteilteSysteme.AutoSoap.web.AutoSoap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Compiler.command;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author scp
 */
public class Main {
    
    private final Webservice ws;
    private final BufferedReader fromKeyboard;
    
    
    public static void main(String[] args) throws IOException, DatatypeConfigurationException {
        
        Main main = new Main();
        main.runMainMenu();
    }
    
    
    public Main() {
        AutoSoap autosoap = new AutoSoap();
        this.ws = autosoap.getWebservicePort();
        
        this.fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void runMainMenu() throws IOException, DatatypeConfigurationException {
        
        boolean quit = false;
        
        while (!quit) {
        System.out.println("=========");
        System.out.println("Hauptmenü");
        System.out.println("=========");
        System.out.println();
        System.out.println("  [K] Kunde anlegen");
        System.out.println("  [F] Fahrzeug anlegen");
        System.out.println("  [A] Fahrzeug ausleihen");
        System.out.println("  [L] Leihverträge auflisten");
        System.out.println("  [E] Ende");
        System.out.println();
        
        System.out.println("Deine Auswahl: ");
        String command = this.fromKeyboard.readLine();
        System.out.println();
        
        
        switch (command.toUpperCase()) {
                case "K":
                    this.searchPrograms();
                    break;
                case "F":
                    this.searchPrograms();
                    break;
                case "A":
                    this.searchPrograms();
                    break;
                case "L":
                    this.searchPrograms();
                    break;                    
                case "E":
                    quit = true;
                    break;
                default:
                    System.out.println("Sorry, ich habe dich nicht verstanden …");
                    System.out.println();
            }
        }
    }
    
    public void createNewKunde() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Kunden anlegen");
        System.out.println("================");
        System.out.println();
        
        System.out.print("Vorname:");
        String Vorname = this.fromKeyboard.readLine();
        
        System.out.print("Nachname:");
        String Nachname = this.fromKeyboard.readLine();
        
        System.out.print("Straße:");
        String Straße = this.fromKeyboard.readLine();
        
        System.out.print("Hausnummer:");
        String Hausnummer = this.fromKeyboard.readLine();
        
        System.out.print("Ort:");
        String Ort = this.fromKeyboard.readLine();
        
        System.out.print("Land:");
        String Land = this.fromKeyboard.readLine();
        
        System.out.println();
        
        
    }
    
}
