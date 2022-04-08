/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocket2;

import java.net.Socket;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Daniele
 */
public class Client {
    
    public static void main(String[] args){
        
        try {
        DataOutputStream out = null;
        BufferedReader in = null;
            
                         
        Socket client = new Socket(InetAddress.getLocalHost(),2000);
        System.out.println("richiesta connessione al server\n");

        out= new DataOutputStream(client.getOutputStream());
             
        in= new BufferedReader(new InputStreamReader(client.getInputStream()));
            
        String stringaRicevuta;
        stringaRicevuta=in.readLine();
        System.out.println("messaggio server: " +stringaRicevuta+"\n");
                      
        String messaggioBenevnuto="inserisci data e ora";
        out.writeBytes(messaggioBenevnuto+"\r\n");
        System.out.println("invio data e ora\n");
        out.flush();
            
        stringaRicevuta=in.readLine();
        System.out.println("data: " +stringaRicevuta+"\n");
              
        client.close();
        System.out.println("connessione terminata\n");
        }
        catch (UnknownHostException ex) {
            System.out.println("host non riconosciuto\n");
        }
        catch (Exception ex) {
          System.out.println("errore di connessione\n");
        }
    }
    
}
