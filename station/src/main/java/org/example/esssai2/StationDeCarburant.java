package org.example.esssai2;

public class StationDeCarburant {
    private double stockageCarburant;

    public StationDeCarburant(double initialStockage) {
        this.stockageCarburant = initialStockage;
    }

    public synchronized void ravitailler(double quantite) {
        stockageCarburant += quantite;
        System.out.printf("Station ravitaillée avec %.2f litres. Stock actuel : %.2f litres.%n", quantite, stockageCarburant);
        notifyAll(); // Réveille les voitures en attente
    }

    public synchronized boolean servirCarburant(double quantite) throws InterruptedException {
        while (stockageCarburant < quantite) {
            System.out.println("Carburant insuffisant, en attente de ravitaillement...");
            wait(); // Attend que le carburant soit disponible
        }
        stockageCarburant -= quantite;
        System.out.printf("Servi %.2f litres. Stock restant : %.2f litres.%n", quantite, stockageCarburant);
        return true;
    }

    public double getStockageCarburant() {
        return stockageCarburant;
    }
}
