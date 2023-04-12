package Vehiculos;

import java.util.ArrayList;
import java.util.List;

import Vehiculos.Componentes.*;

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

        Thread hilo = new Thread(this);
        hilo.start();
        nCoches++;
    }
}
