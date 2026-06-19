import clases.Algoritmos;

public class Aplicacion {
    public static void main(String[] args) {
        
        // verificar si es un numero par
        System.out.println(Algoritmos.esPar(10));
        System.out.println(Algoritmos.esPar(11));

 // verificar si es un numero primo
        System.out.println(Algoritmos.esPrimo(1));
        System.out.println(Algoritmos.esPrimo(10));
        System.out.println(Algoritmos.esPrimo(31));
        System.out.println(Algoritmos.esPrimo(3));
        System.out.println(Algoritmos.esPrimo(23));

         // verificar texto reversa
        System.out.println(Algoritmos.stringEnReversa("Vanesca"));

        //verificar si es palindromo
        System.out.println(Algoritmos.esPalindromo("Vanesca"));
        System.out.println(Algoritmos.esPalindromo("Reconocer"));
        
        Algoritmos.secuenciaFizzBuzz(15);
        Algoritmos.secuenciaFizzBuzz(2);
    }
}
