//package Ej1;

public class Cliente {
    private int DNI;
    private String Nombre;
    private String Apellido;
    private float Saldo;
    private int ID;
    private boolean valido;
    private String movimientos = "";

    Cliente(int dni, String nombre, String apellido){
        this.DNI = dni;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.ID = this.ID + 1;
        this.Saldo = 0;
    }

    public void RealizarRetiro(float dinero){
        if(this.valido){
            if(this.Saldo >= dinero){
                this.Saldo = this.Saldo - dinero;
                this.setMovimientos("Retiro\r\n");
                System.out.println(this.Nombre + " " + this.Apellido + " retira $" + dinero);
            }else{
                System.out.println("Operacion invalida.\r\nNo tiene saldo suficiente");
            }
        }else{
            System.out.println("Cliente invalido!!");
        }
    }

    public void RealizarDeposito(float dinero){
        this.Saldo = this.Saldo + dinero;
        this.setMovimientos("Deposito\r\n");
        System.out.println("Deposito de " + dinero + " realizado con exito");
    }

    public void RealizarDeposito(float dinero, boolean Transferencia){
        if(Transferencia){
            this.Saldo = this.Saldo + dinero;
            this.setMovimientos("Recibo " + dinero + "\r\n");
            System.out.println("Recibo $" + dinero);
        }
    }

    public String ConsultarMovilientos(){
        return this.movimientos;
    }

    public void RealizarTransferencia(Cuenta cuentaUsr, float dinero){
        if(this.valido){
            if(this.Saldo >= dinero){
                this.Saldo = this.Saldo - dinero;
                cuentaUsr.getUsuario().RealizarDeposito(dinero, true);
                this.setMovimientos("Transferencia a " + cuentaUsr.getUsuario().getNombre() + " " + cuentaUsr.getUsuario().getApellido() + "\r\n");
                System.out.println(this.Nombre + this.Apellido + " transfiere $" + dinero);
            }else{
                System.out.println(this.Nombre + " " + this.Apellido + " no puede realizar esta operacion.\r\nNo tiene saldo suficiente");
            }
        }else{
            System.out.println("Cliente invalido!!");
        }
    }

    public void ConsultarSaldo(){
        if(this.valido){
            System.out.println(this.Nombre + " " + this.Apellido + " su saldo actual es " + this.Saldo);
        }else{
            System.out.println("Cliente invalido!!");
        }
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = this.movimientos + movimientos;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getApellido() {
        return this.Apellido;
    }
}
