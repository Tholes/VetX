package BaseDatos;

import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;
import gestorAplicacion.Usuarios.Persona;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Data{

    public static HashMap<String, Persona> usuarios = new HashMap<>();
    public static HashMap<String, HashMap<String,Mascota>> mascotas = new HashMap<>();
    public static HashMap<Integer, Cita> citas = new HashMap<>();
    public static String[] menuCliente;
    public static String[] menuVeterinario;
    public static String[] menuAdministrador;

    public static void cargarDatos(){
        String ruta = System.getProperty("user.dir")+"\\src\\temp";
        cargarClientes(ruta);
        cargarAdministradores(ruta);
        cargarVeterinarios(ruta);
        cargarMascotas(ruta);
        cargarCitas(ruta);
        cargarMenuUsuarios(ruta);
    }

    public static void cargarClientes(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"cliente.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] cliente = line.split(";");
                    String nombre = cliente[0];
                    String email = cliente[1];
                    String usuario = cliente[2];
                    String contraseña = cliente[3];
                    usuarios.put(usuario, new Cliente(nombre,email,usuario,contraseña));
                }
            }
            br.close();
        } catch (Exception e){

        }
    }

    public static void cargarAdministradores(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"administradores.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] administrador = line.split(";");
                    String nombre = administrador[0];
                    String email = administrador[1];
                    String usuario = administrador[2];
                    String contraseña = administrador[3];
                    usuarios.put(usuario, new Administrador(nombre,email,usuario,contraseña));
                }
            }
            br.close();
        } catch (Exception e){

        }

    }

    public static void cargarVeterinarios(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"veterinario.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] veterinario = line.split(";");
                    if(veterinario.length == 8){
                        String nombre = veterinario[0];
                        String email = veterinario[1];
                        String especialidad = veterinario[2];
                        byte experiencia = Byte.parseByte(veterinario[3]);
                        int sueldo = Integer.parseInt(veterinario[4]);
                        long idTarjetaProfesional = Long.parseLong(veterinario[5]);
                        String usuario = veterinario[6];
                        String contraseña = veterinario[7];

                        usuarios.put(usuario, new Veterinario(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,contraseña));
                    }
                    else if(veterinario.length == 6) {
                        String nombre = veterinario[0];
                        String email = veterinario[1];
                        String especialidad = veterinario[2];
                        byte experiencia = Byte.parseByte(veterinario[3]);
                        long idTarjetaProfesional = Long.parseLong(veterinario[5]);
                        String usuario = veterinario[6];
                        String contraseña = veterinario[7];

                        usuarios.put(usuario, new Veterinario(nombre,email,experiencia,idTarjetaProfesional,usuario,contraseña));
                    }else{
                        //error de registro
                    }

                }
            }
            br.close();
        } catch (Exception e){

        }


    }

    public static void cargarMascotas(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"mascota.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] mascota = line.split(";");
                    String nombre = mascota[0];
                    String[] fechaNacimientoString = mascota[1].split("/");
                    int año = Integer.parseInt(fechaNacimientoString[0]);
                    int mes = Integer.parseInt(fechaNacimientoString[1]);
                    int dia = Integer.parseInt(fechaNacimientoString[2]);
                    Date fechaNacimiento = new Date(año,mes,dia);
                    char sexo = mascota[2].charAt(0);
                    String especie = mascota[3];
                    String raza = mascota[4];
                    String usuarioDueño = mascota[5];
                    Cliente dueño = (Cliente) usuarios.get(usuarioDueño);

                    if(!mascotas.containsKey(usuarioDueño)){
                        HashMap<String,Mascota> datosMascota = new HashMap<>();
                        datosMascota.put(nombre, new Mascota(nombre, fechaNacimiento, sexo, especie, raza, dueño));
                        mascotas.put(usuarioDueño, datosMascota);

                    }else {

                        HashMap<String,Mascota> datosMascotas = (HashMap<String, Mascota>) mascotas.get(usuarioDueño).clone();
                        datosMascotas.put(nombre, new Mascota(nombre, fechaNacimiento, sexo, especie, raza, dueño));
                        mascotas.put(usuarioDueño,datosMascotas);

                    }
                }
            }
            br.close();
        } catch (Exception e){
            /*
            * Un posible error, es que el dueño no exista (por ingresar mal el dato a la base de datos).
            * */
        }

    }

    public static void cargarCitas(String ruta){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta+"cita.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] cita = line.split(";");
                    int id = Integer.parseInt(cita[0]);
                    String[] fechaCitaString = cita[1].split("/");
                    int año = Integer.parseInt(fechaCitaString[2]);
                    int mes = Integer.parseInt(fechaCitaString[1]);
                    int dia = Integer.parseInt(fechaCitaString[0]);
                    Date fecha = new Date(año,mes,dia);
                    Veterinario veterinario = (Veterinario) usuarios.get(cita[1]);
                    Cliente cliente = (Cliente) usuarios.get(cita[2]);
                    citas.put(id,new Cita(fecha,veterinario,cliente));
                }
            }
            br.close();
        } catch (Exception e){
            /*
            * Un posible error, es que el usuario de veterinario o cliente esté escrito diferente.
            * */
        }

    }

    public static void cargarMenuUsuarios(String ruta){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta+"menuUsuario.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] menu = line.split(";");
                    String rol = menu[0];
                    if(rol.equals("cliente")){
                        menuCliente = Arrays.copyOfRange(menu,1,menu.length);
                        //uiMain.MenuDeConsola.newMenu();
                    }
                    else if(rol.equals("veterinario")){
                        menuVeterinario = Arrays.copyOfRange(menu,1,menu.length);

                    }
                    else if(rol.equals("administrador")){
                        menuAdministrador = Arrays.copyOfRange(menu,1,menu.length);
                    }

                }
            }
            br.close();
        }catch (Exception e){

        }
    }

    public static void guardarDatos(){
        crearArchivos();
        String ruta = System.getProperty("user+dir")+"\\src\\temp";
        guardarDatosUsuario(ruta);
        guardarMenus(ruta);
    }

    public static void crearArchivos(){
        try{
            String ruta = System.getProperty("user+dir")+"\\src\\temp";
            File directorio = new File(ruta);
            if(!directorio.exists()){
                directorio.mkdir();
            }
            File administrador = new File(ruta+"administrador.txt");
            File cita = new File(ruta+"cita.txt");
            File mascota = new File(ruta+"mascota.txt");
            File menuUsuario = new File(ruta+"menuUsuario");
            File procedimiento = new File(ruta+"procedimiento.txt");
            File usuario = new File(ruta +"usuario.txt");
            File veterinario = new File(ruta+"veterinario.txt");
            administrador.createNewFile();
            cita.createNewFile();
            mascota.createNewFile();
            menuUsuario.createNewFile();
            procedimiento.createNewFile();
            usuario.createNewFile();
            veterinario.createNewFile();
        } catch (IOException e){

        }
    }

    public static void guardarDatosUsuario(String ruta){
        try{
            PrintWriter outCliente = new PrintWriter(new FileWriter(ruta+"cliente.txt"));
            PrintWriter outVeterinario = new PrintWriter(new FileWriter(ruta+"veterinario.txt"));
            PrintWriter outAdministrador = new PrintWriter(new FileWriter(ruta+"administrador.txt"));
            for (Map.Entry<String,Persona> usuario: usuarios.entrySet()) {
                Persona persona = usuario.getValue();
                String line = persona.getNombre()+";";
                line += persona.getEmail()+";";
                line += persona.getNombreUsuario()+";";
                line += persona.getContraseña();
                if (persona instanceof Cliente){
                    outCliente.println(line);
                }
                else if (persona instanceof Administrador ){
                    outAdministrador.println(line);
                }
                else if (persona instanceof Veterinario){
                    line = persona.getNombre()+";";
                    line += persona.getEmail()+";";
                    line += ((Veterinario) persona).getEspecialidad()+";";
                    line += ((Veterinario) persona).getExperiencia()+";";
                    line += ((Veterinario) persona).getSueldo()+";";
                    line += ((Veterinario) persona).getIdProfesional()+";";
                    line += persona.getNombreUsuario()+";";
                    line += persona.getContraseña();
                    outVeterinario.println(line);
                }

            }
            outAdministrador.close();
            outCliente.close();
            outVeterinario.close();
        } catch (Exception e){

        }


    }

    public static void guardarMenus(String ruta){
        try {
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"menuUsuario"));
            String line ="";
            line += "cliente;";
            for (int i = 0; i < menuCliente.length-1 ; i++) {
                line += menuCliente[i]+";";
            }
            line += menuCliente[menuCliente.length-1]+"\n";
            line += "veterinario;";
            for (int i = 0; i < menuVeterinario.length-1 ; i++) {
                line += menuVeterinario[i]+";";
            }
            line += menuVeterinario[menuVeterinario.length-1]+"\n";
            line += "administrador;";
            for (int i = 0; i < menuAdministrador.length-1; i++) {
                line += menuAdministrador[i]+";";
            }
            line += menuAdministrador[menuAdministrador.length-1]+"\n";

        } catch (Exception e){

        }
    }

}

