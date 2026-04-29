package fr.TP;

public class Robot {
    private String nom;
    private boolean allume = false;
    private int energie = 0;

    public Robot(){}
    public Robot(String nom, boolean allume, int energie){
        this.nom = nom;
        this.energie = energie;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public boolean isAllume() { return allume; }
    public void setAllume(boolean allume) { this.allume = allume; }
    public int getEnergie() { return energie; }
    public void setEnergie(int energie) { this.energie = energie; }

    public void allumer() {
        this.allume = true;
    }
    public void eteint() {
        this.allume = false;
    }

    public Bras getBras() {
        Bras bras = new Bras();
        return bras;
    }

    // Classe interne Bras
    class Bras {
        public void saisir(Robot robot) {
            if (robot.allume && robot.energie > 20) {
                energie -= 10;
                System.out.println("Energie -10");
            }
            else {
                System.out.println("Erreur de saisie");
            }
        }

        public void deposer(Robot robot) {
            if (robot.allume) {
                energie += 5;
                System.out.println("Energie +5 : " + energie);
            }
            else {
                System.out.println("Robot éteint");
            }
        }

        public void afficherEtat() {
            System.out.println("Nom : " + nom);
            System.out.println("Allume : " + allume);
            System.out.println("Energie : " + energie);
        }
    }

    public static void main (String[] args) {
        Robot robot = new Robot();
        robot.allume = true;
        robot.energie = 30;

        Robot.Bras bras = robot.new Bras();
        bras.saisir(robot);
        bras.deposer(robot);
        bras.afficherEtat();
    }
}
