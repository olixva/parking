package parking;

import vehiculos.Camion;
import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.PatinElectrico;

/**
 * La clase Main genera 20 vehículos aleatorios (Camion, Coche, Moto o PatinElectrico) usando una
 * instrucción switch.
 */
public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            int nAleatorio = (int) (Math.random() * 4);

            switch (nAleatorio) {
                case 0:
                    new Camion();
                    break;

                case 1:
                    new Coche();
                    break;

                case 2:
                    new Moto();
                    break;

                case 3:
                    new PatinElectrico();
                    break;
            }
        }

    }
}
