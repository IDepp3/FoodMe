package com.utn.teamA.ConexionDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utn.teamA.ConexionDatos.interfaces.ObtenerDatos;
import com.utn.teamA.clases.Cliente;
import com.utn.teamA.excepciones.ClienteNoExiste;
import com.utn.teamA.excepciones.NoExisteReserva;

public class AccesoClientes implements ObtenerDatos<Cliente>{

    // region Atributos

    private final String url = "src/main/recursos/archivos/clientes.json";
    private Gson json;

    // endregion

    // region Constructores

    public AccesoClientes(){
        this.json = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }

    // endregion

    // region Implementacion Metodos Interfaz

    @Override
    public Cliente obtenerRegistro(Cliente t) {
        Cliente cliente = null;
        List<Cliente> clientes = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < clientes.size()){
            if(clientes.get(i).equals(t)){
                cliente = clientes.get(i);
                resp = true;
            }
            i++;
        }
        return cliente;
    }

    public Cliente obtenerRegistroUsuarioPassword(Cliente t){
        Cliente cliente = null;
        List<Cliente> clientes = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < clientes.size()){
            if(clientes.get(i).getUsername().equals(t.getUsername()) && clientes.get(i).getPassword().equals(t.getPassword())){
                cliente = clientes.get(i);
                resp = true;
            }
            i++;
        }
        return cliente;
    }

    public Cliente obtenerRegistroXDni(Cliente t){
        Cliente cliente = null;
        List<Cliente> clientes = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < clientes.size()){
            if(clientes.get(i).getDni() != null){
                if(clientes.get(i).getDni().equals(t.getDni())){
                    cliente = clientes.get(i);
                    resp = true;
                }
            }
            i++;
        }
        return cliente;
    }


    public Cliente buscarCliente(String username) throws ClienteNoExiste {
        boolean resp = false;
        int i = 0;
        List<Cliente> clientes = obtenerRegistros();
        Cliente cliente = null;

        while (!resp && i < clientes.size()) {
            if ((clientes.get(i).getUsername().equals(username))) {
                cliente = clientes.get(i);
                resp = true;
            }
            i++;
        }
        if(cliente!=null ){
            return cliente;
        }else throw new ClienteNoExiste("El cliente no existe");

    }

    public static void main(String[] args) throws ClienteNoExiste {
        AccesoClientes  uno = new AccesoClientes();
        Cliente cliente = uno.buscarCliente("Anto.123");
        cliente.mostrar();
    }
    @Override
    public List<Cliente> obtenerRegistros() {
        List<Cliente> clientes = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.url));
            arregloALista(this.json.fromJson(reader, Cliente[].class), clientes);
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean actualizarRegistro(Cliente t) {
        boolean resp = false;
        boolean actualizado = false;
        List<Cliente> clientes = obtenerRegistros();
        int i = 0;

        while(!resp && i < clientes.size()){
            if(clientes.get(i).equals(t)){
                clientes.remove(i);
                clientes.add(i, t);
                resp = true;
                if(guardarInformacion(clientes))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }

    @Override
    public boolean borrarRegistro(Cliente t) {
        boolean resp = false;
        List<Cliente> clientes = obtenerRegistros();
        int i = 0;
        
        while(!resp && i < clientes.size()){
            if(clientes.get(i).equals(t)){
                clientes.get(i).setEstado(false);
                if(guardarInformacion(clientes))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    @Override
    public boolean agregarRegistro(Cliente t) {
        boolean resp = false;
        List<Cliente> clientes = obtenerRegistros();

        if(!existeRegistro(clientes, t)){
            clientes.add(t);
            if(guardarInformacion(clientes))
                resp = true;
        }
        return resp;
    }

    
    // endregion

    // region Metodos propios

    public boolean guardarInformacion(List<Cliente> clientes){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            this.json.toJson(clientes.toArray(), Cliente[].class, writer);
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }

        return resp;
    }

    public boolean existeRegistro(List<Cliente> clientes, Cliente cliente){
        boolean resp = false;
        int i = 0;

        while(!resp && i < clientes.size()){
            if(clientes.get(i).existeUsuario(cliente))
                resp = true;
            i++;
        }

        return resp;
    }

    public void arregloALista(Cliente[] arreglo, List<Cliente> clientes){
        if(arreglo != null){
            for(Cliente c : arreglo){
                clientes.add(c);
            }
        }
    }

    private void crearFichero(){
        FileWriter writer;
        try{
            writer = new FileWriter(this.url);
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // endregion


}
