package com.utn.teamA.ConexionDatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.utn.teamA.clases.Plato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlatoPersistencia {

    private final String url = "src/main/recursos/archivos/platos.json";
    private Gson json;

    public PlatoPersistencia(){
        this.json = new GsonBuilder().setPrettyPrinting().create();
    }

   public void arregloALista(Plato[] arreglo, List<Plato> platos){
        if(arreglo != null){
            for(Plato p : arreglo){
                platos.add(p);
            }
        }
    }

    public List<Plato> obtenerRegistros() {
        List<Plato> platos = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.url));

            //arregloALista(this.json.fromJson(reader, Plato[].class), platos);
            platos = json.fromJson(reader, new TypeToken<List<Plato>>(){}.getType());
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return platos;
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

    public Plato obtenerRegistro(Plato t) {
        Plato plato = null;
        List<Plato> platos = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < platos.size()){
            if(platos.get(i).equals(t)){
                plato = platos.get(i);
                resp = true;
            }
            i++;
        }
        return plato;
    }

    public boolean guardarInformacion(List<Plato> platos){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            String platosJSon = this.json.toJson(platos);
            writer.write(platosJSon);
            writer.flush();
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }

        return resp;
    }

    public boolean actualizarRegistro(Plato t) {
        boolean resp = false;
        boolean actualizado = false;
        List<Plato> platos = obtenerRegistros();
        int i = 0;

        while(!resp && i < platos.size()){
            if(platos.get(i).equals(t)){
                platos.remove(i);
                platos.add(i, t);
                resp = true;
                if(guardarInformacion(platos))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }

    public boolean borrarRegistro(Plato t) {
        boolean resp = false;
        List<Plato> platos = obtenerRegistros();
        int i = 0;

        while(!resp && i < platos.size()){
            if(platos.get(i).equals(t)){
                //platos.remove(i);
                platos.get(i).setEstado(false);
                if(guardarInformacion(platos))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    private boolean existeRegistro(List<Plato> platos, Plato plato){
        boolean resp = false;
        int i = 0;
        
        while(!resp && i < platos.size()){
            if(platos.get(i).equals(plato))
                resp = true;
            i++;
        }

        return resp;
    }

    public boolean agregarRegistro(Plato t) {
        boolean resp = false;
        List<Plato> platos = obtenerRegistros();

        if(platos == null){
            platos = new ArrayList<>();
        }

        if(!existeRegistro(platos, t)){
            platos.add(t);
            if(guardarInformacion(platos))
                resp = true;
        }
        return resp;
    }
}
