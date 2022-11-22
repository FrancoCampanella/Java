import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaGP {
    private ArrayList<Cliente> clientes;
    private int cobro;
    private LocalDateTime tiempoCobro;

    SistemaGP(ArrayList<Cliente> usrs){
        this.clientes = usrs;
        this.cobro = 0;
        this.tiempoCobro = LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 00));
    }

    public void confirmarPedido(){
        for(Cliente c: this.clientes){
            for(Pedido p: c.getPedido()){
                if(p.getCuentaPago().getSaldo() >= p.getCostoPedido()){
                    p.setEstado(EstadoPedido.confirmado);
                    System.out.println("El pedido " + p.getIdPedido() + " del cliente " + p.getCuentaPago().getUsr().getNombre() + " fue aprobado.\r\nQueda pendiente de cobro.");
                }else{
                    p.setEstado(EstadoPedido.rechazado);
                    System.out.println("El pedido " + p.getIdPedido() + " del cliente " + p.getCuentaPago().getUsr().getNombre() + " fue rechazado");
                    System.out.println("Saldo insuficiente");
                }
            }
        }
    }

    public void cobrarPedido(LocalDateTime t){
        if(t.equals(this.tiempoCobro)){
            for(Cliente c: this.clientes){
                for(Pedido p: c.getPedido()){
                    if((p.getEstado().equals(EstadoPedido.confirmado)) && (p.getCobro().equals(EstadoCobro.pendiente))){
                        p.getCuentaPago().setSaldo(p.getCuentaPago().getSaldo() - p.getCostoPedido());
                        this.cobro += p.getCostoPedido(); 
                        p.setCobro(EstadoCobro.cobrado);
                        System.out.println("Pedido " + p.getIdPedido() + " del cliente " + p.getCuentaPago().getUsr().getNombre() + " cobrado.");
                    }
                    this.ordenDistribucion(p);
                }
            }
        }else{
            System.out.println("El cobro se realiza todos los dias a las: " + this.tiempoCobro.getHour() + ":" + this.tiempoCobro.getMinute() + "hs");
        }
    }

    public void ordenDistribucion(Pedido pedido){
        if(pedido.getCobro().equals(EstadoCobro.cobrado)){
            pedido.getCuentaPago().getUsr().setEstadoEntrega(EstadoEntrega.enProceso);
            System.out.println("El pedido " + pedido.getIdPedido() + " esta en proceso.");
        }else{
            pedido.getCuentaPago().getUsr().setEstadoEntrega(EstadoEntrega.denegada);
            System.out.println("El pedido " + pedido.getIdPedido() + " fue denegado.");
        }
    }


}
