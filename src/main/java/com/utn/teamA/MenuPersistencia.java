package com.utn.teamA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuPersistencia {

    private final String url = "src/main/recursos/archivos/menu.json";
    private Gson json;

    public MenuPersistencia(){
        this.json = new GsonBuilder().setPrettyPrinting().create();
    }

    public void arregloALista(Menu[] arreglo, List<Menu> menus){
        if(arreglo != null){
            for(Menu m : arreglo){
                menus.add(m);
            }
        }
    }

    public List<Menu> obtenerRegistros() {
        List<Menu> menus = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.url));
            arregloALista(this.json.fromJson(reader, Menu[].class), menus);
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return menus;
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

    public Menu obtenerRegistro(Menu t) {
        Menu menu = null;
        List<Menu> menus = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while(!resp && i < menus.size()){
            if(menus.get(i).equals(t)){
                menu = menus.get(i);
                resp = true;
            }
            i++;
        }
        return menu;
    }

    public boolean guardarInformacion(List<Menu> menus){
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            this.json.toJson(menus.toArray(), Menu[].class, writer);
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }

        return resp;
    }

    public boolean actualizarRegistro(Menu t) {
        boolean resp = false;
        boolean actualizado = false;
        List<Menu> menus = obtenerRegistros();
        int i = 0;

        while(!resp && i < menus.size()){
            if(menus.get(i).equals(t)){
                menus.remove(i);
                menus.add(i, t);
                resp = true;
                if(guardarInformacion(menus))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }


    public boolean borrarRegistro(Menu t) {
        boolean resp = false;
        List<Menu> menus = obtenerRegistros();
        int i = 0;

        while(!resp && i < menus.size()){
            if(menus.get(i).equals(t)){
                //menus.remove(i);
                menus.get(i).setEstado(false);
                if(guardarInformacion(menus))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    private boolean existeRegistro(List<Menu> menus, Menu menu){
        boolean resp = false;
        int i = 0;

        while(!resp && i < menus.size()){
            if(menus.get(i).equals(menu))
                resp = true;
            i++;
        }

        return resp;
    }


    public boolean agregarRegistro(Menu t) {
        boolean resp = false;
        List<Menu> menus = obtenerRegistros();

        if(!existeRegistro(menus, t)){
            menus.add(t);
            if(guardarInformacion(menus))
                resp = true;
        }
        return resp;
    }

}
