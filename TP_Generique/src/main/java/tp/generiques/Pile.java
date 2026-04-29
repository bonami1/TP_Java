package tp.generiques;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pile<T> {
    private List<T> elements = new ArrayList<>();

    public Pile() {}
    public Pile(List<T> elements) {
        this.elements = elements;
    }

    public List<T> getElements() { return elements; }

    public void empiler(T element) {
        elements.add(element);
    }

    public T depiler() {
        if(estVide()) {
            throw new NoSuchElementException("Pile vide");
        }
        return elements.remove(elements.size()-1);
    }

    public T sommet() {
        if(estVide()) {
            throw new IllegalStateException("Pile vide");
        }
        return elements.get(elements.size()-1);
    }

    public boolean estVide() {
        return elements.isEmpty();
    }

    public int taille() {
        return elements.size();
    }

    @Override
    public String toString() {
        List<String> copies = new ArrayList<>();
        for (int i=elements.size() - 1; i >=0; i--) {
            copies.add(elements.get(i).toString());
        }
        return "[" + String.join(" | ", copies) + "]";
    }
}
