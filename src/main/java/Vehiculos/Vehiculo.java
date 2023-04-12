package Vehiculos;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Vehiculos.Componentes.*;
import parking.ParkingSingleton;

public abstract class Vehiculo implements Runnable {

    private static final Logger log = LogManager.getLogger();
   
    
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

        for (Rueda rueda : this.ruedas) {
            rueda.addKmActual(km);
        }

        log.debug("El coche ha recorrido");
        
        if (!this.motor.puedeRodar()) {
            roto = true;
            //System.out.println("El motor se ha roto");// TODO
            Thread.interrupted();
        }

        for (Rueda rueda : this.ruedas) {
            if (!rueda.puedeRodar()) {
                //System.out.println("La rueda " + rueda + "se ha roto"); // TODO
                this.cambiarRueda(rueda);
            }
        }
        Thread.sleep((km*2)); //TODO hacer que se duerma antes de poner los km recorridos
    }

    @Override
    public void run() {

        while (!this.roto) {
            
            try {
                
                this.rodar();
                
                if (!this.roto && ParkingSingleton.getInstancia().puedeAparcar(this)) 
                ParkingSingleton.getInstancia().aparcar(this);
                

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
    }

   
    public void cambiarRueda(Rueda rueda){

        this.ruedas.set(this.ruedas.indexOf(rueda), new Rueda());
        //System.out.println("La rueda del vehiculo " + this + " ha sido cambiada");
    }

    public void setRuedas(List<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
    }

    public void setRoto(boolean roto) {
        this.roto = roto;
    }

}
