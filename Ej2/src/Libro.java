//package Ej2;
public class Libro {
    public String nombre;
    public TipoLibro genero;
    public String editorial;
    public int anio;
    public Autor autor;
    public int ID;
    public Estado estado;

    Libro(String NombreLibro, TipoLibro Genero, String Editorial, int Anio, Autor AutorLibro, int IDLibro, Estado EstadoLibro){
        this.nombre = NombreLibro;
        this.genero = Genero;
        this.editorial = Editorial;
        this.anio = Anio;
        this.autor = AutorLibro;
        this.ID = IDLibro;
        this.estado = Estado.guardado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado(){
        return this.estado;
    }

}
