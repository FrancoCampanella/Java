class Ej1 {
    public static void main(String[]args){
        double nro1, nro2;
        nro1 = 20;
        nro2 = 5;

        System.out.println("Se opera con los numeros " + nro1 + " y " + nro2 + ":");
        System.out.println("-Suma: " + suma(nro1,nro2));
        System.out.println("-Resta: " + resta(nro1,nro2));
        System.out.println("-Producto: " + producto(nro1,nro2));
        System.out.println("-Division: " + division(nro1,nro2));
        System.out.println("-Modulo: " + modulo(nro1,nro2));

    }

    static double suma(double a, double b){
        double sum;
        sum = a + b;
        return sum;
    }

    static double resta(double a, double b){
        double res;
        res = a - b;
        return res;
    }

    static double producto(double a, double b){
        double prod;
        prod = a*b;
        return prod;
    }

    static double division(double a, double b){
        double div;
        if(b>0 || b<0){
            div = a/b;
        }else{
            System.out.println("Division por 0 imposible!! Por vavor ingrese un nuevo numero");
            div = 0;
        }
        return div;
    }

    static double modulo(double a, double b){
        double mod;
        if(b>0 || b<0){
            mod = a%b;
        }else{
            System.out.println("Division por 0 imposible!! Por vavor ingrese un nuevo numero");
            mod = 0;
        }
        return mod;
    }
    
}