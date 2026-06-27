package com;


import com.clases.*;


public class App {
    public static void main(String[] args) throws Exception {
        // 1. Instanciar la tienda
        TiendaElectronica miTienda = new TiendaElectronica();

        // 2. Crear instancias de productos (Televisor y Laptop)
        Televisor tv1 = new Televisor("Smart TV LG 55", 450.00, 3, 55, "4K Ultra HD");
        ComputadoraPortatil laptop1 = new ComputadoraPortatil("ThinkPad E14", 850.00, 1, "Lenovo", 16, "LNV123456");
        
        // Uso del constructor sobrecargado (inicia con stock 0)
        Televisor tvAgotada = new Televisor("TV Antigua", 100.00, 0, 32, "HD");

        // 3. Agregar productos al inventario
        System.out.println("=== Registrando Productos ===");
        miTienda.agregarProducto(tv1);
        miTienda.agregarProducto(laptop1);
        miTienda.agregarProducto(tvAgotada);

        // 4. Mostrar inventario inicial
        miTienda.mostrarInventario();

        // 5. Realizar ventas de prueba
        System.out.println("\n=== Procesando Ventas ===");
        miTienda.realizarVenta("ThinkPad E14"); // Debería venderse correctamente (quedará en 0)
        miTienda.realizarVenta("ThinkPad E14"); // Debería salir "Producto agotado"
        miTienda.realizarVenta("TV Antigua");   // Debería salir "Producto agotado"
        miTienda.realizarVenta("Smart TV LG 55"); // Debería venderse (quedará en 2)

        // 6. Mostrar inventario final para comprobar la actualización de stock
        miTienda.mostrarInventario();
    }
}
