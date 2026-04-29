package fr.TP;

public class Produit {
    String nom;
    String categorie;
    double prix;
    int quantite;

    public Produit(){}
    public Produit(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }
    public String toString() {
        return "Produit [nom=" + nom + ", categorie=" + categorie + ", prixMax=" + prix + ", quantite=" + quantite + "]";
    }
}
