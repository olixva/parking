package vehiculos;

import java.util.ArrayList;
import java.util.List;

import vehiculos.componentes.*;

/**
 * La clase Coche amplía la clase Vehiculo y crea una nueva instancia de un
 * automóvil con cuatro ruedas y un motor diesel,
 * tambien crea un hilo de ejecucion con el nombre y numero
 * del coche creado y lo inicia.
 */
public class Coche extends Vehiculo {

    private static final int NUM_RUEDAS = 4;

    private static int nCoches = 1;

    public Coche() {
        super(new Motor(CombustibleEnum.DIESEL));

        List<Rueda> ruedas = new ArrayList<>();

        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }

        this.setRuedas(ruedas);

        Thread hilo = new Thread(this, (this.getClass().getName() + " " + nCoches));
        hilo.start();
        nCoches++;
    }
}
