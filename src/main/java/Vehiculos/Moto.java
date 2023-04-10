package Vehiculos;

import java.util.ArrayList;
import java.util.List;

import Vehiculos.Componentes.*;

public class Moto extends Vehiculo {

    private static final int NUM_RUEDAS = 2;

    public Moto() {
        super(new Motor(CombustibleEnum.GASOLINA));

        List<Rueda> ruedas = new ArrayList<>();
        
        for (int i = 0; i < NUM_RUEDAS; i++) {
            ruedas.add(new Rueda());
        }
        
        this.setRuedas(ruedas);
    }

}
