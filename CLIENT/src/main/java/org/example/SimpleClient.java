package org.example;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Connexion au serveur à l'adresse localhost (127.0.0.1) et au port 1234
            Socket socket = new Socket("127.0.0.1", 1234);
            System.out.println("Connecté au serveur");

            // Création d'un flux de sortie pour envoyer des données au serveur
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Envoyer un message au serveur
            out.println("Bonjour, serveur !");

            // Lire la réponse du serveur
            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);

            // Fermer la connexion
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
