import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int duracion; //minutos
    private String director;
    private Categoria categoria;
    private ArrayList<Actor> actores;
    private int ID;

    Pelicula(String title, int duration, String Director, Categoria category, int id){
        this.titulo = title;
        this.duracion = duration;
        this.director = Director;
        this.categoria = category;
        this.actores = null;
        this.ID = id;
    }

    Pelicula(String title, int duration, String Director, Categoria category, ArrayList<Actor> actors, int id){
        this.titulo = title;
        this.duracion = duration;
        this.director = Director;
        this.categoria = category;
        this.actores = actors;
        this.ID = id;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public ArrayList<Actor> getActores() {
        if(this.actores!=null){
            return this.actores;
        }else{
            System.out.println("La pelicula " + this.titulo + " no tiene actores destacados.");
            return null;
        }
    }
}
