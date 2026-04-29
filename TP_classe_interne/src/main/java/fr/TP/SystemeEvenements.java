package fr.TP;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface ClickListener {
    void onClick(int x, int y);
}

@FunctionalInterface
interface KeyListener {
    void onKeyPress(char touche);
}

@FunctionalInterface
interface HoverListener {
    void onHover(boolean entre);
}

class Bouton {
    String label;

    List<ClickListener> clickListeners = new ArrayList<>();
    List<KeyListener> keyListeners = new ArrayList<>();
    List<HoverListener> hoverListeners = new ArrayList<>();

    public Bouton(String label) {
        this.label = label;
    }

    public void addClickListener(ClickListener clickListener) {
        clickListeners.add(clickListener);
    }

    public void addKeyListener(KeyListener keyListener) {
        keyListeners.add(keyListener);
    }

    public void addHoverListener(HoverListener hoverListener) {
        hoverListeners.add(hoverListener);
    }

    public void simulerClick(int x, int y) {
       System.out.println("Clic sur le bouton " + label);
       for (ClickListener clickListener : clickListeners) {
           clickListener.onClick(x,y);
       }
    }

    public void simulerTouche(char c) {
        System.out.println("Touche sur le bouton " + label);
        for (KeyListener keyListener : keyListeners) {
            keyListener.onKeyPress(c);
        }
    }

    public void simulerSurvol(boolean entre) {
        System.out.println("Survol sur le bouton " + label);
        for (HoverListener hoverListener : hoverListeners) {
            hoverListener.onHover(entre);
        }
    }
}

public class SystemeEvenements {
    /*public static void main(String[] args) {
        Bouton bouton = new Bouton("Valider");

        final int[] compteur= {0};

        bouton.addClickListener(new ClickListener() {
            @Override
            public void onClick(int x, int y) {
                System.out.println("clic " + x + ", " + y);
            }
        });

        bouton.addKeyListener(new KeyListener() {
            @Override
            public void onKeyPress(char touche) {
                char c = Character.toLowerCase(touche);
                if ("aeiouy".indexOf(c) != -1) {
                    System.out.println(c + " est une voyelle");
                } else {
                    System.out.println(c + " est une consonne");
                }
            }
        });

        bouton.addHoverListener(new HoverListener() {
            @Override
            public void onHover(boolean entre) {
                if (entre) {
                    System.out.println("Afficher");
                } else {
                    System.out.println("Masquer");
                }
            }
        });

        bouton.simulerClick(10, 20);
        bouton.simulerClick(5, 15);

        bouton.simulerTouche('a');
        bouton.simulerTouche('j');

        bouton.simulerSurvol(true);
        bouton.simulerSurvol(false);
    }*/

    public static void main(String[] args) {
        Bouton btn = new Bouton("Valider");

        final int[] compteur= {0};

        btn.addClickListener((x, y) ->
                System.out.println("clic " + x + ", " + y)
        );

        btn.addClickListener((x, y) -> {
            compteur[0]++;
            System.out.println("nombre de clic " + compteur[0]);
        });

        btn.addKeyListener(c -> {
            char lettre = Character.toLowerCase(c);
            if ("aeiouy".indexOf(lettre) != -1) {
                System.out.println(c + " est une voyelle");
            } else {
                System.out.println(c + " est une consonne");
            }
        });

        btn.addHoverListener(entre -> {
            if (entre) {
                System.out.println("Afficher");
            } else {
                System.out.println("Masquer");
            }
        });

        btn.simulerClick(10, 20);
        btn.simulerClick(5, 15);

        btn.simulerTouche('a');
        btn.simulerTouche('j');

        btn.simulerSurvol(true);
        btn.simulerSurvol(false);
    }
}

