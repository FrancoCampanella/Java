import java.util.Random;

public class Puerto {
    public enum type{
        fisico,
        logico;
    }

    private type TipoPuerto;
    private String nroPort = "";
    private boolean estado;

    Puerto(String typePort){
        Random aux = new Random();
        if(typePort.equals("fisico")){
            this.TipoPuerto = type.fisico;
            this.nroPort = "COM" + (aux.nextInt(10)+1);
        }else{
            this.TipoPuerto = type.logico;
            int n = (aux.nextInt(100000) + 1000);
            this.nroPort += n; 
        }
        this.estado = false;
    }

    public String getNroPort() {
        return this.nroPort;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public String getTipoPuerto() {
        String port;
        if(this.TipoPuerto == type.fisico){
            port = "fisico";
        }else{
            port = "logico";
        }
        return port;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
