public class Hub extends Dispositivo{
    private Puerto puertos[][];
    private int cantPuertosFisicos = 3;
    private int cantPuertosLogicos;
    
    Hub(int cantPuertos){
        super("hub");
        this.puertos = new Puerto [2][cantPuertos];
        for(int i=0; i<cantPuertos; i++){
            //Todo hub debe tener hasta 3 puertos COM (fisicos), el resto pueden ser logicos
            if(i<=3){
                this.puertos[0][i] = new Puerto("fisico");
                this.puertos[1][i] = new Puerto("fisico");
            }else{
                this.puertos[0][i] = new Puerto("logico");
                this.puertos[1][i] = new Puerto("logico");
            }
        }
        this.cantPuertosLogicos = cantPuertos - this.cantPuertosFisicos;
    }

    public Puerto[] getPuertos(String tipo) {
        Puerto[] ports = new Puerto[2];
        for(int i=0; i<(this.cantPuertosFisicos + this.cantPuertosLogicos);i++){
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
