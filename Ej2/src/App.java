//package Ej2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Autor a1 = new Autor("Ricardo", "Argentino", "10/11/1965");
        Libro libro1 = new Libro("GOT", TipoLibro.ensayo , "Santillan", 1990, a1, 1, Estado.guardado);
        Libro libro2 = new Libro("Prince", TipoLibro.ensayo , "Santillan", 1990, a1, 1, Estado.guardado);
        Libro libro3 = new Libro("King in the north", TipoLibro.ensayo , "Santillan", 1990, a1, 1, Estado.guardado);
        Libro libro4 = new Libro("Harry Potter", TipoLibro.ensayo , "Santillan", 1990, a1, 1, Estado.guardado);
        Lector usuario1 = new Lector("Joaquin Santiesteban", 1);
        Lector usuario2 = new Lector("Mariano Martin", 2);
        ArrayList <Libro> libros = new ArrayList<>();
        ArrayList <Lector> usuarios = new ArrayList<>();

        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        /*String hoy = "10/01/2020";
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date hoyDate = format.parse(hoy);
        System.out.println(hoyDate.getTime()/86400000);*/

        Biblioteca bib = new Biblioteca(libros, usuarios);
        Scanner sc = new Scanner(System.in);
        boolean noExiste = true;
        while(noExiste == true){
            System.out.println("Ingrese su nombre de usuario: ");
            String name = sc.nextLine();
            for(int i=0; i<usuarios.size(); i++){
                if(name.equals(usuarios.get(i).getNombre())){
                    while(true){
                        System.out.println("Escriba la operacion que desea realizar:\r\n1-Solicitar libro\r\n2-Devolver libro\r\n3-Exit");
                        int answ = sc.nextInt();
                        if(answ == 1){
                            Solicitud(usuarios.get(i), libros);
                        }else if(answ == 2){
                            if (usuarios.get(i).DevolverLibros()){
                                System.out.println("\r\nVerificando cumplimiento en la fecha de entrega..");
                                if (bib.CalcularMulta(usuarios.get(i))){
                                    System.out.println("Usuario " + usuarios.get(i).getNombre() + " multado hasta " + usuarios.get(i).getFechaMulta());
                                }else{
                                    System.out.println("El usuario " + usuarios.get(i).getNombre() + " entrega en tiempo y forma.");
                                }
                            }
                        }else if(answ == 3){
                            break;
                        }else{
                            System.out.println("Solicitud invalida!!");
                        }
                    }
                    noExiste = false;
                }
            }

            if(noExiste == true){
                System.out.println("El usuario " + name + " no esta registrado");
            }
        }
    }

    public static void Solicitud(Lector usuario, ArrayList<Libro> libros){
        Scanner sc = new Scanner(System.in);
        int nroLibros=0;
        boolean flag = true;
        while (flag == true){
            System.out.println("Escriba el numero de libros que desea solicitar");
            nroLibros = sc.nextInt();
            if(nroLibros == 1){
                System.out.println("Escriba el nombre del libro: ");
                flag = false;
            }else if((nroLibros > 1) && (nroLibros <= 3)){
                System.out.println("Escriba los nombres de los libros separados por ENTER: ");
                flag = false;
            }else{
                System.out.println("Solo puede solicitar hasta 3 libros. Por favor intente nuevamente.\r\n");
            }
        }

        String solicitud, libroAux;
        for(int j=0; j<=nroLibros; j++){
            solicitud = sc.nextLine();
            solicitud = solicitud.toLowerCase();
            for(int i=0; i<libros.size(); i++){
                libroAux = libros.get(i).nombre.toLowerCase();
                if(solicitud.equals(libroAux)){
                    usuario.PideLibro(libros.get(i));
                }
            }
        }
    }
}