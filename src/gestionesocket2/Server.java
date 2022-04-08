/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocket2;

import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele
 */
public class Server {
public static void main(String[] args) {
    try {
    DataOutputStream out = null;
    BufferedReader in = null;
    ServerSocket serverSocket=new ServerSocket(2000);
    System.out.println("server avviato correttamente");
    Socket socket = serverSocket.accept();
    
    serverSocket.close();
    socket.getOutputStream();
    
    
    String messaggio="ciao";
    out.writeBytes(messaggio+"\r\n");
    System.out.println("messaggio iniziale");
    out.flush();
    
    String stringaRicevuta;
    stringaRicevuta=in.readLine();
    System.out.println("richiesta: " +stringaRicevuta+"\n");
    //data                  
    SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
    String timeStamp = date.format(new Date());
                   
    out.writeBytes(timeStamp+"\r\n");
    System.out.println("data e ora\n");
    out.flush();
              
    socket.close();
    System.out.println("fine connessione \n");
    
} catch(BindException ex){
    System.err.println("porta occupata");
}   catch (IOException ex) {    
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}