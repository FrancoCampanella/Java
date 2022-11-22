//package Ej1;

import java.util.Random;

public class Cuenta {
    private double CBU;
    private String contrasenia;
    private Cliente usuario;

    Cuenta(Cliente usr, String pass){
        this.usuario = usr;
        this.contrasenia = pass;
        //Se genera un numero aleatorio de 22 digitos
        Random aux = new Random();
        this.CBU = aux.nextInt((int) (Math.pow(1, 23)));
        this.CBU = this.CBU + Math.pow(1, 22);
    }

    public boolean ValidarTarjeta(String pass){
        if(pass.equals(this.contrasenia)){
            System.out.println("Tarjeta Valida");
            return true;
        }else{
            System.out.println("Tarjeta Invalida");
            return false;
        }
    }

    public double getCBU() {
        return this.CBU;
    }

    public Cliente getUsuario() {
        return this.usuario;
    }
}
