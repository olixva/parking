package Vehiculos.Componentes;

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
