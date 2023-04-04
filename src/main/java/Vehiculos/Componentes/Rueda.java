package Vehiculos.Componentes;

public class Rueda {

    private int vidaUtil;
    private int kmActual;

    public Rueda() {
        this.vidaUtil = (int) ((Math.random() * (80.000 - 20.000 + 1)) + 20.000);
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
