package Vehiculos.Componentes;

public class Motor {

    private int vidaUtil;
    private int kmActual;
    private CombustibleEnum combustible;

    public Motor(CombustibleEnum combustible) {
        this.vidaUtil = (int) ((Math.random() * (150.000 - 50.000 + 1)) + 50.000);
        this.kmActual = 0;
        this.combustible = combustible;
    }

    public boolean puedeRodar() {
        return (kmActual < vidaUtil);
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public int getKmActual() {
        return kmActual;
    }

    public void addKmActual(int kmActual) {
        this.kmActual += kmActual;
    }
}
