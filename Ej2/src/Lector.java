//package Ej2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lector {
    public String nombre;
    public int IDLector;
    public Libro[] libros = new Libro[3];
    public Boolean multado;
    private int cantLibros;
    public Date FechaInicioPrestamo;
    public Date FechaFinPrestamo;
    private Date FechaMulta;

    Lector(String NombreLector, int idLector){
        this.nombre = NombreLector;
        this.IDLector = idLector;
        this.multado = false;
        this.cantLibros = 0;
    }

    //La siguiente funcion almacena el objeto libro uno a uno dentro del array "libros" propio del usuario.
    public void PideLibro(Libro libro){
        //Si el libro esta guardado en la biblioteca, el usuario lo lleva. Si no, se muestra el mensaje 
        //del problema que hace que el usuario no pueda llevarse el libro.
        if(libro.getEstado() == Estado.guardado){
            if(this.cantLibros < 3){
                String initEnd = "inicio";
                if(this.Registro(initEnd) == true){
                    this.libros[this.cantLibros] = libro;
                    this.cantLibros = this.cantLibros + 1;
                    libro.setEstado(Estado.prestado);
                    System.out.println("Libro " + libro.nombre + " " + libro.estado + "\r\n");
                }
            }else{
                System.out.println("El usuario nro " + this.IDLector + ", " + this.nombre + " no puede solicitar un nuevo libro");
            }
        }else{
            System.out.println("El libro " + libro.nombre + " se encuentra en " + libro.estado + "\r\n");
        }
    }

    //La siguiente funcion devuelve todos los libros de una vez.
    //Setea el estado de cada libro a guardado y vacia el array de libros que tenia el usuario
    public boolean DevolverLibros(){
        for(int i=0; i<this.libros.length; i++){
            if(this.libros[i] != null){
                String initEnd = "fin";
                if(this.Registro(initEnd) == true){
                    this.libros[i].setEstado(Estado.guardado);
                    System.out.println("Libro " + this.libros[i].nombre + " " + this.libros[i].estado + "\r\n");
                    this.libros = this.EliminarLibro(this.libros, i);
                    return true;
                }
            }
        }
        System.out.println(this.nombre + "no posee ningun libro\r\n");
        return false;
    }

    //Implementacion de la funcion "DevuelveLibro" que devuelve uno a uno cada libro, segun su nombre.
    /*public void DevuelveLibro(String libro){
        boolean flag = false;
        for(int i=0; i<this.libros.length; i++){
            if(libro.equals(this.libros[i].nombre.toLowerCase())){
                this.libros = this.EliminarLibro(this.libros, i);
                this.libros[i].setEstado(Estado.guardado);
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Usted no posee el libro " + libro + "\r\nPor favor ingrese otro nombre");
        }
    }*/

    //Funcion que elimina un elemento de un arreglo de objetos. Recibe como parámetros:
    //1-El arreglo
    //2-El indice del objeto que se desea eliminar
    private Libro[] EliminarLibro( Libro [] arr, int index ){
        Libro[] arrDestination = new Libro[arr.length - 1];
        int remainingElements = arr.length - ( index + 1 );
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
        return arrDestination;
    }

    //El siguiente metodo setea las fechas de inicio y fin de cada prestamo.
    private boolean Registro(String Init_or_End){

        boolean flag;
        System.out.println("\r\nIngrese la fecha de " + Init_or_End + " del prestamo en el formato dd/mm/yyyy:");
        Scanner sc = new Scanner(System.in);
        String fecha = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        try{
            testDate = df.parse(fecha);
        } catch (Exception e){ System.out.println("Formato invalido!!");}
 
        if (!df.format(testDate).equals(fecha)){
            System.out.println("Fecha invalida!!\r\n");
            flag = false;
        } else {
            if(Init_or_End == "inicio"){
                this.FechaInicioPrestamo = testDate;
            }else if(Init_or_End == "fin"){
                this.FechaFinPrestamo = testDate;
            }
            flag = true;
        }
        return flag;
    }

    public void setMultado(Boolean multado) {
        this.multado = multado;
    }

    public void setFechaMulta(Date fechaMulta) {
        this.FechaMulta = fechaMulta;
    }

    public Date getFechaMulta() {
        return this.FechaMulta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Date getFechaInicioPrestamo() {
        return this.FechaInicioPrestamo;
    }

    public Date getFechaFinPrestamo() {
        return this.FechaFinPrestamo;
    }
}
