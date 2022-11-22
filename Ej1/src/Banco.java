//package Ej1;

import java.util.ArrayList;

public class Banco {
    private String Nombre;
    private int ID;
    private Consorcio consorcioBanco;
    ArrayList<Cuenta> cuentas;

    Banco(String NombreBanco, int IDBanco){
        this.Nombre = NombreBanco;
        this.ID = IDBanco;
        this.consorcioBanco = new Consorcio("Banelco", 1);
    }

    Banco(String NombreBanco, int IDBanco, Consorcio consorcio, ArrayList<Cuenta> Cuentas){
        this.Nombre = NombreBanco;
        this.ID = IDBanco;
        this.consorcioBanco = consorcio;
        this.cuentas = Cuentas;
    }
}
