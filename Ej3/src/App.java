import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Tarjeta tarjeta1 = new Tarjeta();
        Cliente cliente1 = new Cliente("Franco", "Videla Castillo 1056", "2616640471" , "franco@gmail.com");
        CuentaPago cuenta1 = new CuentaPago(cliente1, tarjeta1);
        cuenta1.IngresarSaldo(1000);
        
        //Instancio productos
        Producto p1 = new Producto("Coca Cola", 100, 50);
        Producto p2 = new Producto("Chocolate", 150, 50);
        Producto p3 = new Producto("Mayonesa", 80, 30);
        Producto p4 = new Producto("Pan", 50, 100);
        Producto p5 = new Producto("Leche", 100, 100);
        Producto p6 = new Producto("Queso", 200, 50);
        //---------------------------------------------

        //Instanciacion de pedidos por distintos medios
        ArrayList<Producto> productos1 = new ArrayList<>();
        productos1.add(p1);
        productos1.add(p2);
        productos1.add(p3);

        //Medio 1:
        Pedido pedido1 = new Pedido(productos1, cuenta1,0);
        //Medio 2:
        ArrayList<Producto> productos2 = new ArrayList<>();
        productos2.add(p4);
        productos2.add(p5);
        Pedido pedido2 = cliente1.RealizarPedido(productos2, cuenta1, pedido1.getIdPedido());
        //------------------------------------------------

        //Muestro ids de pedidos y sus costos
        System.out.println("IdPedido: " + pedido1.getIdPedido());
        System.out.println("Costo pedido " + pedido1.getIdPedido() + ": $" + pedido1.getCostoPedido());
        System.out.println("IdPedido: " + pedido2.getIdPedido());
        System.out.println("Costo pedido " + pedido2.getIdPedido() + ": $" + pedido2.getCostoPedido());
        //------------------------------------------------

        //Construyo un pedido compuesto
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        cliente1.RealizarPedido(pedidos);
        System.out.println(cliente1.getCostoPedido());
        //-----------------------------------------


        //Instanciacion del sistema de gestion de cobros
        ArrayList<Cliente> usuarios = new ArrayList<>();
        usuarios.add(cliente1);

        SistemaGP sys = new SistemaGP(usuarios);
        sys.confirmarPedido();
        
        //Los cobros se realizan solo a las 21 hs, todos los dias
        sys.cobrarPedido(LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 00)));
    }
}
