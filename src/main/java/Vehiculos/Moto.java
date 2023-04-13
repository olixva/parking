package vehiculos;

import java.util.ArrayList;
import java.util.List;

import vehiculos.componentes.*;

/**
 * La clase Moto amplía la clase Vehiculo y crea instancias de motocicletas con
 * dos ruedas y motor de gasolina,
 * tambien crea un hilo de ejecucion con el nombre y numero de la moto
 * creada y lo inicia.
 */
public class Moto extends Vehiculo {

    private static final int NUM_RUEDAS = 2;

    private static int nMotos = 1;

    public Moto() {
        super(new Motor(CombustibleEnum.GASOLINA));

        List<Rueda> ruedas = new ArrayList<>();

        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }

        this.setRuedas(ruedas);

        Thread hilo = new Thread(this, (this.getClass().getName() + " " + nMotos));
        hilo.start();
        nMotos++;
    }
}
