import java.util.ArrayList;

public class ComboEspecial extends Combo{
    private ArrayList <Float> preciosObsequios;
    private float valorCanjeEspecial;

    ComboEspecial(String nombre, float precio, float puntosDescuento, ArrayList<Float> preciosObsequios, float valorCanjeEspecial){
        super(nombre, precio, puntosDescuento);
        this.preciosObsequios = preciosObsequios;
        this.valorCanjeEspecial = valorCanjeEspecial;
    }

    @Override
    public boolean esPosibleCanjearCombo(float puntosAcumulados){
        float sum = 0;
        for(float f: preciosObsequios){
            sum = sum + f;
        }
        return (puntosAcumulados >= this.getPuntosDescuento()) && (sum >= this.valorCanjeEspecial);
    }

    public ArrayList<Float> getPreciosObsequios() {
        return this.preciosObsequios;
    }

    public float getValorCanjeEspecial() {
        return this.valorCanjeEspecial;
    }
}