import java.util.Random;

public class Tarjeta {
    private String nroTarjeta = "";

    Tarjeta(){
        Random aux = new Random();
        int digito = 0;
        int cont = 1;
        for(int i=0;i<16;i++){
            digito = aux.nextInt(10);
            if(i == cont*4){
                this.nroTarjeta = this.nroTarjeta + " " + digito;
                cont++;
            }else{
                this.nroTarjeta = this.nroTarjeta + digito;
            }
            
        }
    }

    public String getNroTarjeta() {
        return this.nroTarjeta;
    }
}
