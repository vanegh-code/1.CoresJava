package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
    private String marca;
    private int memoriaRAM;
    private String numeroSerie;

    public ComputadoraPortatil(String nombre, double precio, int cantidadDisponible, String marca, int memoriaRAM, String numeroSerie) {
        super(nombre, precio, cantidadDisponible);
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("[LAPTOP] Nombre: " + this.nombre + " | Precio: $" + this.precio + 
                           " | Stock: " + this.cantidadDisponible + " | Marca: " + marca + 
                           " | RAM: " + memoriaRAM + "GB | S/N: " + numeroSerie);
    }
}
