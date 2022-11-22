//package Ej1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(16102759, "Beatriz", "Balarini");
        Cliente cliente2 = new Cliente(14041398, "Dante", "Campanella");
        Cuenta cuenta1 = new Cuenta(cliente1, "1234");
        Cuenta cuenta2 = new Cuenta(cliente2, "123456");

        ArrayList<Cuenta> usuarios = new ArrayList<>();
        usuarios.add(cuenta1);
        usuarios.add(cuenta2);

        Consorcio consorcio1 = new Consorcio("Link", 2);
        Banco banco = new Banco("Santander Rio", 1, consorcio1, usuarios);

        //Ingreso a la cuenta de Beatriz y realizo operaciones
        cliente1.setValido(cuenta1.ValidarTarjeta("1234"));
        cliente1.RealizarDeposito(10000);
        cliente1.RealizarRetiro(2000);
        cliente1.RealizarTransferencia(cuenta2, 5000);
        System.out.println("\r\nMovimientos de "+ cliente1.getNombre() + " " + cliente1.getApellido() + ":\r\n" + cliente1.ConsultarMovilientos());

        //Ingreso a la cuenta de Dante y observo movimientos
        cliente2.setValido(cuenta2.ValidarTarjeta("123456"));
        cliente2.ConsultarSaldo();
        System.out.println("\r\nMovimientos de "+ cliente2.getNombre() + " " + cliente2.getApellido() + ":\r\n" + cliente2.ConsultarMovilientos());
    }
}
