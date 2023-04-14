package vehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vehiculos.componentes.CombustibleEnum;
import vehiculos.componentes.Rueda;

public class VehiculosTest {

    @Test
    public void testRodar() {
        Camion camion = new Camion();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean i = true;

        for (Rueda rueda : camion.getRuedas()) {

            if (rueda.getKmActual() == 0) {
                i = false;
            }
        }
        assertTrue(camion.getMotor().getKmActual() > 0);
        assertTrue(i);

    }

    @Test
    public void testCamion() {
        Camion camion = new Camion();
        assertEquals(8, camion.getRuedas().size());
        assertEquals(CombustibleEnum.DIESEL, camion.getMotor().getCombustible());
    }

    @Test
    public void testCoche() {
        Coche coche = new Coche();
        assertEquals(4, coche.getRuedas().size());
        assertEquals(CombustibleEnum.DIESEL, coche.getMotor().getCombustible());
    }

    @Test
    public void testMoto() {
        Moto moto = new Moto();
        assertEquals(2, moto.getRuedas().size());
        assertEquals(CombustibleEnum.GASOLINA, moto.getMotor().getCombustible());
    }

    @Test
    public void testPatinElectrico() {
        PatinElectrico patin = new PatinElectrico();
        assertEquals(2, patin.getRuedas().size());
        assertEquals(CombustibleEnum.ELECTRICO, patin.getMotor().getCombustible());
    }

}
