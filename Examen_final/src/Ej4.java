import java.util.Date;

public class Ej4{
    public static void main(String[] args) throws Exception {
        Combo c1 = new Combo("Capitán América",300,125);
        Combo c2 = new Combo("Gamora",199,50);
        Combo c3 = new Combo("Thor", 250,350);
        
        Cliente cliente = new Cliente("Juan Pérez", 23567892,500);
        
        OrdenDeCompra o1 = new OrdenDeCompra(cliente, c1, new Date(),10);
        OrdenDeCompra o2 = new OrdenDeCompra(cliente, c2, new Date(),20);
        OrdenDeCompra o3 = new OrdenDeCompra(cliente, c3, new Date(),5);
        
        System.out.println(metodoSinNombreRepresentativo(cliente, c1, o1));
        System.out.println(cliente.getPuntosAcumulados());
        System.out.println(metodoSinNombreRepresentativo(cliente, c2, o2));
        System.out.println(cliente.getPuntosAcumulados());
        System.out.println(metodoSinNombreRepresentativo(cliente, c3, o3));   
        System.out.println(cliente.getPuntosAcumulados());
    }

    static float metodoSinNombreRepresentativo(Cliente cliente, Combo combo, OrdenDeCompra orden) {

        if (combo.esPosibleCanjearCombo(cliente.getPuntosAcumulados())) {
        
        float variableSinNombreRepresentativo1=combo.getPrecio()
        -(orden.getDescuento()*combo.getPrecio()/100);
        combo.setPrecio(variableSinNombreRepresentativo1);
        
        float variableSinNombreRepresentativo2=cliente.getPuntosAcumulados()
        - combo.getPuntosDescuento();
        
        cliente.setPuntosAcumulados(variableSinNombreRepresentativo2);
        
        }
        return combo.getPrecio();
        
    }
}