package app;
import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    //Atributos
    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    // Atributo solamente de la clase, no del constructor
    public static ArrayList<CuentaBancaria> listaCuentasBancarias = new ArrayList<>();

    // Constructor
    public CuentaBancaria(double saldo, Persona titular){
        this.saldo = saldo;
        this.titular = titular;

        // Generamos numero aleatorio de 6 digitos a la cuenta
        Random numeroAleatorio = new Random();
        this.numeroCuenta = 100000 + numeroAleatorio.nextInt(900000);

        // Cuando creamos una cuenta, se agrega a la lista de cuentas bancarias
        listaCuentasBancarias.add(this);
    }

    // Metodo Getters y setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // metodos de retirar dinero
    public void depositar(double monto){
        this.saldo += monto;
        System.out.println("Depósito de: "+ monto +"realizado con éxito");

    }
// retirar dinero
public void retirar(double monto){
    if(monto > 0 && this.saldo >= monto){
        this.saldo -= monto;
        System.out.println("Retiro de: "+ monto + " realizado con éxito");
    } else {
        System.out.println("Saldos insuficientes");
    }
}

// Metodo despliega informacion
public void despliegaInformacion(){
    System.out.println("\n---------------------Datos de la cuenta---------------------");
    System.out.println("Numero de cuenta: " + this.numeroCuenta);
    System.out.println("Saldo de la cuenta: " + this.saldo);
    System.out.println("Titular de la cuenta: " + this.titular.getNombre());
    System.out.println("--------------------------------------------------------------");
    this.titular.despliegaInformacion();
}

// Metodo estatico para imprimir informacion de cuentas bancarias
public static void imprimeInformacionDeTodasLasCuentas(){
    System.out.println("Informacion de todas las cuentas bancarias");
    for(CuentaBancaria cuenta : listaCuentasBancarias){
        cuenta.despliegaInformacion();
    }
}

}
