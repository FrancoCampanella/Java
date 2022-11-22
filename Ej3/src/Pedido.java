import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> productos;
    private int costoPedido;
    private CuentaPago cuentaPago;
    private int idPedido=0;
    private EstadoPedido Estado;
    private EstadoCobro cobro;

    Pedido(ArrayList<Producto> products, CuentaPago paymentCount, int ID){
        for(Producto p: products){
            if(p.getStock() != 0){
                this.costoPedido = this.costoPedido + p.getCosto();
            }else{
                products.remove(p);
                System.out.println("El producto " + p + " no esta en stock");
            }
        }
        if(products != null){
            this.productos = products;
            this.cuentaPago = paymentCount;
            this.idPedido = ID + 1;
            this.Estado = null;
            this.cobro = EstadoCobro.pendiente;
        }
    }

    public int getCostoPedido() {
        return this.costoPedido;
    }

    public CuentaPago getCuentaPago() {
        return this.cuentaPago;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public EstadoPedido getEstado() {
        return this.Estado;
    }

    public EstadoCobro getCobro() {
        return this.cobro;
    }

    public void setCobro(EstadoCobro cobro) {
        this.cobro = cobro;
    }

    public void setEstado(EstadoPedido estado) {
        this.Estado = estado;
    }
}
