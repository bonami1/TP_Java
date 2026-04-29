package fr.TP;

import java.util.*;
import java.util.ArrayList;

public class GestionnaireStock {
    Scanner sc = new Scanner(System.in);
    private List<Produit> stock = new ArrayList<>();

    public void ajouterProduit() {
        System.out.println("Nom");
        String nom = sc.nextLine();
        System.out.println("Categorie");
        String categorie = sc.nextLine();
        System.out.println("Prix");
        double prix = sc.nextDouble();
        System.out.println("Quantité");
        int quantite = sc.nextInt();
        sc.nextLine();
        Produit produit = new Produit(nom, categorie, prix, quantite);
        stock.add(produit);
    }

    public List<Produit> filtrerEtTrier(String categorie, double prixMax, int quantiteMin) {
        interface Filtre {
            boolean accepter(Produit p);
        }

        class FiltreCompose implements Filtre {
            public boolean accepter(Produit p) {
                return p.categorie.equals(categorie) && p.prix >= prixMax && p.quantite >= quantiteMin;
            }
        }

        Filtre filtre = new FiltreCompose();
        List<Produit> produitFiltre = new ArrayList<>();

        for (Produit p : stock) {
            if (filtre.accepter(p)) {
                produitFiltre.add(p);
            }
        }
        produitFiltre.sort(Comparator.comparingDouble(p -> p.prix));
        return produitFiltre;
    }

    public static void main(String[] args) {
        GestionnaireStock gestionnaireStock = new GestionnaireStock();
        gestionnaireStock.stock.add(new Produit("pc", "Informatique", 900, 3));
        gestionnaireStock.stock.add(new Produit("souris", "Informatique", 25, 3));
        gestionnaireStock.stock.add(new Produit("clavier", "Informatique", 100, 3));
        gestionnaireStock.stock.add(new Produit("Ecran", "Informatique", 100, 3));
        gestionnaireStock.stock.add(new Produit("Casque", "Informatique", 100, 3));
        gestionnaireStock.stock.add(new Produit("Chaise", "Immobilier", 60, 5));
        gestionnaireStock.stock.add(new Produit("Table", "Immobilier", 200, 5));
        gestionnaireStock.stock.add(new Produit("Bureau", "Immobilier", 400, 5));

        System.out.println(gestionnaireStock.filtrerEtTrier("Informatique", 100, 3));
        System.out.println("--------------------------------------------------");
        System.out.println(gestionnaireStock.filtrerEtTrier("Immobilier", 200, 5));
    }
}

