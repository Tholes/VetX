package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import gestorAplicacion.Animales.*;
import gestorAplicacion.prestacion.*;

public class Cliente extends Persona {

    private static int cantidadClientes;
    private final int id;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    
    public Cliente(String nombre, String email, String direccion, String ciudad, long telefono) {
        super(nombre,email,direccion,ciudad,telefono);
        cantidadClientes++;
        id = cantidadClientes;
    }

    public int getId() {
        return id;
    }

    public static int getCantidadClientes() {
        return cantidadClientes;
    }

    /*
    Cómo según los requerimientos del profe, estas clases no deben mostrar nada por pantalla, entonces debemos retornar todo.
    En este método getMascotas() lo que hacemos es devolver cada objeto (llamando a su toString()) en un tipo de "lista" 
     */
    public String getMascotas() {
        String listadoMascotas = "----------------------------------------------------------";
        if (mascotas.size() == 1) {
            listadoMascotas += "Su mascota es: \n";
            listadoMascotas += mascotas.get(0);
            listadoMascotas += "----------------------------------------------------------";
            return listadoMascotas;
        }
        listadoMascotas = "Sus mascotas son: \n";
        for (int i = 0; i < mascotas.size(); i++) {
            listadoMascotas += mascotas.get(i);
        }
        listadoMascotas += "----------------------------------------------------------";
        return listadoMascotas;
    }

    public void setMascotas(Mascota Mascota) {
        mascotas.add(Mascota);
    }

    /*
    Similar a getMascotas() aquí lo que hacemos es devolver una lista con los servicios usados en la veterinaria
    también llamando a su método toString()
     */
    public String getServicios() {
        String serviciosCompletos = "----------------------------------------------------------";
        serviciosCompletos += "Los servicios que ha usado " + super.getNombre() + " en nuestra veterinaria son: \n";

        for (int i = 0; i < servicios.size(); i++) {
            serviciosCompletos += servicios.get(i) + "\n";
        }
        serviciosCompletos += "----------------------------------------------------------";
        
        return serviciosCompletos;
    }

    public void setServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public String toString() {
        return "Soy " + super.getNombre() + " mi correo es: " + super.getEmail() + " vivo en: " + super.getDireccion() + " en la ciudad de " + super.getCiudad() + " y tengo " + mascotas.size() + " mascotas";
    }
}
