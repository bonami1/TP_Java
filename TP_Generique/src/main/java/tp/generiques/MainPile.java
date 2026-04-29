package tp.generiques;


public class MainPile {
    public static void main(String[] args) {

        Pile<Integer> pile = new Pile<>();
        pile.empiler(1);
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);
        pile.empiler(5);

        System.out.println("Pile initiale : " + pile);

        Integer valeur = pile.depiler();
        System.out.println("Valeur retirée : " + valeur);
        System.out.println("Pile après dépilement : " + pile);

        Pile<Integer> pileInverse = PileUtils.inverser(pile);
        System.out.println("Pile inversée : " + pileInverse);
        System.out.println("Pile originale (inchangée) : " + pile);

    }
}
