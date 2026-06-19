import app.CuentaBancaria;
import app.Persona;

public class Aplicacion {
    public static void main(String[] args) {
        // 3 Instancias de persona
        Persona max = new Persona("Max", 30);
        Persona jake = new Persona("Jake", 25);
        Persona pia = new Persona("Pia", 30);

        // 3 instancias de cuenta bancaria
        CuentaBancaria cuentaMax = new CuentaBancaria(100, max);
        CuentaBancaria cuentaJake = new CuentaBancaria(150, jake);
        CuentaBancaria cuentaPia = new CuentaBancaria(300, pia);

       // Movimientos en la cuenta de Max
        System.out.println("\nMovimientos de Max");
        cuentaMax.depositar(50);
        System.out.println("Saldo de la cuenta: " + cuentaMax.getSaldo());
        cuentaMax.retirar(150);
        System.out.println("Saldo de la cuenta: " + cuentaMax.getSaldo());

        // Movimientos en la cuenta de Jake
        System.out.println("\nMovimientos de Jake");
        cuentaJake.depositar(10);
        System.out.println("Saldo de la cuenta: " + cuentaJake.getSaldo());
        cuentaJake.retirar(300);
        System.out.println("Saldo de la cuenta: " + cuentaJake.getSaldo());

        // muestra saldos de todas las cuentas
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();

        }



}