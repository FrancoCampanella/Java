public class Cliente {
    private String nombre;
    private int dni;
    private float puntosAcumulados;

    Cliente(String nombre, int dni, float puntosAcumulados){
        this.nombre = nombre;
        this.dni = dni;
        this.puntosAcumulados = puntosAcumulados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getPuntosAcumulados() {
        return this.puntosAcumulados;
    }

    public void setPuntosAcumulados(float puntos) {
        this.puntosAcumulados = +puntos;
    }    
}