package org.example.esssai2;

class VoitureRunnable implements Runnable {
    private StationDeCarburant station;
    private int idVoiture;
    private double maxQuantiteCarburant;

    public VoitureRunnable(StationDeCarburant station, int id, double maxQuantite) {
        this.station = station;
        this.idVoiture = id;
        this.maxQuantiteCarburant = maxQuantite;
    }

    @Override
    public void run() {
        try {
            while (true) {
                double quantite = maxQuantiteCarburant * Math.random();
                System.out.printf("Voiture %d demande %.2f litres.%n", idVoiture, quantite);
                station.servirCarburant(quantite);
                Thread.sleep((int) (2000 * Math.random())); // Temps avant le prochain ravitaillement
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

