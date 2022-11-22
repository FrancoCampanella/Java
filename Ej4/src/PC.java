import java.util.Random;

public class PC extends Dispositivo {
    private Puerto[] puerto;
    private static int longitudMensaje = 20;
    private String Mensaje;
    private Hub HubConnected;

    PC(){
        super("PC");
        this.puerto = new Puerto[2];
        this.puerto[0] = new Puerto("fisico");
        this.puerto[1] = new Puerto("fisico");
    }
    
    public void Connect(Hub hub){
        Puerto[] portsAux = new Puerto[2];
        portsAux = hub.getPuertos("fisico");
        portsAux[1] = this.puerto[0];
        if(this.Connect(hub.getDireccionIP(), portsAux)){
            hub.setPuertos(portsAux, 0);
            this.HubConnected = hub;
            System.out.println("Dispositivos conectados:\r\n1-Puerto Hub: " + portsAux[0].getNroPort() + "\r\n2-Puerto PC: " + portsAux[1].getNroPort());
        }else{
            System.out.println("Connection failed!!");
        }
    }

    private void CrearMensaje(String msg){
        if(msg.length() <= PC.longitudMensaje){
            this.Mensaje = msg;
            System.out.println("Mensaje creado con exito");
        }else{
            System.out.println("Mensaje demasiado largo");
        }
        
    }

    public void EnviarMensaje(String msg, PC computer){
        if(computer.getHubConnected()!=null){
            Random probability = new Random();
            int p = probability.nextInt(2);
            System.out.println("Probabilidad: " + p);
            if(p == 1){
                this.CrearMensaje(msg);
                computer.setMensaje(msg);
                System.out.println("Mensaje: " + msg + "\r\nEnviado desde " + this.getDireccionIP() + " a " + computer.getDireccionIP());
            }else{
                System.out.println("Mensaje perdido. FALLA EN EL SISTEMA!!");
            }
        }
    }

    public void EnviarMensaje(String msg, Servidor server){
        if(server.getHubsConnected()!=null){
            Random probability = new Random();
            int p = probability.nextInt(2);
            System.out.println("Probabilidad: " + p);
            if(p == 1){
                this.CrearMensaje(msg);
                server.setMensaje(msg);
                System.out.println("Mensaje: " + msg + "\r\nEnviado desde " + this.getDireccionIP() + " a " + server.getDireccionIP());
            }else{
                System.out.println("Mensaje perdido. FALLA EN EL SISTEMA!!");
            }
        }
    }

    public void EnviarMensaje(String msg, Impresora imprent){
        if(imprent.getHubConnected()!=null){
            Random probability = new Random();
            int p = probability.nextInt(2);
            System.out.println("Probabilidad: " + p);
            if(p == 1){
                this.CrearMensaje(msg);
                imprent.setMensaje(msg);
                System.out.println("Mensaje: " + msg + "\r\nEnviado desde " + this.getDireccionIP() + " a " + imprent.getDireccionIP());
            }else{
                System.out.println("Mensaje perdido. FALLA EN EL SISTEMA!!");
            }
        }
    }

    public Hub getHubConnected() {
        return this.HubConnected;
    }

    public void setMensaje(String msg){
        this.Mensaje = msg;
    }
}
