import java.time.LocalDate;
import java.util.ArrayList;

public class Alquiler {
    private ArrayList<VideoCasete> videoCasetes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean multa;
    private int valorMulta;
    private Persona socio;

    Alquiler(Persona Socio, ArrayList<VideoCasete> casetes, LocalDate fechaInit){
        this.socio = Socio;
        this.videoCasetes = casetes;
        this.fechaInicio = fechaInit;
        this.fechaFin = fechaInit.plusDays(3);
        this.multa = false;
        this.valorMulta = 0;
    }

    public void setFechaFin(LocalDate fechaFinPrestamo) {
        if(fechaFinPrestamo.isAfter(this.fechaFin)){
            this.multa = true;
            int DiasTarde = fechaFinPrestamo.getDayOfMonth() - this.fechaFin.getDayOfMonth();
            this.valorMulta = (DiasTarde)*100;
            System.out.println("El socio " + this.socio.getNombre() + " debe abonar $" + this.valorMulta + " de multa\r\nDevolucion " + DiasTarde + " dias atrasada.");
        }else{
            System.out.println("Devolucion de " + this.socio.getNombre() + " en tiempo y forma");
        }
        this.fechaFin = fechaFinPrestamo;
    }

    public Persona getSocio() {
        return this.socio;
    }

    public ArrayList<VideoCasete> getVideoCasetes() {
        return this.videoCasetes;
    }

    public boolean isMulta() {
        return this.multa;
    }

    public int getValorMulta() {
        return this.valorMulta;
    }
}
