package com.clases;

public class ProductoElectrodomestico {
// 1. Atributos 
    public String nombre;
    public double precio;
    public int cantidadDisponible;

    // 2. Constructor (inicializa los tres atributos )
    public ProductoElectrodomestico(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    // 3. Constructor sobrecargado (cantidadDisponible inicio en 0)
    public ProductoElectrodomestico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = 0; 
    }

    // getters y setters del productoElectrodomestico
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

  
   // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + cantidadDisponible);
    }
}
