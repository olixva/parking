package vehiculos;

import java.util.ArrayList;
import java.util.List;

import vehiculos.componentes.*;

/**
 * La clase Camion amplía la clase Vehiculo y crea un nuevo objeto Camion con 8
 * ruedas y un motor diesel
 * tambien crea un hilo de ejecucion con el nombre y numero del camion
 * creado y lo inicia.
 */
public class Camion extends Vehiculo {

    private static final int NUM_RUEDAS = 8;

    private static int nCamiones = 1;

    public Camion() {
        super(new Motor(CombustibleEnum.DIESEL));

        List<Rueda> ruedas = new ArrayList<>();

        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }

        this.setRuedas(ruedas);

        Thread hilo = new Thread(this, (this.getClass().getName() + " " + nCamiones));
        hilo.start();
        nCamiones++;
    }
}