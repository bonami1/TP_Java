package tp.generiques;

import static tp.generiques.Paire.inverser;

public class MainPaire {
    public static void main(String[] args) {
        Paire<String, Integer> personne1 = new Paire<>("Alice", 25);

        Paire<Double, Boolean> paire1 = new Paire<>(3.14, true);

        System.out.println(inverser(personne1));
        System.out.println(paire1.getPremier().getClass().getSimpleName());
        System.out.println(paire1.getSecond().getClass().getSimpleName());
    }
}
