package BaseDatos;

import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;

import java.util.HashMap;

public class Data{
    public static HashMap<String, Cliente> clientes = new HashMap<>();
    public static HashMap<String, Veterinario> veterinarios = new HashMap<>();
    public static HashMap<String, Administrador> administradores = new HashMap<>();
    public static HashMap<String, Mascota> mascotas = new HashMap<>();
    public static HashMap<String, Cita> cita = new HashMap<>();

}

