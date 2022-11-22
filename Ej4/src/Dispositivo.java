import java.util.Random;

public class Dispositivo {
    private String direccionIP = "";
    private String TipoDisp;

    Dispositivo(String type){
        if((type.equals("servidor"))||(type.equals("hub"))){
            Random rand = new Random();
            this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
            this.direccionIP += ",";
            this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
            this.direccionIP += ",";
            this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
            this.direccionIP += ",";
            this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
        }
        this.TipoDisp = type;
    }

    public boolean Connect(String IP, Puerto[] ports){
        //Si el dispositivo en cuestion no esta conectado, el puerto del dispositivo al que me quiero
        //conectar no esta en uso, y ambos puestos son del mismo tipo (fisico o logico), 
        //entonces puedo establecer una coneccion
        if((ports[0].getEstado() == false) && (ports[1].getTipoPuerto().equals(ports[0].getTipoPuerto()))){
            String [] auxIP = IP.split(",");
            this.direccionIP = auxIP[0] + "," + auxIP[1] + ",";
            Random rand = new Random();
            if((this.TipoDisp.equals("servidor"))||(this.TipoDisp.equals("hub"))){
                this.direccionIP = this.direccionIP + (rand.nextInt(10) + 1);
                this.direccionIP += ",";
                this.direccionIP = this.direccionIP + (rand.nextInt(4) + 1);
            }else{
                this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
                this.direccionIP += ",";
                this.direccionIP = this.direccionIP + (rand.nextInt(255-100+1)+100);
            }
            ports[0].setEstado(true);
            ports[1].setEstado(true);
            return true;
        }else{
            System.out.println("Dispositivo ya conectado / puerto ocupado.");
            return false;
        }
    }

    public String getDireccionIP() {
        return this.direccionIP;
    }

    public String getTipoDisp() {
        return this.TipoDisp;
    }
}
