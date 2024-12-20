package org.example.esssai2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StationDeCarburantUI extends JPanel {
    private StationDeCarburant station;
    private List<Voiture> voitures;
    private int stockageMax;

    public StationDeCarburantUI(StationDeCarburant station, int stockageMax) {
        this.station = station;
        this.stockageMax = stockageMax;
        this.voitures = new ArrayList<>();
    }

    public void ajouterVoiture(Voiture v) {
        voitures.add(v);
        new Thread(v).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner la pompe (rectangle)
        int longueurPompe = (int) ((station.getStockageCarburant() / stockageMax) * getWidth());
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, longueurPompe, 20);

        // Dessiner les voitures (carrés)
        int y = 100;
        for (Voiture v : voitures) {
            g.setColor(v.getCouleur());
            g.fillRect(50, y, 30, 30);
            y += 40;
        }

        repaint(); // Redessiner continuellement
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulation Station de Carburant");
        StationDeCarburant station = new StationDeCarburant(5000); // Stockage initial
        StationDeCarburantUI panneau = new StationDeCarburantUI(station, 5000);

        frame.add(panneau);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Ajouter des voitures
        for (int i = 0; i < 5; i++) {
            Voiture v = new Voiture(station, i);
            panneau.ajouterVoiture(v);
        }

        // Simuler les livraisons de carburant
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(10000); // Pause avant la prochaine livraison
                    station.ravitailler(2000); // Ajouter du carburant
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Voiture implements Runnable {
    private StationDeCarburant station;
    private int id;
    private Color couleur;

    public Voiture(StationDeCarburant station, int id) {
        this.station = station;
        this.id = id;
        this.couleur = new Color((int) (Math.random() * 0x1000000)); // Couleur aléatoire
    }

    public Color getCouleur() {
        return couleur;
    }

    @Override
    public void run() {
        try {
            while (true) {
                double quantite = 100 * Math.random();
                station.servirCarburant(quantite);
                Thread.sleep((int) (3000 * Math.random())); // Attente avant le prochain ravitaillement
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
