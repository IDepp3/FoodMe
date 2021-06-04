package com.utn.teamA.ConexionDatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.utn.teamA.ConexionDatos.interfaces.ObtenerDatos;
import com.utn.teamA.clases.Cliente;
import com.utn.teamA.clases.Persona;
import com.utn.teamA.clases.Reserva;
import com.utn.teamA.ConexionDatos.Gson.LocalDateDeserializer;
import com.utn.teamA.ConexionDatos.Gson.LocalDateSerializer;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccesoReservas implements ObtenerDatos<Reserva> {

    // region Atributos



    private final String url = "src/main/recursos/archivos/reservas.json";

    private Gson json;

    // endregion

    // region Constructores

    public AccesoReservas()throws JsonParseException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
       this.json = gsonBuilder.setPrettyPrinting().serializeNulls().create();

    }

    // endregion

    // region Implementacion Metodos Interfaz

    @Override
    public Reserva obtenerRegistro(Reserva t) {
        Reserva reserva = null;
        List<Reserva> reservas = obtenerRegistros();
        boolean resp = false;
        int i = 0;

        while (!resp && i < reservas.size()) {
            if (reservas.get(i).esIgual(t)) {
                reserva = reservas.get(i);
                resp = true;
            }
            i++;
        }
        return reserva;
    }


    @Override
    public List<Reserva> obtenerRegistros() {
        List<Reserva> reservas = null;
        BufferedReader reader;
        try {
            reservas = new ArrayList<>();
            reader = new BufferedReader(new FileReader(this.url));
            // TODO a investigar recordar descomentar linea y comentar arregloALista();
            //reserva = Arrays.asList(this.json.fromJson(reader, Reserva[].class));
            arregloALista(this.json.fromJson(reader, Reserva[].class), reservas);
            reader.close();
        } catch (FileNotFoundException e) {
            crearFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return reservas;
    }

    @Override
    public boolean actualizarRegistro(Reserva reserva) {
        boolean resp = false;
        boolean actualizado = false;
        List<Reserva> reservas = obtenerRegistros();
        int i = 0;

        while (!resp && i < reservas.size()) {
            if (reservas.get(i).equals(reserva)) {
                reservas.remove(i);
                reservas.add(i, reserva);
                resp = true;
                if (guardarInformacion(reservas))
                    actualizado = true;
            }
            i++;
        }

        return actualizado;
    }

    @Override
    public boolean borrarRegistro(Reserva t) {
        boolean resp = false;
        List<Reserva> reservas = obtenerRegistros();
        int i = 0;

        while (!resp && i < reservas.size()) {
            if (reservas.get(i).equals(t)) {
                reservas.remove(i);
                if (guardarInformacion(reservas))
                    resp = true;
            }
            i++;
        }

        return resp;
    }

    @Override
    public boolean agregarRegistro(Reserva t) {

        boolean resp = false;
        List<Reserva> reservas = obtenerRegistros();

        if (!existeRegistro(reservas, t)) {
            reservas.add(t);
            if (guardarInformacion(reservas))
                resp = true;
        }
        guardarInformacion(reservas);
        return resp;
    }

    // endregion

    // region Metodos propios

    public boolean guardarInformacion(List<Reserva> reservas) {
        boolean resp = false;
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(this.url));
            this.json.toJson(reservas.toArray(), Reserva[].class, writer);
            writer.close();
            resp = true;
        } catch (IOException e) {
            System.out.println("Algo salio mal y no se guardo la informacion");
        }catch (Exception e){

        }

        return resp;
    }

    private boolean existeRegistro(List<Reserva> reservas, Reserva reserva) {
        boolean resp = false;
        int i = 0;

        while (!resp && i < reservas.size()) {
            if (reservas.get(i).esIgual(reserva))
                resp = true;
            i++;
        }

        return resp;
    }

    public void arregloALista(Reserva[] arreglo, List<Reserva> reservas) {
        if (arreglo != null) {
            for (Reserva c : arreglo) {
                reservas.add(c);
            }
        }
    }

    private void crearFichero() {
        FileWriter writer;
        try {
            writer = new FileWriter(this.url);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrar(Reserva reserva){
        System.out.println(json.toJson(reserva));
    }

    // endregion
}



