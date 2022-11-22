import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        //PRUEBA GLOBAL
        Cliente cliente1 = new Cliente("Marcelo", 16102759, 0);
        Cliente cliente2 = new Cliente("Rodrigo", 16108510, 1000);

        Combo combo1 = new Combo("Thor", 1000, 5);
        Combo combo2 = new Combo("Thanos", 5000, 25);

        ArrayList<Float> precios = new ArrayList<>();
        precios.add((float) 10);
        precios.add((float) 20);
        precios.add((float) 30);

        ComboEspecial comboEs1 = new ComboEspecial("Iron man", 6000, 25, precios, 50);

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = formato.parse("2022/08/14");
        //================================================================

        //PRUEBA PUNTO 2
        System.out.println(comboEs1.esPosibleCanjearCombo(cliente2.getPuntosAcumulados()));
        //================================================================

        //PRUEBA PUNTO 3        
        OrdenDeCompra orden1 = new OrdenDeCompra(cliente1, combo1, fecha, 0);
        OrdenDeCompra orden2 = new OrdenDeCompra(cliente2, comboEs1, fecha, 0);
        OrdenDeCompra orden3 = new OrdenDeCompra(cliente1, combo2, fecha, 0);

        Cerveceria cerveceria = new Cerveceria();
        cerveceria.setOrdenDeCompra(orden1);
        cerveceria.setOrdenDeCompra(orden2);
        cerveceria.setOrdenDeCompra(orden3);

        System.out.println(cerveceria.cantidadVendida("iron man"));
        //================================================================


        System.out.println("Los puntos del cliente " + orden1.getCliente().get(0).getNombre() + " son: " + orden1.getCliente().get(0).getPuntosAcumulados());


    }
}
