package vehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vehiculos.componentes.CombustibleEnum;
import vehiculos.componentes.Motor;
import vehiculos.componentes.Rueda;

public class ComponentesTest {

    @Test
    public void testRueda() {
        Rueda rueda = new Rueda();
        assertTrue((rueda.getVidaUtil() >= 20000 && rueda.getVidaUtil() <= 80000));

        rueda.addKmActual(100);
        assertEquals(100, rueda.getKmActual());

        rueda.addKmActual(80000);
        assertFalse(rueda.puedeRodar());
    }

    @Test
    public void testMotor() {
        Motor motor = new Motor(CombustibleEnum.DIESEL);
        assertTrue((motor.getVidaUtil() >= 50000 && motor.getVidaUtil() <= 150000));
        assertEquals(CombustibleEnum.DIESEL, motor.getCombustible());

        motor.addKmActual(100);
        assertEquals(100, motor.getKmActual());

        motor.addKmActual(150000);
        assertFalse(motor.puedeRodar());
    }
}
