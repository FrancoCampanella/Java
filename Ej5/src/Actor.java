public class Actor {
    private String nombre;
    private int edad;
    private EstadoCivil estadoCivil;

    Actor(String nombreActor, int edadActor, EstadoCivil estadoCivil){
        this.nombre = nombreActor;
        this.edad = edadActor;
        this.estadoCivil =estadoCivil;
    }

    public String toString(){
        String AuthorData, SC;
        if(this.estadoCivil.equals(EstadoCivil.soltero)){
            SC = "soltero";
        }else{
            SC = "casado";
        }
        AuthorData = "Nombre autor: " + this.nombre + "\r\nEdad: " + this.edad + "\r\nEstado Civil: " + SC;
        return AuthorData;
    }
}
