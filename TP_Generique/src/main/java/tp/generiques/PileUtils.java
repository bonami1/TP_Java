package tp.generiques;

public class PileUtils {
    public static <T> Pile<T> inverser(Pile<T> source) {
        Pile<T> copie = new Pile<>();
        Pile<T> resultat = new Pile<>();

        for (int i = 0; i < source.taille(); i++) {
            copie.empiler(source.getElements().get(i));
        }

        while (!copie.estVide()) {
            resultat.empiler(copie.depiler());
        }

        return resultat;
    }
}
