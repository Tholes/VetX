package modelo.gestorAplicacion.Usuarios;

import java.util.ArrayList;

import modelo.BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import modelo.gestorAplicacion.Animales.*;
import modelo.gestorAplicacion.prestacion.*;
import java.util.HashMap;

public class Cliente extends Persona {

    public static  ArrayList<Integer> menuCliente = new ArrayList<>();
    public ArrayList<Integer> menuPersonal = new ArrayList<>();
    private static int cantidadClientes;
    private final int id;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private HashMap<Cita,Mascota> citasAsignadas = new HashMap<>();
    private ArrayList<Cita> citas = new ArrayList<>();

    public Cliente(){
        id = 0;
    }

    public Cliente(String nombre, String email,String usuario ,String contraseña) {
        super(nombre,email,usuario,contraseña);
        cantidadClientes++;
        id = cantidadClientes;
    }

    public int getId() {
        return id;
    }

    public static int getCantidadClientes() {
        return cantidadClientes;
    }

    public String mascotasRegistradas() {
        String listadoMascotas = "----------------------------------------------------------\n";
        if(mascotas.size() == 0){
            listadoMascotas += "No tiene mascotas registradas\n";
            listadoMascotas += "----------------------------------------------------------\n";
            return listadoMascotas;
        }
        else if (mascotas.size() == 1) {
            listadoMascotas += "Su mascota es: \n";
            listadoMascotas += "1. "+mascotas.get(0)+"\n";
            listadoMascotas += "----------------------------------------------------------\n";
            return listadoMascotas;
        }
        listadoMascotas = "Sus mascotas son: \n";
        for (int i = 0; i < mascotas.size(); i++) {
            listadoMascotas += (i+1)+". "+mascotas.get(i)+"\n";
        }
        listadoMascotas += "----------------------------------------------------------\n";
        return listadoMascotas;
    }

    public ArrayList<Mascota> getMascotas(){
        return mascotas;
    }

    public void setMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

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
        return "Soy " + super.getNombre() + " mi correo es: " + super.getEmail() + " y tengo " + mascotas.size() + " mascotas";
    }

    public void registrarMascota(String nombre,String fechaNacimiento ,char sexo, String especie, String raza){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, this);
        this.setMascota(mascota);
    }

    public boolean borrarMascota(Mascota mascota) throws Throwable{
        if(mascotas.contains(mascota)){
            mascotas.remove(mascota);
            mascota.eliminarMascota();
            return true;
        }
        return false;
    }

    public void borrarTodasLasMascotas() throws Throwable{
        while (!mascotas.isEmpty()){
            Mascota mascota = mascotas.get(0);
            mascota.eliminarMascota();
        }
    }

    public HashMap<Cita,Mascota> getCitasAsignadas() {
        return citasAsignadas;
    }

    public String getCitasSiguientes(){

        String ans;
        if(citas.isEmpty()){
            return "El cliente no tiene citas";
        }

        ans= "Citas del cliente: \n";
        for (int i = 0; i < citas.size(); i++) {
            ans += (i+1)+" "+citas.get(i)+"\n";
        }
        return ans;

    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCita(Cita cita, Mascota mascota){
        citasAsignadas.put(cita,mascota);
        citas.add(cita);
    }

    @Override
    public void borrarMiCuenta() throws  Throwable{
        borrarTodasLasMascotas();
        usuarios.remove(getNombreUsuario());
        this.finalize();
    }

    /*Se le asigna por defecto un menú a cada Cliente, pero no será el menú final*/

    public String registrarse(String nombre, String email, String usuario,String key) {
        if(!usuarios.containsKey(usuario)){
            Cliente cliente = new Cliente(nombre,email,usuario,key);
            usuarios.put(usuario,cliente);
            menuPersonal = getMenuCliente();
            Main.setUsuarioActivo(cliente);
            return "Registro completo.";
        }
        return "Nombre de usuario existente";
    }

    public static MenuDeConsola getMenu(Cliente cliente){
        ArrayList<Integer> indiceOpciones = menuCliente;
        MenuDeConsola menuUsuario = new MenuDeConsola(cliente,indiceOpciones);
        return menuUsuario;
    }

    public boolean cancelarCita(Cita cita) throws Throwable{
        if(citas.contains(cita)){
            citas.remove(cita);
            cita.cancelarCita();
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> getMenuCliente() {
        return menuCliente;
    }

    public static void setMenuCliente(ArrayList<Integer> menuCliente) {
        Cliente.menuCliente = menuCliente;
    }

    public ArrayList<Integer> getMenuPersonal() {
        return menuPersonal;
    }

    public void setMenuPersonal(ArrayList<Integer> menuPersonal) {
        this.menuPersonal = menuPersonal;
    }
}
