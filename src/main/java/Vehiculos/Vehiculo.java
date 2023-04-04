package Vehiculos;

import java.util.List;

import Vehiculos.Componentes.*;

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

    public abstract void rodar(int distancia);

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

    public void setRuedas(List<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public boolean isAparcado() {
        return aparcado;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
    }

    public boolean isRoto() {
        return roto;
    }

    public void setRoto(boolean roto) {
        this.roto = roto;
    }

   

    
}
