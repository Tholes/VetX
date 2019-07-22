package gestorAplicacion.Usuarios;
import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.prestacion.Cita;
import UIMain.Main;
import java.io.IOException;
import java.util.Date;
public class Persona {

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

    public void registrarMascota(String nombre,Date fechaNacimiento ,char sexo, String especie, String raza, Cliente cliente){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, cliente);
        cliente.setMascota(mascota);
    }

    public boolean borrarMascota(Mascota mascota, Cliente cliente) throws Throwable {
        if(cliente.getMascotas().contains(mascota)){
            cliente.borrarMascota(mascota);
            return true;
        }
        return false;
    }

    public boolean pedirCita(int year,int mes, int dia){
        Date fecha = new Date(year,mes,dia); 
        if(Cita.getDisponibilidad().contains((CharSequence) fecha)){
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
        return Data.usuarios.get(usuario);
    }

    public static String login(String usuario, String contraseña){
        Persona persona = Persona.fromUsuarioGetPersona(usuario);
        if(persona != null){
            if(persona.getNombreUsuario().equals(usuario) && persona.getKey().equals(contraseña)){
                Main.setUsuarioActivo(persona);
                return "Bienvenido "+ persona.getNombre();
            }
        }
        return "Datos ingresados no validos.";
    }

    public static void registrarCliente(String nombre, String email, String usuario, String contraseña){
        Cliente cliente = new Cliente(nombre, email, usuario, contraseña);

        //Su menú sería el de cliente (Data.menuCliente).

        Data.usuarios.put(usuario,cliente);

    }

    public static void registrarVeterinario(String nombre,String email,String especialidad,byte experiencia ,int sueldo , long idTarjetaProfesional ,String usuario,String key){
        Veterinario veterinario = new Veterinario(nombre, email, especialidad, experiencia,sueldo,idTarjetaProfesional,usuario,key);
        //Se le debe asignar el menú de Veterinarios (Data.menuVeterinario)
        Data.usuarios.put(usuario,veterinario);

    }

    public void borrarMiCuenta() throws Throwable {
        Data.usuarios.remove(nombreUsuario);
        this.finalize();

    }
}
