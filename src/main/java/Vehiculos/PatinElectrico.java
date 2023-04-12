package Vehiculos;

import java.util.ArrayList;
import java.util.List;

import Vehiculos.Componentes.*;

public class PatinElectrico extends Vehiculo {

    private static final int NUM_RUEDAS = 4;

    private static int nPatines = 0;

    public PatinElectrico() {
        super(new Motor(CombustibleEnum.ELECTRICO));

        List<Rueda> ruedas = new ArrayList<>();
        
        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }
        
        this.setRuedas(ruedas);

        Thread hilo = new Thread(this);
        hilo.start();
        nPatines++;
    }
}
