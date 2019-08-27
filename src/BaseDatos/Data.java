package BaseDatos;

import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;
import gestorAplicacion.prestacion.Clinica;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Data{

    public  HashMap<String, Persona> usuarios = new HashMap<>();
    public  HashMap<Integer,Mascota > mascotas = new HashMap<>();
    public  HashMap<Integer, Cita> citas = new HashMap<>();
    public  HashMap<Integer,Mascota> hospitalizados = new HashMap<>();
    public  ArrayList<Integer> menuCliente = new ArrayList<>();
    public  ArrayList<Integer> menuVeterinario = new ArrayList<>();
    public  ArrayList<Integer> menuAdministrador = new ArrayList<>();
    public  ArrayList<Veterinario> veterinarios =new ArrayList<>();

    public void cargarDatos(){
        String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
        cargarClientes(ruta);
        cargarAdministradores(ruta);
        cargarVeterinarios(ruta);
        cargarMascotas(ruta);
        cargarCitas(ruta);
        cargarMenuUsuarios(ruta);
        cargarClinica(ruta);

        Persona.setUsuarios(usuarios);
        Mascota.setMascotas(mascotas);
        Cita.setCitas(citas);
        Cliente.setMenuCliente(menuCliente);
        Veterinario.setMenuVeterinario(menuVeterinario);
        Administrador.setMenuAdministrador(menuAdministrador);
        Clinica.setMascotasHospitalizadas(hospitalizados);
        Veterinario.setVeterinarios(veterinarios);
    }

    public void cargarClientes(String ruta){
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
                    String[] menu = cliente[4].split("/");
                    ArrayList<Integer> menuNew = new ArrayList<>();
                    for (int i = 0; i < menu.length; i++) {
                        menuNew.add(Integer.parseInt(menu[i]));
                    }
                    Cliente user =  new Cliente(nombre,email,usuario,key);
                    usuarios.put(usuario,user);
                    user.setMenuPersonal(menuNew);
                }
            }
            br.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public  void cargarAdministradores(String ruta){
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
                    String[] menu = administrador[4].split("/");
                    ArrayList<Integer> menuNew = new ArrayList<>();

                    for (int i = 0; i < menu.length; i++) {
                        menuNew.add(Integer.parseInt(menu[i]));
                    }
                    Administrador admin = new Administrador(nombre,email,usuario,key);
                    usuarios.put(usuario, admin);
                    admin.setMenuPersonal(menuNew);
                }
            }
            br.close();
        } catch (Exception e){

        }

    }

    public  void cargarVeterinarios(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"veterinario.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] veterinario = line.split(";");
                    String nombre = veterinario[0];
                    String email = veterinario[1];
                    String especialidad = veterinario[2];
                    byte experiencia = Byte.parseByte(veterinario[3]);
                    int sueldo = Integer.parseInt(veterinario[4]);
                    long idTarjetaProfesional = Long.parseLong(veterinario[5]);
                    String usuario = veterinario[6];
                    String key = veterinario[7];
                    String[] menu = veterinario[8].split("/");
                    ArrayList<Integer> menuNew = new ArrayList<>();
                    for (int i = 0; i < menu.length; i++) {
                        menuNew.add(Integer.parseInt(menu[i]));
                    }
                    Veterinario vet =  new Veterinario(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,key);
                    usuarios.put(usuario,vet );
                    veterinarios.add((Veterinario) usuarios.get(usuario));
                    vet.setMenuPersonal(menuNew);
                }
            }
            br.close();
        } catch (Exception e){

        }


    }

    public  void cargarMascotas(String ruta){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta+"mascota.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] mascota = line.split(";");
                    int Id = Integer.parseInt(mascota[0]);
                    String nombre = mascota[1];
                    String[] fechaNacimientoString = mascota[2].split("/");
                    int dia = Integer.parseInt(fechaNacimientoString[0]);
                    int mes = Integer.parseInt(fechaNacimientoString[1]);
                    int año = Integer.parseInt(fechaNacimientoString[2]);
                    String fechaNacimiento = dia+"/"+mes+"/"+año;
                    char sexo = mascota[3].charAt(0);
                    String especie = mascota[4];
                    String raza = mascota[5];
                    String usuarioDueño = mascota[6];
                    Cliente dueño = (Cliente) usuarios.get(usuarioDueño);
                    Mascota can = new Mascota(nombre,fechaNacimiento,sexo,especie,raza,dueño);
                    dueño.setMascota(can);
                    mascotas.put(can.getId(),can);
                }
            }
            br.close();
        } catch (Exception e){
            /*
            * Un posible error, es que el dueño no exista (por ingresar mal el dato a la base de datos).
            * */
            System.out.println(e);
        }

    }

    public  void cargarCitas(String ruta){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta+"cita.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] cita = line.split(";");
                    int id = Integer.parseInt(cita[0]);
                    String[] fechaCitaString = cita[1].split("/");
                    int dia = Integer.parseInt(fechaCitaString[0]);
                    int mes = Integer.parseInt(fechaCitaString[1]);
                    int año = Integer.parseInt(fechaCitaString[2]);
                    int hora = Integer.parseInt(fechaCitaString[3]);
                    String fecha = dia+"/"+mes+"/"+año+"/"+hora;
                    Veterinario veterinario = (Veterinario) usuarios.get(cita[2]);
                    Cliente cliente = (Cliente) usuarios.get(cita[3]);
                    Mascota mascota = mascotas.get(Integer.parseInt(cita[4]));
                    Cita aux = new Cita(fecha,veterinario,cliente,mascota);
                    citas.put(id,aux);
                    cliente.setCita(aux,mascota);
                    veterinario.asignarCita(aux);
                }
            }
            br.close();
        } catch (Exception e){

            /*
            * Un posible error, es que el usuario de veterinario o cliente esté escrito diferente.
            * */
        }

    }

    public  void cargarMenuUsuarios(String ruta){
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

    public  void cargarClinica(String ruta){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta+"hospitalizados.txt"));
            String line;
            while((line = br.readLine()) != null){
                if(!line.isEmpty()){
                    String[] datos = line.split(";");
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    Mascota mascota= mascotas.get(id);
                    hospitalizados.put(id,mascota);
                    Clinica.getMascotasHospitalizadas().put(mascota.getId(),mascota);
                }
            }
        } catch (Exception e){
            /*
            * Un posible error es que no se actualizó correctamente la base de datos
            * y estamos indexando una mascota que no tenemos registrada
            * */
        }
    }

    public  void guardarDatos(){
        usuarios = Persona.getUsuarios();
        mascotas = Mascota.getMascotas();
        citas = Cita.getCitas();
        menuCliente = Cliente.getMenuCliente();
        menuVeterinario = Veterinario.getMenuVeterinario();
        menuAdministrador= Administrador.getMenuAdministrador();
        hospitalizados = Clinica.getMascotasHospitalizadas();
        veterinarios = Veterinario.getVeterinarios();

        crearArchivos();
        String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
        guardarDatosUsuario();
        guardarMenus();
        guardarCitas();
        guardarMascotas();
        guardarClinica();
    }

    public  void crearArchivos(){

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

    public  void guardarDatosUsuario(){
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
                line += persona.getKey()+";";
                if (persona instanceof Cliente){
                    ArrayList<Integer> menu = ((Cliente) persona).getMenuPersonal();
                    for (int i = 0; i <menu.size()-1; i++) {
                        line += menu.get(i)+"/";
                    }
                    line += menu.get(menu.size()-1);
                    outCliente.println(line);
                }

                else if (persona instanceof Administrador ){
                    ArrayList<Integer> menu = ((Administrador) persona).getMenuPersonal();
                    for (int i = 0; i <menu.size()-1; i++) {
                        line += menu.get(i)+"/";
                    }
                    line += menu.get(menu.size()-1);
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
                    line += persona.getKey()+";";
                    ArrayList<Integer> menu = ((Veterinario) persona).getMenuPersonal();
                    for (int i = 0; i <menu.size()-1; i++) {
                        line += menu.get(i)+"/";
                    }
                    line += menu.get(menu.size()-1);
                    outVeterinario.println(line);
                }
            }

            outAdministrador.close();
            outCliente.close();
            outVeterinario.close();
        } catch (Exception e){
            System.out.println(" Mera vuelta");
            System.out.println(e);
        }

    }

    public  void guardarMenus(){
        try {

            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"menuUsuario.txt"));
            Collections.sort(menuCliente);
            Collections.sort(menuVeterinario);
            Collections.sort(menuAdministrador);
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
            System.out.println(e);
        }
    }

    public  void guardarCitas(){

        try {
            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"cita.txt"));
            for (Map.Entry<Integer,Cita> cita : citas.entrySet()) {
                Cita citaProxima = cita.getValue();
                String line = citaProxima.getId()+";";
                String fecha = citaProxima.getFechaCita()+";";
                line += fecha;
                line += citaProxima.getVeterinario().getNombreUsuario()+";";
                line += citaProxima.getCliente().getNombreUsuario()+";";
                line += citaProxima.getMascota().getId();
                out.println(line);
            }
            out.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public  void guardarMascotas(){
        try {
            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
            PrintWriter out = new PrintWriter(new FileWriter(ruta+"mascota.txt"));
            for (Map.Entry<Integer,Mascota>  indice : mascotas.entrySet()) {
                String line = Integer.toString(indice.getKey())+";";
                line += indice.getValue().getNombre()+";";
                String fecha = indice.getValue().getFechaNacimiento();
                line += fecha+";";
                line += indice.getValue().getSexo()+";";
                line += indice.getValue().getEspecie()+";";
                line += indice.getValue().getRaza()+";";
                line += indice.getValue().getAmo().getNombreUsuario();
                out.println(line);
            }
            out.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public  void guardarClinica(){
        try {
            String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
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

