package Vehiculos.Componentes;

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
}
