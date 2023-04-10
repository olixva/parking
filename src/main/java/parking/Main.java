package parking;

import Vehiculos.Camion;

public class Main {
    public static void main(String[] args) {
        
        Camion camion = new Camion();
        Thread hilo = new Thread(camion);
        hilo.start();
    }
}
