
package net.essadiki;

import net.essadiki.services.IMetier;
import net.essadiki.services.MetierImpl;

public class Main {

    public static void main(String[] args) {

        IMetier metier = new MetierImpl();

        System.out.println("=== TP AspectJ Avance ===");

        System.out.println("\n--- Test 1 : process() ---");
        metier.process();

        System.out.println("\n--- Test 2 : compute() ---");
        double resultat = metier.compute(10, 20);
        System.out.println("Resultat : " + resultat);

        System.out.println("\n--- Test 3 : divide() ---");
        double division = metier.divide(20, 4);
        System.out.println("Division : " + division);

        System.out.println("\n--- Test 4 : Exception ---");

        try {
            metier.divide(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Exception interceptee dans Main : "
                            + e.getMessage()
            );
        }
    }
}
