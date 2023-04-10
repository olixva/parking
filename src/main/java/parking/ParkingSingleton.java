package parking;

import java.util.Vector;

import Vehiculos.*;

public class ParkingSingleton {

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
        System.out.println("El vehiculo " + vehiculo + "ha entrado al parking"); //TODO

        int tiempoAparcado = (int) ((Math.random() * (60 - 1 + 1)) + 1);
        Thread.sleep((tiempoAparcado * 1000));
        this.salir(vehiculo);
        System.out.println("El vehiculo " + vehiculo.getClass().toString() + "ha salido del parking y ha estado aparcado " + tiempoAparcado);
    }

    public void salir(Vehiculo vehiculo) {

        if (vehiculo instanceof Camion) {
            aparcamientosCamion.remove((Camion) vehiculo);
            vehiculo.setAparcado(false);
        } else if (vehiculo instanceof Coche) {
            aparcamientosCoche.remove((Coche) vehiculo);
            vehiculo.setAparcado(false);

        } else if (vehiculo instanceof Moto) {
            aparcamientosMoto.remove((Moto) vehiculo);
            vehiculo.setAparcado(false);
        } else {
            aparcamientosPatin.remove((PatinElectrico) vehiculo);
            vehiculo.setAparcado(false);
        }
    }

   

}
