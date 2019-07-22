package BaseDatos;

import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;
import gestorAplicacion.Usuarios.Persona;

import java.util.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Data{

    public static HashMap<String, Persona> usuarios = new HashMap<>();
    public static HashMap<Integer,Mascota > mascotas = new HashMap<>();
    public static HashMap<Integer, Cita> citas = new HashMap<>();
    public static HashMap<Integer,Mascota> hospitalizados = new HashMap<>();
    public static ArrayList<Integer> menuCliente = new ArrayList<>();
    public static ArrayList<Integer> menuVeterinario = new ArrayList<>();
    public static ArrayList<Integer> menuAdministrador = new ArrayList<>();
    public static ArrayList<Veterinario> veterinarios =new ArrayList<>();
    public static void cargarDatos(){
        String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
        cargarClientes(ruta);
        cargarAdministradores(ruta);
        cargarVeterinarios(ruta);
        cargarMascotas(ruta);
        cargarCitas(ruta);
        cargarMenuUsuarios(ruta);
        cargarClinica(ruta);
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
                    String key = cliente[3];
                    usuarios.put(usuario, new Cliente(nombre,email,usuario,key));
                }
            }
            br.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void cargarAdministradores(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"administrador.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] administrador = line.split(";");
                    String nombre = administrador[0];
                    String email = administrador[1];
                    String usuario = administrador[2];
                    String key = administrador[3];
                    usuarios.put(usuario, new Administrador(nombre,email,usuario,key));
                    System.out.println(usuario);
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
                        String key = veterinario[7];

                        usuarios.put(usuario, new Veterinario(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,key));
                    }
                    else if(veterinario.length == 6) {
                        String nombre = veterinario[0];
                        String email = veterinario[1];
                        String especialidad = veterinario[2];
                        byte experiencia = Byte.parseByte(veterinario[3]);
                        long idTarjetaProfesional = Long.parseLong(veterinario[5]);
                        String usuario = veterinario[6];
                        String key = veterinario[7];

                        usuarios.put(usuario, new Veterinario(nombre,email,experiencia,idTarjetaProfesional,usuario,key));
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
                    int Id = Integer.parseInt(mascota[0]);
                    String nombre = mascota[1];
                    String[] fechaNacimientoString = mascota[2].split("/");
                    int año = Integer.parseInt(fechaNacimientoString[0]);
                    int mes = Integer.parseInt(fechaNacimientoString[1]);
                    int dia = Integer.parseInt(fechaNacimientoString[2]);
                    Date fechaNacimiento = new Date(año,mes,dia);
                    char sexo = mascota[3].charAt(0);
                    String especie = mascota[4];
                    String raza = mascota[2];
                    String usuarioDueño = mascota[6];
                    Cliente dueño = (Cliente) usuarios.get(usuarioDueño);
                    mascotas.put(Id,new Mascota(nombre,fechaNacimiento,sexo,especie,raza,dueño));
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
                    int hora = Integer.parseInt(fechaCitaString[3]);
                    int minuto = Integer.parseInt(fechaCitaString[4]);
                    Date fecha = new Date(año,mes,dia,hora,minuto);
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
                        for (int i = 1; i < menu.length; i++) {
                            menuCliente.add(Integer.parseInt(menu[i]));
                        }

                        //uiMain.MenuDeConsola.newMenu();
                    }

                    else if(rol.equals("veterinario")){

                        for (int i = 1; i < menu.length; i++) {
                            menuVeterinario.add(Integer.parseInt(menu[i]));
                        }
                    }

                    else if(rol.equals("administrador")){
                        for (int i = 1; i < menu.length; i++) {
                            menuAdministrador.add(Integer.parseInt(menu[i]));
                        }
                    }

                }
            }
            br.close();

        }catch (Exception e){

        }
    }

    public static void cargarClinica(String ruta){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta+"hospitalizados.txt"));
            String line;
            while((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] datos = line.split(";");
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    hospitalizados.put(id,mascotas.get(id));
                }
            }
        } catch (Exception e){
            /*
            * Un posible error es que no se actualizó correctamente la base de datos
            * y estamos indexando una mascota que no tenemos registrada
            * */
        }
    }

    public static void guardarDatos(){
        crearArchivos();
        String ruta = System.getProperty("user+dir")+"\\src\\temp\\";
        guardarDatosUsuario();
        guardarMenus();
        guardarCitas();
        guardarMascotas();
        guardarClinica();
    }

    public static void crearArchivos(){

        try{
            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
            File directorio = new File(ruta);
            if(!directorio.exists()){
                directorio.mkdir();
            }

            File administrador = new File(ruta+"administrador.txt");
            File cita = new File(ruta+"cita.txt");
            File mascota = new File(ruta+"mascota.txt");
            File menuUsuario = new File(ruta+"menuUsuario.txt");
            File procedimiento = new File(ruta+"procedimiento.txt");
            File cliente = new File(ruta +"cliente.txt");
            File veterinario = new File(ruta+"veterinario.txt");
            File hospitalizados = new File(ruta+"hospitalizados.txt");

            administrador.createNewFile();
            cita.createNewFile();
            mascota.createNewFile();
            menuUsuario.createNewFile();
            procedimiento.createNewFile();
            cliente.createNewFile();
            veterinario.createNewFile();
            hospitalizados.createNewFile();

        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void guardarDatosUsuario(){
        try{
            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
            PrintWriter outCliente = new PrintWriter(new FileWriter(ruta+"cliente.txt"));
            PrintWriter outVeterinario = new PrintWriter(new FileWriter(ruta+"veterinario.txt"));
            PrintWriter outAdministrador = new PrintWriter(new FileWriter(ruta+"administrador.txt"));
            for (Map.Entry<String,Persona> usuario: usuarios.entrySet()) {
                Persona persona = usuario.getValue();
                String line = persona.getNombre()+";";
                line += persona.getEmail()+";";
                line += persona.getNombreUsuario()+";";
                line += persona.getKey();
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
                    line += persona.getKey();
                    outVeterinario.println(line);
                }
            }

            outAdministrador.close();
            outCliente.close();
            outVeterinario.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public static void guardarMenus(){
        try {
            String ruta = System.getProperty("user+dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"menuUsuario"));
            String line ="";
            line += "cliente;";
            for (int i = 0; i < menuCliente.size()-1 ; i++) {
                line += menuCliente.get(i)+";";
            }
            line += menuCliente.get(menuCliente.size()-1)+"\n";
            line += "veterinario;";
            for (int i = 0; i < menuVeterinario.size()-1 ; i++) {
                line += menuVeterinario.get(i)+";";
            }
            line += menuVeterinario.get(menuVeterinario.size()-1)+"\n";
            line += "administrador;";

            for (int i = 0; i < menuAdministrador.size()-1; i++) {
                line += menuAdministrador.get(i)+";";
            }
            line += menuAdministrador.get(menuAdministrador.size()-1);
            out.println(line);
            out.close();
        } catch (Exception e){

        }
    }

    public static void guardarCitas(){

        try {
            String ruta = System.getProperty("user+dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"cita.txt"));
            for (Map.Entry<Integer,Cita> cita : citas.entrySet()) {
                Cita citaProxima = cita.getValue();
                String line = Integer.toString(citaProxima.getId())+";";
                Date fecha = citaProxima.getFechaCita();
                line += fecha.getDay()+"/"+fecha.getMonth()+"/" +fecha.getYear()+"/"
                        +fecha.getHours()+"/" +fecha.getMinutes()+";";
                line += citaProxima.getCliente().getNombreUsuario()+";";
                line += citaProxima.getVeterinario().getNombreUsuario();
                out.println(line);
            }
            out.close();
        } catch (Exception e){

        }

    }

    public static void guardarMascotas(){
        try {
            String ruta = System.getProperty("user+dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"mascota.txt"));
            for (Map.Entry<Integer,Mascota>  indice : mascotas.entrySet()) {
                String line = Integer.toString(indice.getKey())+";";
                line += indice.getValue().getNombre()+";";
                line += indice.getValue().getFechaNacimiento()+";";
                line += indice.getValue().getSexo()+";";
                line += indice.getValue().getEspecie()+";";
                line += indice.getValue().getRaza()+";";
                line += indice.getValue().getAmo().getNombreUsuario();
                out.println(line);
            }
            out.close();
        } catch (Exception e){

        }
    }

    public static void guardarClinica(){
        try {
            String ruta = System.getProperty("user+dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"hospitalizados.txt"));
            for (Map.Entry<Integer,Mascota> hospitalizadas : hospitalizados.entrySet()) {
                String line = Integer.toString(hospitalizadas.getKey())+";";
                line += hospitalizadas.getValue().getNombre();
                out.println(line);
            }
            out.close();
        } catch (Exception e){

        }
    }

}

