
package net.essadiki;

import net.essadiki.services.IMetier;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MetierServiceTest {

    @Autowired
    private IMetier metier;

    @Test
    void testProcess() {
        assertDoesNotThrow(() -> metier.process());
    }

    @Test
    void testCompute() {
        double resultat = metier.compute(10, 20);
        assertEquals(30.0, resultat);
    }

    @Test
    void testDivide() {
        double resultat = metier.divide(20, 4);
        assertEquals(5.0, resultat);
    }

    @Test
    void testDivisionByZero() {
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> metier.divide(10, 0)
                );

        assertEquals(
                "Division par zero interdite",
                exception.getMessage()
        );
    }

    @Test
    void testSpringAopProxy() {
        assertTrue(
                AopUtils.isAopProxy(metier),
                "Le service doit etre un proxy Spring AOP"
        );
    }
}
