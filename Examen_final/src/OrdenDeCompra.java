import java.util.ArrayList;
import java.util.Date;

public class OrdenDeCompra {
    private ArrayList<Cliente> cliente;
    private ArrayList<Combo> combo;
    private Date fecha;
    private float descuento;

    OrdenDeCompra(Cliente cliente, Combo combo, Date fecha, float descuento){
        //cliente.setPuntosAcumulados(combo.getPuntosDescuento());

        this.cliente = new ArrayList<>();
        this.combo = new ArrayList<>();

        this.cliente.add(cliente);
        this.combo.add(combo);
        this.fecha = fecha;
        this.descuento = descuento;
    }

    OrdenDeCompra(Cliente cliente, ArrayList<Combo> combo, Date fecha, float descuento){
        /*for (Combo c: combo) {
            cliente.setPuntosAcumulados(c.getPuntosDescuento());
        }*/

        this.cliente = new ArrayList<>();

        this.cliente.add(cliente);
        this.combo = combo;
        this.fecha = fecha;
        this.descuento = descuento;
    }

    OrdenDeCompra(ArrayList<Cliente> cliente, Combo combo, Date fecha, float descuento){
        /*for (Cliente c: cliente) {
            c.setPuntosAcumulados(combo.getPuntosDescuento());
        }*/

        this.combo = new ArrayList<>();

        this.cliente = cliente;
        this.combo.add(combo);
        this.fecha = fecha;
        this.descuento = descuento;
    }

    OrdenDeCompra(ArrayList<Cliente> cliente, ArrayList<Combo> combo, Date fecha, float descuento){
        /*for (Cliente c: cliente) {
            for(Combo com: combo){
                c.setPuntosAcumulados(com.getPuntosDescuento());
            }
        }*/

        this.cliente = cliente;
        this.combo = combo;
        this.fecha = fecha;
        this.descuento = descuento;
    }        

    public ArrayList<Cliente> getCliente() {
        return this.cliente;
    }

    public ArrayList<Combo> getCombo() {
        return this.combo;
    }

    public float getDescuento() {
        return this.descuento;
    }
}
