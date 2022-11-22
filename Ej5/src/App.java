import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Actor actor1 = new Actor("Guillermo", 60, EstadoCivil.casado);
        Actor actor2 = new Actor("Ricardo", 64, EstadoCivil.divorciado);
        Actor actor3 = new Actor("Florencia", 54, EstadoCivil.divorciado);
        Actor actor4 = new Actor("Susana", 82, EstadoCivil.divorciado);

        ArrayList<Actor> actores = new ArrayList<>();
        actores.add(actor1);
        actores.add(actor3);
        Pelicula peli1 = new Pelicula("El secreto de sus ojos", 150, "Roberto Canessa", Categoria.drama, actores,1);

        actores.removeAll(actores);
        actores.add(actor2);
        actores.add(actor4);
        Pelicula peli2 = new Pelicula("Titanic", 220, "Rodrigo Paez", Categoria.drama, actores,2);

        VideoCasete video1 = new VideoCasete(1, Formato.VHS, 500);
        video1.GrabarPelicula(peli1);
        System.out.println("Duracion de la cinta: " + video1.getDuracionCinta());

        VideoCasete video2 = new VideoCasete(2, Formato.VHS, 500);
        video2.GrabarPelicula(peli2);
        System.out.println("Duracion de la cinta: " + video2.getDuracionCinta());

        Persona p1 = new Persona("Renzo", "Campanella", "2616978467", "Martinez 234");
        LocalDate fechaInit = LocalDate.now();
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        fechaInit = fechaInit.parse(18-02-2005, formatter);*/
        ArrayList<VideoCasete> videoCasetes = new ArrayList<>();
        videoCasetes.add(video1);
        videoCasetes.add(video2);

        ArrayList<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(peli1);
        peliculas.add(peli2);


        Tienda tienda = new Tienda();
        tienda.RegistrarCasetes(videoCasetes);
        tienda.mostrarPeliculasDisponibles();
        tienda.AfiliarPersona(p1);
        tienda.RegistrarAlquiler(p1, peliculas, fechaInit);

        LocalDate fechaFinPrestamo = LocalDate.now();
        tienda.RegistrarDevolucion(p1, fechaFinPrestamo.plusDays(6));
        
        /*Alquiler a1 = new Alquiler(p1, videoCasetes, fechaInit);

        Registro R1 = new Registro();
        R1.setAlquileres(a1);*/
    }
}
