package com.utn.teamA.ConexionDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class ManejadorDatos {


    // region ATRIBUTOS

    private String url;
    private Gson json;

    // endregion

    // region CONSTRUCTORES

    public ManejadorDatos(){
        this.json = new Gson();
    }

    // endregion

    // region GETTERS && SETTERS

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }   

    // endregion

    // region METODOS

    public <T> T obtenerRegistro(String url, T t, Type type) {
        List<T> list = obtenerRegistros(url, type);
        T registro = null; 
        if(list.size() != 0){
            registro = obtieneRegistro(list, t);

        }

        return registro;
    }
    
    public <T> List<T> obtenerRegistros(String url, Type type){
        List<T> list = new ArrayList<>();
        T[] arreglo;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(url));
            arreglo = this.json.fromJson(reader, type);
            arregloALista(list, arreglo);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo especificado no se encuentra");
        }
        return list;
    }

    public <T> boolean crearRegistro(String url, T t, Type type){
        boolean resp = false;
        BufferedWriter writer;
        List<T> list = obtenerRegistros(url, type);
        if(!existeRegistro(obtenerRegistros(url, type), t)){
            try {
                writer = new BufferedWriter(new FileWriter(url));
                json.toJson(t, type, writer);
                resp = true; 
            } catch (IOException e) {
                System.out.println("El archivo especificado no existe");
            }
        }
        return false;
    }

    // region METODOS AUX

    private <T> T obtieneRegistro(List<T> list, T t){
        boolean resp = false; 
        T registro = null;
        int i = 0;
        while(!resp && i < list.size() ) {
            if(list.get(i).equals(t)){
                registro = list.get(i);
                resp = true;
            }
            i++;
        }
        return registro;
    }

    private <T> boolean existeRegistro(List<T> list, T t){
        boolean resp = false;
        int i = 0;
        while(!resp && i < list.size()){
            if(list.get(i).equals(t)){
                resp = true;
            }
            i++;
        }
        return false;
    } 

    private <T> void arregloALista(List<T> list, T[] arreglo){
        for(T elemento : arreglo){
            list.add(elemento);
        }
    }


    // endregion
}
