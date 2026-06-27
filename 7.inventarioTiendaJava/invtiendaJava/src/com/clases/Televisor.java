package com.clases;

public class Televisor extends ProductoElectrodomestico {
    private int tamanoPantalla;
    private String resolucion;

    // Constructor que invoca al de la clase padre usando super()
    public Televisor(String nombre, double precio, int cantidadDisponible, int tamanoPantalla, String resolucion) {
        super(nombre, precio, cantidadDisponible);
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
    }

    // Sobrecarga el método de mostrar información
    @Override
    public void mostrarInformacion() {
        System.out.println("[TELEVISOR] Nombre: " + nombre + " | Precio: $" + precio + 
                           " Stock" + cantidadDisponible + " | Pantalla: " + tamanoPantalla + 
                           "Resolución: " + resolucion);
    }
}
