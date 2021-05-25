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
import com.utn.teamA.ConexionDatos.interfaces.ObtenerDatos;

public abstract class DatosArchivos<T> implements ObtenerDatos<T>{

    // region ATRIBUTOS

    private String url;
    private Type tipo;
    private Gson json;

    // endregion

    // region CONSTRUCTORES

    public DatosArchivos(String url, Type type){
        this.url  = url;
        this.tipo = type;
        this.json = new Gson();
    }

    // endregion

    // region IMPLEMENTACION DE METODOS

    @Override
    public boolean crearRegistro(T t) {
        boolean resp = false;
        List<T> list = obtenerRegistros();
        if(!existeRegistro(list, t)){
            list.add(t);
            if(guardarTodo(list))
                resp = true;
        }

        return resp;
    }

    @Override
    public List<T> obtenerRegistros() {
        List<T> list = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(this.url));
            arregloALista(this.json.fromJson(reader, this.tipo), list);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo especificado no se encuentra");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public T obtenerRegistro(T t) {
        T registro = null;
        List<T> list = obtenerRegistros();
        if(list.size() > 0){
            int i = 0;
            boolean resp = false;
            while(!resp && i < list.size()){
                if(list.get(i).equals(t)){
                    registro = list.get(i);
                    resp = true;
                }
                i++;
            }
        }
        return registro;
    }

    @Override
    public boolean actualizarRegistro(T t) {
        boolean resp = false,
                encontrado = false;
        List<T> list = obtenerRegistros();
        int i = 0;
        while(!encontrado && i < list.size()){
            if(list.get(i).equals(t)){
                list.remove(i);
                list.add(i, t);
                encontrado = true;
                if(encontrado && guardarTodo(list))
                    resp = true;
            }
            i++;
        }
        return resp;
    }

    @Override
    public boolean borrarRegistro(T t) {
        boolean resp = false, 
                encontrado = false;
        List<T> list = obtenerRegistros();
        int i = 0;
        while(!encontrado && i < list.size()){
            if(list.get(i).equals(t)){
                list.remove(i);
                encontrado = true;
                if(encontrado && guardarTodo(list))
                    resp = true;
            }
            i++;
        }
        return resp;
    }
   
    // endregion

    // region METODOS 

    private void arregloALista(T[] arreglo, List<T> list){
        if(arreglo != null){
            for(T elemento : arreglo){
                list.add(elemento);
            }
        }
    }

    private boolean guardarTodo(List<T> list){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            this.json.toJson(list.toArray(),this.tipo, writer);
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("El archivo especificado no existe");
        }

        return resp;
    }

    public abstract boolean existeRegistro(List<T> list, T t);
}
