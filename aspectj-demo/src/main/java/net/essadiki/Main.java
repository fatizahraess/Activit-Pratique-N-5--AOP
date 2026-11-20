
package net.essadiki;

import net.essadiki.services.IMetier;
import net.essadiki.services.MetierImpl;

public class Main {

    public static void main(String[] args) {

        IMetier metier = new MetierImpl();

        System.out.println("=== Application avec AspectJ ===");

        metier.process();

        double resultat = metier.compute(10, 20);

        System.out.println("Resultat : " + resultat);
    }
}
