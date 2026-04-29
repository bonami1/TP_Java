package fr.TP;

public final class Ordinateur {
    private final String marque;
    private final String processeur;
    private final int ramGo;
    private final int stockageGo;
    private final boolean ssd;
    private final String carteGraphique;
    private final double prixEuros;

    private Ordinateur(Builder builder) {
        this.marque = builder.marque;
        this.processeur = builder.processeur;
        this.ramGo = builder.ramGo;
        this.stockageGo = builder.stockageGo;
        this.ssd = builder.ssd;
        this.carteGraphique = builder.carteGraphique;
        this.prixEuros = builder.prixEuros;
    }

    public String getMarque() { return marque; }
    public String getProcesseur() { return processeur; }
    public int getRamGo() { return ramGo; }
    public int getStockageGo() { return stockageGo; }
    public boolean getSsd() { return ssd; }
    public String getCarteGraphique() { return carteGraphique; }
    public double getPrixEuros() { return prixEuros; }

    public String toString() {
        return "Marque : " + marque
                + "\nProcesseur : " + processeur
                + "\nRam go : " + ramGo
                + "\nStockage go : " + stockageGo
                + "\nSsd : " + ssd
                + "\nCarte graphique : " + carteGraphique
                + "\nPrix euros : " + prixEuros;
    }

    public static class Builder {
        private final String marque;
        private final String processeur;
        private final int ramGo;
        private int stockageGo = 256;
        private boolean ssd = true;
        private String carteGraphique = "Intergree";
        private double prixEuros = 0;

        public Builder(String marque, String processeur, int ramGo) {
            this.marque = marque;
            this.processeur = processeur;
            this.ramGo = ramGo;
        }

        public Builder stockageGo(int stockageGo) {
            this.stockageGo = stockageGo;
            return this;
        }

        public Builder ssd(boolean ssd) {
            this.ssd = ssd;
            return this;
        }

        public Builder carteGraphique(String carteGraphique) {
            this.carteGraphique = carteGraphique;
            return this;
        }

        public Builder prixEuros(double prixEuros) {
            this.prixEuros = prixEuros;
            return this;
        }

        public Ordinateur build() {
            if (ramGo < 4) {
                throw new IllegalArgumentException("Min RAM 4 Go");
            }
            return new Ordinateur(this);
        }
    }

    public static void main(String[] args) {
        Ordinateur ordinateur1 = new Ordinateur.Builder("Lenovo", "Intel", 16)
                .stockageGo(512)
                .ssd(true)
                .carteGraphique("..")
                .prixEuros(1200)
                .build();

        Ordinateur ordinateur2 = new Ordinateur.Builder("Asus", "ADM", 16)
                .stockageGo(512)
                .ssd(true)
                .carteGraphique("..")
                .prixEuros(900)
                .build();

        Ordinateur ordinateur3 = new Ordinateur.Builder("Dell", "Intel", 16)
                .stockageGo(512)
                .ssd(true)
                .carteGraphique("..")
                .prixEuros(1500)
                .build();

        System.out.println(ordinateur1);
        System.out.println("------------------------------------------");
        System.out.println(ordinateur2);
        System.out.println("------------------------------------------");
        System.out.println(ordinateur3);
    }
}
