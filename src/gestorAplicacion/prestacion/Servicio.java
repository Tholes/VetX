package gestorAplicacion.prestacion;

import java.util.HashMap;

public class Servicio {
    /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    public static HashMap<Integer, Servicio>  serviciosPrestados = new HashMap<>();
    private String nombre;
    private int id;

    public Servicio(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Servicio{" + "nombre=" + nombre + ", id=" + id + '}';
    }
    
}

