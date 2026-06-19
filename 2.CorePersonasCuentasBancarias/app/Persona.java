package app;
public class Persona {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    // Metodos Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo para mostrar informacion
    public void despliegaInformacion(){
        System.out.println("Nombre: " + this.nombre + ", Edad: " + this.edad);
    }
}
