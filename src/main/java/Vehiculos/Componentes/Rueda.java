package vehiculos.componentes;

/**
 * La clase "Rueda" representa un neumático con una vida útil generada
 * aleatoriamente entre 20000 y 80000 km y un kilometraje actual.
 */
public class Rueda {

    private int vidaUtil;
    private int kmActual;

    public Rueda() {
        this.vidaUtil = (int) ((Math.random() * (80000 - 20000 + 1)) + 20000);
        this.kmActual = 0;
    }

    public boolean puedeRodar() {
        return (kmActual < vidaUtil);
    }

    public void addKmActual(int kmActual) {
        this.kmActual += kmActual;
    }

    public int getKmActual() {
        return kmActual;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }
}
