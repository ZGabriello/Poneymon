package fr.univ_lyon1.info.m1.poneymon_fx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.poneymon_fx.Controller.Controller;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.CoinModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.FieldModel;
import fr.univ_lyon1.info.m1.poneymon_fx.Model.PoneyModel;

class PoneyTest {

    /**
     * Test for the move Poney class.
     */
    @Test
    public void testMove() {
        // Given
        PoneyModel p = new PoneyModel(0);
        // When
        p.step();
        p.setNian(true);

        // Then
        assertEquals(p.getX(), 0 + p.getSpeed(), 0.001);
    }
    
    /**
     * Test for the speed Poney class when isNian.
     */
    @Test
    public void testBoost() {
        // Given
        PoneyModel p = new PoneyModel(0);
        // When
        p.setNian(true);
        // Then
        assertEquals(p.getSpeed(), p.getSpeed() / 2, 0.001);
    }
    
    /**
     * Test if the poney isWinner is true when laps == NB_TOURS.
     */
    @Test
    public void testIsWinner() {
        // Given
        PoneyModel p = new PoneyModel(0);
        // When
        p.setX(0.999);
        p.setLap(4);
        p.step();
        // Then
        assertEquals(p.getIsWinner(), true);
    }
    
    /**
     * Test if the speed has changed if the poney has ended a lap.
     */
    @Test
    public void testLapSpeedChange() {
        // Given
        PoneyModel p = new PoneyModel(0);
        // When
        p.setX(0.999);
        double speed = p.getSpeed(); 
        p.step();
        // Then
        assertNotEquals(p.getSpeed(), speed);
    }
    
    /**
     * Test if the nian mode isn't available anymore when once used.
     * Also checks that the nian is over when the lap is over.
     */
    @Test
    public void testNianUsed() {
        // Given
        PoneyModel p = new PoneyModel(0);
        // When
        p.setX(0.999);
        p.setNianManually(true);
        p.step();
        p.setNianManually(true);
        // Then
        assertEquals(p.getIsNian(), false);
    }
    
    /**
     * Test if the nian mode is activated when the poney gets a coin.
     */
    @Test
    public void testNianCoin() {
        // Given
        Controller controller = new Controller();
        FieldModel m = new FieldModel(controller);
        // When
        PoneyModel p = new PoneyModel(0);
        CoinModel c = new CoinModel(0);
        p.setX(0.6);
        c.setX(0.3);
        c.setVisible(true);
        m.getObjectsModel().add(p);
        m.getObjectsModel().add(c);
        m.step();
        // Then
        assertEquals(p.getIsNian(), true);
    }

    
    
}
