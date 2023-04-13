package vehiculos;

import java.util.ArrayList;
import java.util.List;

import vehiculos.componentes.*;

/**
 * La clase "PatinElectrico" amplía la clase "Vehiculo" y crea un patinete
 * eléctrico de dos ruedas y un motor electrico,
 * tambien crea un hilo de ejecucion con el nombre y numero
 * del patin creado y lo inicia.
 */
public class PatinElectrico extends Vehiculo {

    private static final int NUM_RUEDAS = 2;

    private static int nPatines = 1;

    public PatinElectrico() {
        super(new Motor(CombustibleEnum.ELECTRICO));

        List<Rueda> ruedas = new ArrayList<>();

        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }

        this.setRuedas(ruedas);

        Thread hilo = new Thread(this, (this.getClass().getName() + " " + nPatines));
        hilo.start();
        nPatines++;
    }
}
