package parking;

import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vehiculos.*;

/**
 * La clase ParkingSingleton es una implementación de un patrón de diseño
 * singleton que
 * administra espacios de estacionamiento para diferentes tipos de vehículos.
 */
public class ParkingSingleton {
    private static final Logger log = LogManager.getLogger();
    private static ParkingSingleton parking = null;
    private Vector<Camion> aparcamientosCamion = new Vector<>(2);
    private Vector<Coche> aparcamientosCoche = new Vector<>(4);
    private Vector<Moto> aparcamientosMoto = new Vector<>(4);
    private Vector<PatinElectrico> aparcamientosPatin = new Vector<>(2);

    private ParkingSingleton() {
    }

    public static ParkingSingleton getInstancia() {

        if (parking == null)
            parking = new ParkingSingleton();
        return parking;
    }

    /**
     * La función verifica si un vehículo determinado puede estacionar en un
     * estacionamiento en función
     * de su tipo y la disponibilidad de espacios de estacionamiento.
     * 
     * @param vehiculo un objeto de tipo Vehiculo, que es una superclase para
     *                 Camion, Coche, Moto y
     *                 Patin. El método verifica el tipo de vehículo.
     * @return El método devuelve un valor booleano que indica si el vehículo dado
     *         se puede estacionar
     *         o no, según la capacidad del estacionamiento correspondiente para ese
     *         tipo de vehículo.
     */
    public boolean puedeAparcar(Vehiculo vehiculo) {

        if (vehiculo instanceof Camion) {

            return (aparcamientosCamion.capacity() != aparcamientosCamion.size());
        } else if (vehiculo instanceof Coche) {

            return (aparcamientosCoche.capacity() != aparcamientosCoche.size());
        } else if (vehiculo instanceof Moto) {

            return (aparcamientosMoto.capacity() != aparcamientosMoto.size());

        } else {
            return (aparcamientosPatin.capacity() != aparcamientosPatin.size());
        }

    }

    /**
     * La función agrega un vehículo a un estacionamiento específico
     * según su tipo, establece su estado como
     * estacionado, espera un tiempo aleatorio y luego llama a la
     * función "salir" para retirar
     * el vehículo del estacionamiento.
     * 
     * @param vehiculo un objeto de tipo Vehiculo, que representa un vehículo que
     *                 necesita ser
     *                 estacionado en el estacionamiento.
     */
    public void aparcar(Vehiculo vehiculo) throws InterruptedException {

        if (vehiculo instanceof Camion) {
            aparcamientosCamion.add((Camion) vehiculo);
            vehiculo.setAparcado(true);
        } else if (vehiculo instanceof Coche) {
            aparcamientosCoche.add((Coche) vehiculo);
            vehiculo.setAparcado(true);

        } else if (vehiculo instanceof Moto) {
            aparcamientosMoto.add((Moto) vehiculo);
            vehiculo.setAparcado(true);
        } else {
            aparcamientosPatin.add((PatinElectrico) vehiculo);
            vehiculo.setAparcado(true);
        }

        log.info("ha entrado al parking");

        int tiempoAparcado = (int) ((Math.random() * (60 - 1 + 1)) + 1);
        Thread.sleep((tiempoAparcado * 1000));
        this.salir(vehiculo);

        log.info("ha salido del parking, ha estado aparcado " + tiempoAparcado + " segundos");
    }

    /**
     * La función saca un vehículo de su estacionamiento correspondiente y establece
     * su atributo
     * "aparcado" en falso.
     * 
     * @param vehiculo un objeto de la clase Vehiculo, que representa un vehículo
     *                 que necesita ser
     *                 retirado de un estacionamiento. El método verifica el tipo de
     *                 vehículo (Camion, Coche, Moto o
     *                 Patin) y lo retira del estacionamiento correspondiente.
     */
    private void salir(Vehiculo vehiculo) {

        if (vehiculo instanceof Camion) {
            aparcamientosCamion.remove(vehiculo);
            vehiculo.setAparcado(false);
        } else if (vehiculo instanceof Coche) {
            aparcamientosCoche.remove(vehiculo);
            vehiculo.setAparcado(false);

        } else if (vehiculo instanceof Moto) {
            aparcamientosMoto.remove(vehiculo);
            vehiculo.setAparcado(false);
        } else {
            aparcamientosPatin.remove(vehiculo);
            vehiculo.setAparcado(false);
        }
    }

}
