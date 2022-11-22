public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    Persona(String name, String surname, String telephone, String adress){
        this.nombre = name;
        this.apellido = surname;
        this.telefono = telephone;
        this.direccion = adress;
    }

    public String getNombre(){
        return this.nombre + " " + this.apellido;
    }
}
