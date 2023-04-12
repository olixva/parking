package parking;

import Vehiculos.Camion;
import Vehiculos.Coche;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ruta de configuración de Log4j: " + System.getProperty("log4j.configurationFile"));
        Camion camion = new Camion();
        Camion camion1 = new Camion();
        Camion camion2 = new Camion();
    }
}
