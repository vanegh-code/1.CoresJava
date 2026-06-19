package clases;

public class Algoritmos {
    // Metodo numero par
    public static boolean esPar(int numero){
        return numero % 2 == 0;
    }

    // Metodo para verificar si es un numero primo
    public static boolean esPrimo(int numero){
        // Los numeros menores a dos  (1 o negativos) no son primos
        if(numero < 2){
            System.out.println("El numero " + numero + " es menor a 2");
            return false;
        }

        // Ciclo para revisar si alguna division es exacta
        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                System.out.println("El numero si es divisible");
                return false;
            }
            System.out.println("No es divisible en la posicion de " + i);
        }
        System.out.println(true);
        return true;
    }

    public static String stringEnReversa(String texto){
        String textoReversa = "";
        //HOLA
        //0123
        for(int i = texto.length() - 1; i >= 0; i--){
            //i=3
            //A
            textoReversa += texto.charAt(i);
            //textoReversa = HOLA.CharAt(A) = A
            // i = 2
            //L
            //textoReversa = A + HOLA.CharAt(L) = AL
            // i = 1
            //O
            //textoReversa = AL + HOLA.CharAt(O) = ALO
            //i = 0
            //H
            //textoReversa = ALO + HOLA.CharAt(H) = ALOH
        }
        return textoReversa;
    }

    public static boolean esPalindromo(String texto){
        String textoEnReversa = stringEnReversa(texto);
        return texto.equalsIgnoreCase(textoEnReversa);
    }

    public static void secuenciaFizzBuzz(int numero){
        for(int i=1; i<= numero; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0){
                System.out.println("Fizz");
            } else if(i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
