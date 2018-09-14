package fr.univ_lyon1.info.m1.poneymon_fx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.univ_lyon1.info.m1.poneymon_fx.Model.PoneyModel;

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
     * Simple example test for the PoneyModel class.
     */
    @Test
    public void testMoveSpeed() {
        // Given
        PoneyModel p = new PoneyModel("green", 0);
        p.speed = 0.42;
        p.progression = 0;

        // When
        p.step();

        // Then
        assertEquals(p.progression, 0.42,  // TODO: wrong expected value (should be 0.42)
                     0.001);
    }
}
