package org.example;

import java.net.*;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port)  {
        System.out.println("Client started");
        try{
        clientSocket = new Socket(ip, port);
        System.out.println("Client socket started");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("in and out created");
        System.out.println("Client ready");

        }catch(Exception e){
            System.out.println("Erreur: Le client ne peux pas se connecter au serveur");

        }
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

}

