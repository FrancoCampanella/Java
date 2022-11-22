//package Ej2;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList <Lector> usuarios;
    private ArrayList <Libro> libros;
    private int PeriodoPrestamo;
    private int factorConversion = 24*60*60*1000; //Un dia en milisegundos

    Biblioteca(ArrayList <Libro> Libros, ArrayList <Lector> Usuarios) {
        this.libros = Libros;
        this.usuarios = Usuarios;
    }

    public boolean CalcularMulta(Lector usuario){
        int DiasMultado;
        Date FechaInit = usuario.getFechaInicioPrestamo(), FechaFin = usuario.getFechaFinPrestamo();
        this.PeriodoPrestamo = (int) ((FechaFin.getTime() - FechaInit.getTime())/86400000);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //testDate toma el valor fechaFin para que no sea null y el algoritmo pueda correr
        //Este valor seria sobre escrito en lineas subsecuentes.
        Date testDate = FechaFin;
        if(this.PeriodoPrestamo>=30){
            DiasMultado = (this.PeriodoPrestamo - 30)*2;
            Long millisTime = (Long) (FechaFin.getTime() + (DiasMultado*this.factorConversion));
            usuario.setMultado(true);
            testDate.setTime(millisTime);
            df.format(testDate);
            usuario.setFechaMulta(testDate);
            return true;
        }else{
            usuario.setMultado(false);
            return false;
        }
    }
}
