package Vehiculos;

import java.util.ArrayList;
import java.util.List;

import Vehiculos.Componentes.*;

public class Camion extends Vehiculo {

    private static final int NUM_RUEDAS = 8;

    public Camion() {
        super(new Motor(CombustibleEnum.DIESEL));

        List<Rueda> ruedas = new ArrayList<>();
        
        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }
        
        this.setRuedas(ruedas);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    

}