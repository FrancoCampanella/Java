import java.util.ArrayList;
import java.util.Random;

public class Servidor extends PC{
    private Puerto puertos[][];
    private ArrayList<Hub> hubsConnected;
    private int cantPuertos;

    Servidor(int PuertosFisicos, int PuertosLogicos){
        this.cantPuertos = PuertosFisicos + PuertosLogicos;
        this.puertos = new Puerto [2][cantPuertos];
        this.hubsConnected = new ArrayList<>();
        for(int i=0; i<cantPuertos; i++){
            //Todo servidor tendra la cantidad especificada de cada puerto
            if(i<PuertosFisicos){
                puertos[0][i] = new Puerto("fisico");
                this.puertos[1][i] = new Puerto("fisico");
            }else{
                puertos[0][i] = new Puerto("logico");
                this.puertos[1][i] = new Puerto("logico");
            }
        }
    }

    public void Connect(Hub hub, String tipoPuerto){
        Puerto[] portsAuxHub, portsAux = new Puerto[2];
        portsAuxHub = hub.getPuertos(tipoPuerto);
        portsAux = this.getPuertos(tipoPuerto);
        portsAux[1] = portsAuxHub[0];
        if(this.Connect(hub.getDireccionIP(), portsAux)){
            hub.setPuertos(portsAux,1);
            this.setPuertos(portsAux, 0);
            this.hubsConnected.add(hub);
            System.out.println("Dispositivos conectados:\r\n1-Puerto Hub: " + portsAux[1].getNroPort() + "\r\n2-Puerto server: " + portsAux[0].getNroPort());
        }else{
            System.out.println("Connection failed!!");
        }
    }

    public Puerto[] getPuertos(String tipo) {
        Puerto[] ports = new Puerto[2];
        for(int i=0; i<(this.cantPuertos);i++){
            if((this.puertos[0][i].getTipoPuerto().equals(tipo)) && (this.puertos[0][i].getEstado()==false)){
                ports[0] = this.puertos[0][i];
                ports[1] = this.puertos[1][i];
                return ports;
            }
        }
        System.out.println("Todos los puertos " + tipo + " del dispositivo Hub se encuentran en uso");
        ports[0] = null;
        ports[1] = null;
        return ports;
    }

    public ArrayList<Hub> getHubsConnected() {
        return this.hubsConnected;
    }

    public void setPuertos(Puerto[] ports, int index) {
        int i = 0;
        while(!this.puertos[0][i].getNroPort().equals(ports[index].getNroPort())){
            i++;
        }
        if(index==1){
            this.puertos[1][i] = ports[0];
        }else{
            this.puertos[1][i] = ports[1];
        }
    }
}
