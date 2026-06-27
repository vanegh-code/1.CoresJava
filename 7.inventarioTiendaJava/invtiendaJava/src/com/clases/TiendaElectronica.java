package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private ArrayList<ProductoElectrodomestico> listaDeProductos;

    // Constructor inicializa la lista vacía
    public TiendaElectronica() {
        this.listaDeProductos = new ArrayList<>();
    }

    // Agregar producto
    public void agregarProducto(ProductoElectrodomestico producto) {
        listaDeProductos.add(producto);
        System.out.println("Producto '" + producto.getNombre() + "' agregado con éxito.");
    }

    // Mostrar todos los productos del inventario
    public void mostrarInventario() {
        System.out.println("\n--- INVENTARIO DE LA TIENDA ---");
        for (ProductoElectrodomestico prod : listaDeProductos) {
            prod.mostrarInformacion();
        }
        System.out.println("--------------------------------");
    }

    // Buscar producto por nombre
    public ProductoElectrodomestico buscarProducto(String nombre) {
        for (ProductoElectrodomestico prod : listaDeProductos) {
            if (prod.getNombre().equalsIgnoreCase(nombre)) {
                return prod;
            }
        }
        return null;
    }

    // Realizar venta
    public void realizarVenta(String nombreProducto) {
        ProductoElectrodomestico prod = buscarProducto(nombreProducto);
        
        if (prod == null) {
            System.out.println("El producto '" + nombreProducto + "' no existe en la tienda.");
            return;
        }

        if (prod.getCantidadDisponible() <= 0) {
            System.out.println("Producto agotado: No hay stock disponible para " + nombreProducto);
        } else {
            prod.setCantidadDisponible(prod.getCantidadDisponible() - 1);
            System.out.println("¡Venta exitosa! Se vendió 1 unidad de " + nombreProducto);
        }
    }
}
