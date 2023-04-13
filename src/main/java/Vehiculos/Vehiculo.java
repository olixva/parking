package vehiculos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parking.ParkingSingleton;
import vehiculos.componentes.*;

/**
 * La clase abstracta Vehiculo define propiedades y comportamientos comunes para
 * los vehículos, como el
 * motor, las ruedas y el estado de estacionamiento y daños.
 */
public abstract class Vehiculo implements Runnable {

    private static final Logger log = LogManager.getLogger();

    protected Motor motor;
    protected List<Rueda> ruedas;
    protected boolean aparcado;
    protected boolean roto;

    protected Vehiculo(Motor motor) {
        this.motor = motor;
        this.aparcado = false;
        this.roto = false;
    }

    /**
     * Esta función simula un vehiculo que conduce una distancia aleatoria mientras
     * verifica si hay
     * problemas con el motor y las ruedas.
     * 
     * @return Un valor booleano.
     */
    private boolean rodar() throws InterruptedException {

        int km = (int) ((Math.random() * (5000 - 500 + 1)) + 500);
        int kmRecorridos = 0;

        for (int i = km; i > 0; i--, kmRecorridos++) {

            this.motor.addKmActual(1);

            for (Rueda rueda : this.ruedas) {
                rueda.addKmActual(1);
            }

            if (!this.motor.puedeRodar()) {
                roto = true;
                log.error("Ha sufrido un problema irreparable en el motor cuando llevaba " + kmRecorridos
                        + "km recorridos");
                return false;
            }

            for (Rueda rueda : this.ruedas) {
                if (!rueda.puedeRodar()) {
                    log.warn("se ha roto la rueda numero " + (this.ruedas.indexOf(rueda) + 1));
                    this.cambiarRueda(rueda);
                }
            }
        }

        Thread.sleep((km * 2));

        log.info("ha recorrido " + kmRecorridos + " km");

        return true;
    }

    /**
     * Esta función ejecuta un bucle que hace que ruede un vehículo y verifica si
     * puede estacionar en el parking, en caso de poder lo aparca.
     */
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

    /**
     * Esta función cambia la rueda estropeada a por una nueva
     */
    private void cambiarRueda(Rueda rueda) {

        this.ruedas.set(this.ruedas.indexOf(rueda), new Rueda());
        log.info("ha cambiado la rueda rota");

    }

    protected void setRuedas(List<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
    }

}
