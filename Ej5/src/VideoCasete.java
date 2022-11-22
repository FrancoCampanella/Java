import java.util.ArrayList;

public class VideoCasete {
    private int nroCinta;
    private Formato formato;
    private int duracionCinta;
    private boolean alquilado;
    private ArrayList<Pelicula> peliculas;

    VideoCasete(int IDcinta, Formato format, int largoCinta){
        this.nroCinta = IDcinta;
        this.formato = format;
        this.duracionCinta = largoCinta;
        this.peliculas = new ArrayList<>();
        this.alquilado = false;
    }

    public void GrabarPelicula(Pelicula pelicula){
        if(this.duracionCinta>=pelicula.getDuracion()){
            this.setPeliculas(pelicula);
            this.setDuracionCinta(this.duracionCinta - pelicula.getDuracion());
            System.out.println("Pelicula " + pelicula.getTitulo() + " grabada con exito en el casete nro." + this.nroCinta);
        }else{
            System.out.println("El video casete nro." + this.nroCinta + " no dispone de cinta suficiente:\r\n-Duracion requerida: " + pelicula.getDuracion() + "\r\n-Duracion actual: " + this.duracionCinta);
        }
    }

    public ArrayList<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    public int getDuracionCinta() {
        return this.duracionCinta;
    }

    public int getNroCinta() {
        return this.nroCinta;
    }

    public boolean isAlquilado() {
        return this.alquilado;
    }

    public void setAlquilado(boolean alquilado){
        this.alquilado = alquilado;
    }

    private void setDuracionCinta(int duracionCinta) {
        this.duracionCinta = duracionCinta;
    }

    private void setPeliculas(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }
}
