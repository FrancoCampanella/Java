import java.time.LocalDateTime;
import java.util.Random;

public class Impresora extends Dispositivo{
    private EstadoImpresora estado;
    private String Mensaje;
    private Hub HubConnected;
    private Puerto puerto;

    Impresora() {
        super("impresora");
        this.estado = EstadoImpresora.noAveriada;
        this.puerto = new Puerto("fisico");
    }

    public void Connect(Hub hub){
        Puerto[] portsAux = new Puerto[2];
        portsAux = hub.getPuertos("fisico");
        portsAux[1] = this.puerto;
        if(this.Connect(hub.getDireccionIP(), portsAux)){
            hub.setPuertos(portsAux, 0);
            this.HubConnected = hub;
            System.out.println("Dispositivos conectados:\r\n1-Puerto Hub: " + portsAux[0].getNroPort() + "\r\n2-Puerto inpresora: " + portsAux[1].getNroPort());
        }else{
            System.out.println("Connection failed!!");
        }
    }

    private void State(){
        Random rand = new Random();
        if(rand.nextInt(3) == 1){
            if(this.estado.equals(EstadoImpresora.noAveriada)){
                this.estado = EstadoImpresora.averiada;
            }else{
                this.estado = EstadoImpresora.noAveriada;
            }
        }
    }

    public void Imprimir(){
        this.State();
        if(this.Mensaje != null){
            if(this.estado == EstadoImpresora.noAveriada){
                System.out.println("Imprimiendo mensaje:\r\n" + this.Mensaje);
            }else{
                System.out.println("Impresora averiada. No pude imprimir");
            }
        }else{
            System.out.println("No hay nada que imprimir");
        }
    }

    public Hub getHubConnected() {
        return this.HubConnected;
    }

    public void setMensaje(String msg){
        this.Mensaje = msg;
    }
    
}
