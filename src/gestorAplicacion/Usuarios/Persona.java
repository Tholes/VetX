package gestorAplicacion.Usuarios;
import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.prestacion.Cita;
import UIMain.Main;

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

    public static void registrarMascota(String nombre,String fechaNacimiento ,char sexo, String especie, String raza, Cliente cliente){
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

    public static String login(String usuario, String key){
        Persona persona = Persona.fromUsuarioGetPersona(usuario);
        if(persona != null){
            if(persona.getNombreUsuario().equals(usuario) && persona.getKey().equals(key)){
                Main.setUsuarioActivo(persona);
                return "Bienvenido "+ persona.getNombre();
            }
        }
        return "Datos ingresados no validos.";
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

    public void registrarse(){
        //Se sobreescribira en cada clase hija
    }
}
