package net.essadiki;
import net.essadiki.services.IMetier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringAopDemoApplication.class, args
        );
    }

    @Bean
    CommandLineRunner run(IMetier metier) {
        return args -> {

            System.out.println("=== TP Spring AOP ===");

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
                        "Exception interceptee dans Application : "
                                + e.getMessage()
                );
            }
        };
    }
}
