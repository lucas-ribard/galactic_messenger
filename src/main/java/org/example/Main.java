package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        while (true) {
            String textInput = myScanner.nextLine();  // Read user input
            if (textInput.equals("exit")) {
                String response = client.sendMessage(textInput);
                client.stopConnection();
                break;
            }
            String response = client.sendMessage(textInput);
            System.out.println(response);
        }


    }

}