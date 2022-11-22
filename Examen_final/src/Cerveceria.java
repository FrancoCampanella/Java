import java.util.ArrayList;

public class Cerveceria {
    private ArrayList<OrdenDeCompra> ordenesDeCompra;

    Cerveceria(){
        this.ordenesDeCompra = new ArrayList<>();
    }

    public int cantidadVendida(String nombreCombo){
        int cantVendida = 0;
        for(OrdenDeCompra orden: this.ordenesDeCompra){
            for(Combo combo: orden.getCombo()){
                if(nombreCombo.toLowerCase().equals(combo.getNombre().toLowerCase())){
                    cantVendida++;
                }
            }
        }
        return cantVendida;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        this.ordenesDeCompra.add(ordenDeCompra);
    }

    public ArrayList<OrdenDeCompra> getOrdenesDeCompra() {
        return this.ordenesDeCompra;
    }
}
