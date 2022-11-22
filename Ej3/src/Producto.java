public class Producto {
    private String NombreProd;
    private int costo;
    private int stock;

    Producto(String nombre, int Costo, int Stock){
        this.NombreProd = nombre;
        this.costo = Costo;
        this.stock = Stock;
    }

    Producto(String nombre){
        this.NombreProd = nombre;
        this.stock =0;
    }

    public int getStock(){
        return this.stock;
    }

    public int getCosto() {
        return this.costo;
    }

}
