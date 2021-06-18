package com.utn.teamA.ConexionDatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utn.teamA.clases.Ingrediente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientePersistencia {

    private final String url = "src/main/recursos/archivos/ingredietes.json";
    private Gson json;

    public IngredientePersistencia(){
        this.json = new GsonBuilder().setPrettyPrinting().create();
    }



    /*
    Gson con el metodo fromJson retorna un arreglo del tipo de dato indicado en uno de sus parametros,
    y dado que con el metodo de java Arrays.asList(), cuando lo transformamos a lista, no nos deja manipular como tal,
    entonces implementamos este metodo para obtener una lista que podamos manipular
    * */
    public void arregloALista(Ingrediente[] arreglo, List<Ingrediente> ingredientes){
        if(arreglo != null){
            for(Ingrediente ing : arreglo){
                ingredientes.add(ing);
            }
        }
    }

    /*
    * Creamos el BufferedReader
    * Retorna una lista con los objetos del archivo o una lista vacia
    * Crea el fichero en caso de que no exista
    *
    */
    public List<Ingrediente> obtenerRegistros() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.url));
           // arregloALista(this.json.fromJson(reader, Ingrediente[].class), ingredientes);
           ingredientes = json.fromJson(reader,new TypeToken<List<Plato>>(){}.getType());
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ingredientes;
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

    public Ingrediente obtenerRegistro(Ingrediente t) {
        Ingrediente ingrediente = null;
        List<Ingrediente> ingredientes = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < ingredientes.size()){
            if(ingredientes.get(i).equals(t)){
                ingrediente = ingredientes.get(i);
                resp = true;
            }
            i++;
        }
        return ingrediente;
    }

    public boolean guardarInformacion(List<Ingrediente> ingredientes){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            String ingredientesJson = this.json.toJson(ingredientes);
            //this.json.toJson(ingredientes.toArray(), Ingrediente[].class, writer);
            writer.write(ingredientesJson);
            writer.flush();
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }

        return resp;
    }

    public boolean actualizarRegistro(Ingrediente t) {
        boolean resp = false;
        boolean actualizado = false;
        List<Ingrediente> ingredientes = obtenerRegistros();
        int i = 0;

        while(!resp && i < ingredientes.size()){
            if(ingredientes.get(i).equals(t)){
                ingredientes.remove(i);
                ingredientes.add(i, t);
                resp = true;
                if(guardarInformacion(ingredientes))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }

    public boolean borrarRegistro(Ingrediente t) {
        boolean resp = false;
        List<Ingrediente> ingredientes = obtenerRegistros();
        int i = 0;

        while(!resp && i < ingredientes.size()){
            if(ingredientes.get(i).equals(t)){
                ingredientes.get(i).setEstado(false);
                if(guardarInformacion(ingredientes))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    private boolean existeRegistro(List<Ingrediente> ingredientes, Ingrediente ingrediente){
        boolean resp = false;
        int i = 0;

        while(!resp && i < ingredientes.size()){
            if(ingredientes.get(i).equals(ingrediente))
                resp = true;
            i++;
        }

        return resp;
    }

    public boolean agregarRegistro(Ingrediente t) {
        boolean resp = false;
        List<Ingrediente> ingredientes = obtenerRegistros();

        if(!existeRegistro(ingredientes, t)){
            ingredientes.add(t);
            if(guardarInformacion(ingredientes))
                resp = true;
        }
        return resp;
    }

}
