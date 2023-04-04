package parking;

import Vehiculos.Camion;

public class Main {
    public static void main(String[] args) {
        Camion camion = new Camion();
        ParkingSingleton.getInstancia().aparcar(camion);
        ParkingSingleton.getInstancia().salir(camion);
    }
}
