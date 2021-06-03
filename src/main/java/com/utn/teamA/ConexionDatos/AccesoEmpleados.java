package com.utn.teamA.ConexionDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utn.teamA.ConexionDatos.interfaces.ObtenerDatos;
import com.utn.teamA.clases.Cliente;
import com.utn.teamA.clases.Empleado;

public class AccesoEmpleados implements ObtenerDatos<Empleado>{
    
    private final String url = "src\\main\\recursos\\archivos\\empleados.json";
    private Gson json;

    
    public AccesoEmpleados(){
        this.json = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public Empleado obtenerRegistro(Empleado t) {
        Empleado empleado = null;
        List<Empleado> empleados = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < empleados.size()){
            if(empleados.get(i).equals(t)){
                empleado = empleados.get(i);
                System.out.println("\nSe encontro un empleado: " + empleado);
                resp = true;
            }
            i++;
            
        }
        
        return empleado;
    }

    @Override
    public List<Empleado> obtenerRegistros() {
        List<Empleado> empleados = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.url));
            // TODO a investigar recordar descomentar linea y comentar arregloALista();
            //empleados = Arrays.asList(this.json.fromJson(reader, Empleado[].class));
            arregloALista(this.json.fromJson(reader, Empleado[].class), empleados);
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    @Override
    public boolean actualizarRegistro(Empleado t) {
        boolean resp = false;
        boolean actualizado = false;
        List<Empleado> empleados = obtenerRegistros();
        int i = 0;

        while(!resp && i < empleados.size()){
            if(empleados.get(i).equals(t)){
                empleados.remove(i);
                empleados.add(i, t);
                resp = true;
                if(guardarInformacion(empleados))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }

    @Override
    public boolean borrarRegistro(Empleado t) {
        boolean resp = false;
        List<Empleado> empleados = obtenerRegistros();
        int i = 0;
        
        while(!resp && i < empleados.size()){
            if(empleados.get(i).equals(t)){
                empleados.remove(i);
                if(guardarInformacion(empleados))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    @Override
    public boolean agregarRegistro(Empleado t) {
        boolean resp = false;
        List<Empleado> empleados = obtenerRegistros();

        if(!existeRegistro(empleados, t)){
            empleados.add(t);
            if(guardarInformacion(empleados))
                resp = true;
        }
        return resp;
    }
    
    // endregion

    // region Metodos propios

    public boolean guardarInformacion(List<Empleado> empleados){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            this.json.toJson(empleados.toArray(), Empleado[].class, writer);
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }

        return resp;
    }

    private boolean existeRegistro(List<Empleado> empleados, Empleado empleado){
        boolean resp = false;
        int i = 0;

        while(!resp && i < empleados.size()){
            if(empleados.get(i).equals(empleado))
                resp = true;
            i++;
        }

        return resp;
    }

    public void arregloALista(Empleado[] arreglo, List<Empleado> empleados){
        if(arreglo != null){
            for(Empleado c : arreglo){
                empleados.add(c);
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





}
