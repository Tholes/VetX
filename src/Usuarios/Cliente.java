package Usuarios;

import java.util.ArrayList;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.seresVivos.*;

public class Cliente extends Persona {//Herencia de clase Persona, habría que cambiar muchas cosas abajo
    // pero serviría para reducir líneas de código, 
    //y no sobreescribir tantos setters y getters

    private static int cantidadClientes;
    private final int id;
    private ArrayList<Paciente> mascotas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();

    /*
    Coloqué el atributo telefono cómo opcional, en caso de no tener telefono tendrá un 0 cómo valor por defecto, el tipo de dato
    está en veremos, ya que al no hacer ningún tipo de operación con él, facilmente podríamos convertirlo en String
     */
    public Cliente(String nombre, String email, String ciudad, String direccion, long telefono) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        cantidadClientes++;
        this.id = cantidadClientes;
    }

    public Cliente(String nombre, String email, String ciudad, String direccion) {
        this(nombre, email, ciudad, direccion, 0);
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

    public void setMascotas(Paciente Mascota) {
        mascotas.add(Mascota);
    }

    /*
    Similar a getMascotas() aquí lo que hacemos es devolver una lista con los servicios usados en la veterinaria
    también llamando a su método toString()
     */
    public String getServicios() {
        String serviciosCompletos = "----------------------------------------------------------";
        serviciosCompletos += "Los servicios que ha usado " + this.nombre + " en nuestra veterinaria son: \n";

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
        return "Soy " + nombre + " mi correo es: " + email + " vivo en: " + direccion + " en la ciudad de " + ciudad + " y tengo " + mascotas.size() + " mascotas";
    }
}
