import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.text.View;

public class Registro {
    private int ingresos;
    private ArrayList<VideoCasete> Casetes;
    private ArrayList<Persona> Socios;
    private ArrayList<Alquiler> Alquileres;

    Registro(){
        this.Casetes = new ArrayList<>();
        this.Socios = new ArrayList<>();
        this.Alquileres = new ArrayList<>();
        this.ingresos = 0;
    }

    public boolean isSocio(Persona persona){
        for(Persona p: this.Socios){
            if(p.equals(persona)){
                return true;
            }
        }
        return false;
    }

    public void mostrarPeliculas(){
        ArrayList<Pelicula> peliculasGrabadas = new ArrayList<>();
        System.out.println("Peliculas disponibles:\r\n");
        int i = 0;
        for(VideoCasete c: this.Casetes){
            if(!c.isAlquilado()){
                peliculasGrabadas = c.getPeliculas();
                for(Pelicula p: peliculasGrabadas){
                    System.out.println(i++ + "-" + p.getTitulo());
                }
            }
        }
        if(i==0){
            System.out.println("No hay peliculas disponibles");
        }
    }

    public void mostrarActores(Pelicula pelicula){
        ArrayList<Actor> actores = new ArrayList<>();
        actores = pelicula.getActores();
        if(actores!=null){
            System.out.println("Los protagonistas de " + pelicula.getTitulo() +" son:\r\n");
            for(Actor a: actores){
                System.out.println(a);
            }
        }
    }

    public void Devolucion(Persona socio, LocalDate fechaFinPrestamo){
        for(Alquiler a: this.Alquileres){
            if(a.getSocio().equals(socio)){
                for(VideoCasete c: a.getVideoCasetes()){
                    for(VideoCasete cRegister: this.Casetes){
                        if(c.equals(cRegister)){
                            cRegister.setAlquilado(false);
                            System.out.println("Casete nro." + cRegister.getNroCinta() + " devuelto.");
                        }
                    }
                }
                a.setFechaFin(fechaFinPrestamo);
                if(a.isMulta()){
                    this.setIngresos(a.getValorMulta());
                }
            }
        }
    }

    public VideoCasete getCasete(Pelicula pelicula){
        ArrayList<Pelicula> peliculasCasete = new ArrayList<>();
        for(VideoCasete c: this.Casetes){
            peliculasCasete = c.getPeliculas();
            for(Pelicula p: peliculasCasete){
                if(pelicula.equals(p)){
                    return c;
                }
            }
        }
        System.out.println("Pelicula " + pelicula.getTitulo() + " no disponible");
        return null;
    }

    public void setAlquileres(Alquiler alquiler){
        this.Alquileres.add(alquiler);
        for(VideoCasete c: alquiler.getVideoCasetes()){
            for(VideoCasete cRegister: this.Casetes){
                if(c.equals(cRegister)){
                    cRegister.setAlquilado(true);
                    System.out.println("Casete nro." + cRegister.getNroCinta() + " alquilado");
                }
            }
        }
    }

    public void setSocios(Persona socio){
        this.Socios.add(socio);
        System.out.println("Nuevo socio: " + socio.getNombre());
    }

    public void setCasetes(VideoCasete casete) {
        this.Casetes.add(casete);
        System.out.println("Casete nro." + casete.getNroCinta() + " registrado con exito");
    }

    public void setCasetes(ArrayList<VideoCasete> casetes) {
        this.Casetes = casetes;
        System.out.println("Casetes registrados con exito");
    }

    public void setIngresos(int ingreso){
        this.ingresos += ingreso;
        System.out.println("Ingreso de $" + ingreso + " registrado con exito");
    }
}
