import java.time.Period;
import java.util.ArrayList;

public class Cliente {
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String email;
    private ArrayList<Pedido> pedidoCompuesto;
    private Pedido pedido;
    private int costoPedidoCompuesto;
    private EstadoEntrega entrega;

    Cliente(String name, String adress, String phone, String Email){
        this.Nombre = name;
        this.Direccion = adress;
        this.Telefono = phone;
        this.email = Email;
        this.pedido = null;
        this.entrega = null;
    }

    public Pedido RealizarPedido(ArrayList<Producto> productos, CuentaPago cuentaPago, int id){
        if((cuentaPago.getSaldo()) > 0){
            this.pedido = new Pedido(productos, cuentaPago, id);
            return this.pedido;
        }else{
            System.out.println(cuentaPago.getUsr().getNombre() + " no tiene saldo disponible\r\n");
            return null;
        }
    }

    public void RealizarPedido(ArrayList<Pedido> pedidos){
        for(Pedido p: pedidos){
            if(p.getCuentaPago().getSaldo() > 0){
                this.costoPedidoCompuesto = this.costoPedidoCompuesto + p.getCostoPedido();
            }else{
                pedidos.remove(p);
                System.out.println("El pedido " + p.getIdPedido() + " no puede efectuarse.\r\nCuenta sin saldo.");
            }
        }
        if(pedidos != null){
            this.pedidoCompuesto = pedidos;
        }
    }

    public String getNombre(){
        return this.Nombre;
    }

    public ArrayList<Pedido> getPedido(){
        if(this.pedidoCompuesto==null){
            this.pedidoCompuesto.add(this.pedido);
        }
        return this.pedidoCompuesto;
    }

    public int getCostoPedido(){
        if(this.pedidoCompuesto!=null){
            return this.costoPedidoCompuesto;
        }else{
            return this.pedido.getCostoPedido();
        }
    }

    public void setEstadoEntrega(EstadoEntrega entrega) {
        this.entrega = entrega;
    }
}
