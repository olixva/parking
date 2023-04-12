package Vehiculos;

import java.util.ArrayList;
import java.util.List;

import Vehiculos.Componentes.*;

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

        Thread hilo = new Thread(this, (this.getClass().getName()+" "+nCamiones));
        hilo.start();
        nCamiones++;
    }
}