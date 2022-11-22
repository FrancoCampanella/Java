public class Combo {
    private String nombre;
    private float precio;
    private float puntosDescuento;

    Combo(String nombre, float precio, float puntosDescuento){
        this.nombre = nombre;
        this.precio = precio;
        this.puntosDescuento = puntosDescuento;
    }

    public boolean esPosibleCanjearCombo(float puntosAcumulados){
        return puntosAcumulados >= this.getPuntosDescuento();
    }        

    public String getNombre() {
        return this.nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }    

    public float getPuntosDescuento() {
        return this.puntosDescuento;
    }
}
