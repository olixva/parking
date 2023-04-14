package parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vehiculos.Camion;

public class ParkingSingletonTest {

    @Test
    public void testGetInstancia() {
        ParkingSingleton parking = ParkingSingleton.getInstancia();
        assertEquals(parking, ParkingSingleton.getInstancia());
    }

    @Test
    public void testAparcar() throws InterruptedException {
        Camion camion = new Camion();
        ParkingSingleton.getInstancia().aparcar(camion);

        assertFalse(camion.isAparcado());
    }

    @Test
    public void testPuedeAparcar() throws InterruptedException {
        Camion camion = new Camion();

        assertTrue(ParkingSingleton.getInstancia().puedeAparcar(camion));
    }
}
