package vehiculos.componentes;

/**
 * La clase Motor representa un motor con una cierta vida útil generada
 * aleatoriamente entre 50000 y 150000 km, su kilometraje actual, y un tipo
 * específico de combustible.
 */
public class Motor {

    private int vidaUtil;
    private int kmActual;
    private CombustibleEnum combustible;

    public Motor(CombustibleEnum combustible) {
        this.vidaUtil = (int) ((Math.random() * (150000 - 50000 + 1)) + 50000);
        this.kmActual = 0;
        this.combustible = combustible;
    }

    public boolean puedeRodar() {
        return (kmActual < vidaUtil);
    }

    public void addKmActual(int kmActual) {
        this.kmActual += kmActual;
    }

    public CombustibleEnum getCombustible() {
        return combustible;
    }

    public int getKmActual() {
        return kmActual;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }
}
