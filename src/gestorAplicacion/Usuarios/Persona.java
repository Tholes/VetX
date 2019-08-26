package gestorAplicacion.Usuarios;
import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.prestacion.Cita;
import UIMain.Main;

import java.util.HashMap;
import java.util.Map;

public class Persona {
     /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    public static HashMap<String, Persona> usuarios = new HashMap<>();
    private static int cantidadPersonas;
    private int id;
    private String nombre;
    private String email;
    private String nombreUsuario;
    private String key;

    //Usuarios invitados.
    public Persona(){
        
    }

    public Persona(String nombre, String email,String usuario ,String key){
        this.nombre = nombre;
        this.email = email;
        this.nombreUsuario = usuario;
        this.key = key;
        cantidadPersonas++;
        this.id = cantidadPersonas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void registrarMascota(String nombre,String fechaNacimiento ,char sexo, String especie, String raza, Cliente cliente){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, cliente);

        //Registramos una nueva mascota al usuario
        cliente.setMascota(mascota);

        Mascota.registrarNuevaMascota(mascota);
    }

    public boolean borrarMascota(Mascota mascota, Cliente cliente) throws Throwable {
        if(cliente.getMascotas().contains(mascota)){
            cliente.borrarMascota(mascota);
            return true;
        }
        return false;
    }

    public boolean cancelarCita(Cita cita, Cliente cliente) throws Throwable {
        if(cliente.getCitasAsignadas().containsKey(cita)){
            cliente.getCitasAsignadas().remove(cita);
            cita.cancelarCita();
            return true;
        }
        return false;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getKey() {
        return key;
    }

    public static Persona fromUsuarioGetPersona(String usuario){
        return usuarios.get(usuario);
    }

    public static String login(String usuario, String key){
        Persona persona = Persona.fromUsuarioGetPersona(usuario);
        if(persona != null){
            if(persona.getNombreUsuario().equals(usuario) && persona.getKey().equals(key)){
                Main.setUsuarioActivo(persona);
                return "\t\tBienvenido "+ persona.getNombre();
            }
        }
        return "Datos ingresados no validos.";
    }

    public static void registrarVeterinario(String nombre,String email,String especialidad,byte experiencia ,int sueldo , long idTarjetaProfesional ,String usuario,String key){
        Veterinario veterinario = new Veterinario(nombre, email, especialidad, experiencia,sueldo,idTarjetaProfesional,usuario,key);
        //Se le debe asignar el menú de Veterinarios (Data.menuVeterinario)
        usuarios.put(usuario,veterinario);

    }

    public void borrarMiCuenta() throws Throwable {
        usuarios.remove(nombreUsuario);
        this.finalize();
    }

    public void registrarse(){
        //Se sobreescribira en cada clase hija
    }

    public void eliminarme() throws Throwable {
        usuarios.remove(id);
        this.finalize();
    }

    public static String listaUsuarios(){
        String ans = "Lista de usuarios: \n";
        int i = 0;
        for (Map.Entry<String, Persona> indice : usuarios.entrySet()) {
            Persona usuario = indice.getValue();
            ans += (i++ + 1) + ". Nombre: " + usuario.getNombre() + ", Nombre de Usuario: " + usuario.getNombreUsuario() + "\n";
        }
        return ans;
    }

    public static HashMap<String, Persona> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(HashMap<String, Persona> usuarios) {
        Persona.usuarios = usuarios;
    }

    public static void registrarUsuario(Persona usuario){
        usuarios.put(usuario.getNombreUsuario(),usuario);
    }
}
