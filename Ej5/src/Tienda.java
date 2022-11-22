import java.time.LocalDate;
import java.util.ArrayList;

public class Tienda {
    private Registro registro;

    Tienda(){
        this.registro = new Registro();
    }

    public void AfiliarPersona(Persona persona){
        this.registro.setSocios(persona);
    }

    public void mostrarPeliculasDisponibles(){
        this.registro.mostrarPeliculas();
    }

    public void RegistrarAlquiler(Persona persona, ArrayList<Pelicula> peliculas, LocalDate fechaInit){
        if(this.registro.isSocio(persona)){
            ArrayList<VideoCasete> casetes = new ArrayList<>();
            for(Pelicula pelicula: peliculas){
                casetes.add(this.registro.getCasete(pelicula));
            }
            Alquiler a = new Alquiler(persona, casetes, fechaInit);
            this.registro.setAlquileres(a);
        }else{
            System.out.println("La persona " + persona.getNombre() + " no es socia del video club.");
        }
    }

    public void RegistrarDevolucion(Persona persona, LocalDate fechaFinPrestamo){
        if(this.registro.isSocio(persona)){
            this.registro.Devolucion(persona, fechaFinPrestamo);
        }else{
            System.out.println("La persona " + persona.getNombre() + " no es socia del video club.");
        }
    }

    public void RegistrarCasetes(ArrayList<VideoCasete> casetes){
        this.registro.setCasetes(casetes);
    }
}
