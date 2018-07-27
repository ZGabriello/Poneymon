package fr.univ_lyon1.info.m1.poneymon_fx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the Poney class.
 */
public class PoneyTest {
    /**
     * Not really a test.
     */
    @Test
    public void testTrueIsTrue() {
        assertTrue(true);
    }

    /**
     * Simple example test for the Poney class.
     */
    @Test
    public void testMoveSpeed() {
        // Given
        Poney p = new Poney(null, "green", 0);
        p.speed = 0.42;
        p.x = 0;

        // When
        p.move();

        // Then
        assertEquals(p.x, 0.43,  // TODO: wrong expected value (should be 0.42)
                     0.001);
    }
}
