public class CuentaPago {
    private Cliente usr;
    private Tarjeta tarjeta;
    private int saldo;

    CuentaPago(Cliente usuario, Tarjeta Tarjeta){
        this.usr = usuario;
        this.tarjeta = Tarjeta;
        this.saldo = 0;
    }

    public void IngresarSaldo(int Saldo){
        this.saldo = Saldo;
        System.out.println(this.usr.getNombre() + " deposito $" + Saldo);
    }

    public Cliente getUsr() {
        return this.usr;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
