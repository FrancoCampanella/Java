public class App {
    public static void main(String[] args) throws Exception {
        //Instancia de PC
        PC comp1 = new PC();
        PC comp2 = new PC();

        //Instancia de hub
        Hub h1 = new Hub(6);

        //Instancia de servidor
        Servidor server1 = new Servidor(2, 2);

        //Instancia de impresora
        Impresora imp1 = new Impresora();

        //Coneccion de dos PC al mismo hub
        comp1.Connect(h1);
        comp2.Connect(h1);

        /*System.out.println(comp1.getDireccionIP());
        System.out.println(h1.getDireccionIP());
        System.out.println(comp2.getDireccionIP());*/

        //Coneccion de un servidor a un hub por puerto fisico
        server1.Connect(h1, "fisico");

        //Envio de mensaje desde una PC a otra conectada al mismo hub (router)
        comp1.EnviarMensaje("hola", comp2);

        //Coneccion de una impresora a un hub
        imp1.Connect(h1);

        comp1.EnviarMensaje("Imprimime esto", imp1);
        imp1.Imprimir();

        //Envio de mensaje desde PC a un servidor
        comp2.EnviarMensaje("Hola servidor", server1);

        //Envio de mensaje desde un servidor a una PC
        server1.EnviarMensaje("Hola impresora", imp1);
        
    }
}
