//package Ej2;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Autor {
    public String nombre;
    public String nacionalidad;
    public Date FechaNac;

    Autor(String NombreAutor, String NacionalidadAutor, String FechaNacAutor){
        this.nombre = NombreAutor;
        this.nacionalidad = NacionalidadAutor;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        try{
            testDate = formatter.parse(FechaNacAutor);
        } catch (Exception e){ System.out.println("invalid format");}
 
        if (!formatter.format(testDate).equals(FechaNacAutor)){
            System.out.println("invalid date!!");
        } else {
            this.FechaNac = testDate;
        }
    }
}
