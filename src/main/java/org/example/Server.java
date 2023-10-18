package org.example;

import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            System.out.println("Starting server");
            serverSocket = new ServerSocket(port);
            System.out.println("Socket created");

            clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("in and out created");

        } catch (Exception e) {
            System.out.println("Erreur: Le serveur ne s'initialise pas correctement");
        }

        System.out.println("Server started");
        try {
            while (true) {
                try {
                    String greeting = in.readLine();
                    if ("hello server".equals(greeting)) {
                        out.println("hello client");

                    }else if ("exit".equals(greeting)){
                       stop();
                       break;
                    }else {

                        out.println("ta ecrit : " + greeting + ", c'est pas hello server ta vu");
                    }
                } catch (Exception e) {
                    System.out.println("Erreur: pas de message envoyé");
                }
            }
        }catch (Exception e){
            System.out.println("Erreur: Le server s'est arrété");
        }
    }



    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        Server server=new Server();
        server.start(6666);
    }
}