package Vehiculos;

import java.util.List;

import Vehiculos.Componentes.*;
import parking.ParkingSingleton;

public abstract class Vehiculo implements Runnable {

    protected Motor motor;
    protected List<Rueda> ruedas;
    protected boolean aparcado;
    protected boolean roto;

    public Vehiculo(Motor motor) {
        this.motor = motor;
        this.aparcado = false;
        this.roto = false;
    }

    public void rodar() throws InterruptedException {

        int km = (int) ((Math.random() * (5000 - 500 + 1)) + 500);

        this.motor.addKmActual(km);

        for (Rueda rueda : this.getRuedas()) {
            rueda.addKmActual(km);
        }

        if (!this.motor.puedeRodar()) {
            roto = true;
            System.out.println("El motor se ha roto");// TODO
            Thread.interrupted();
        }

        for (Rueda rueda : this.ruedas) {
            if (!rueda.puedeRodar()) {
                System.out.println("La rueda " + rueda + "se ha roto"); // TODO
                this.cambiarRueda(rueda);
            }
        }
        Thread.sleep(km);

        // TODO
        System.out.println("El coche " + this + " ha recorrido " + km);
    }

    @Override
    public void run() {

        while (!this.roto) {
            
            try {
                
                this.rodar();
                ParkingSingleton.getInstancia().aparcar(this);
                

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
    }

    public void cambiarRueda(Rueda rueda){

        this.ruedas.set(this.ruedas.indexOf(rueda), new Rueda());
        System.out.println("La rueda del vehiculo " + this + " ha sido cambiada");
    }

    public void setRuedas(List<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

    public boolean isAparcado() {
        return aparcado;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
    }

    public void setRoto(boolean roto) {
        this.roto = roto;
    }

}
